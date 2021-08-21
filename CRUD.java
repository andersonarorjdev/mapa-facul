import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;

class CRUD<T extends Registro> {

    private final byte Valid = 1;
    private final byte Invalid = 0;
    private final int Head = 0;
    private Constructor<T> Construtors;
    private RandomAccessFile arq;

    public CRUD(String name_arq, Constructor<T> Construtors) throws Exception {
        this.Construtors = Construtors;
        arq = new RandomAccessFile(name_arq, "rw");

    }

    public int Create(T obj) throws Exception {
        int lastId;
        arq.seek(Head);

        if (arq.length() == 0) {
            lastId = 0;
        } else {
            lastId = arq.readInt();
        }

        /* Head File */
        obj.setId(lastId + 1);
        arq.seek(Head);
        arq.writeInt(obj.getId());
        arq.seek(arq.length());

        /* Content File */
        arq.writeByte(Valid);
        arq.writeShort(obj.toByteArray().length);
        arq.write(obj.toByteArray());

        return obj.getId();
    }

    public T Read(int id) throws Exception {

        if (arq.length() > 0) {
            T obj = Construtors.newInstance();
            arq.seek(Integer.BYTES);

            while (arq.getFilePointer() < arq.length()) {

                if (Invalid == arq.readByte()) {
                    arq.seek(arq.readShort() + arq.getFilePointer());
                } else {
                    byte[] ba = new byte[arq.readShort()];
                    arq.read(ba);
                    obj.fromByteArray(ba);

                    if (obj.getId() == id) {
                        return obj;
                    }
                }
            }
        }
        return null;
    }

    public Boolean Update(T obj_update) throws Exception {

        if (arq.length() > 0) {
            long Pointer;

            T obj = Construtors.newInstance();

            arq.seek(Integer.BYTES);

            while (arq.getFilePointer() < arq.length()) {
                Pointer = arq.getFilePointer();

                if (Invalid == arq.readByte()) {
                    arq.seek(arq.readShort() + arq.getFilePointer());
                } else {

                    byte[] ba = new byte[arq.readShort()];
                    arq.read(ba);
                    obj.fromByteArray(ba);

                    if (obj.getId() == obj_update.getId()) {
                        if (obj.toByteArray().length > obj_update.toByteArray().length
                                || obj.toByteArray().length < obj_update.toByteArray().length) {
                            arq.seek(Pointer);
                            arq.writeByte(Invalid);
                            arq.seek(arq.length());
                            arq.writeByte(Valid);
                            arq.writeShort(obj_update.toByteArray().length);
                            arq.write(obj_update.toByteArray());
                        } else {
                            arq.seek(Pointer + Byte.BYTES + Short.BYTES);
                            arq.write(obj_update.toByteArray());
                        }

                        return true;
                    }
                }

            }

        }
        return false;
    }

    public Boolean Delete(int id) throws Exception {

        if (arq.length() > 0) {
            long Pointer;
            T obj = Construtors.newInstance();
            arq.seek(Integer.BYTES);

            while (arq.getFilePointer() < arq.length()) {
                Pointer = arq.getFilePointer();

                if (Invalid == arq.readByte()) {
                    arq.seek(arq.readShort() + arq.getFilePointer());
                } else {

                    byte[] ba = new byte[arq.readShort()];
                    arq.read(ba);
                    obj.fromByteArray(ba);

                    if (obj.getId() == id) {
                        arq.seek(Pointer);
                        arq.writeByte(Invalid);
                        return true;
                    }

                }

            }
        }
        return false;
    }
}