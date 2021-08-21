
import java.io.*;


class Produto implements Registro {
    private int id;
    private String name;
    private double price;
    private String unity;
    private int quantityStorage;

    Produto(int id, String name, double price, String unity, int quantityStorage) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.unity = unity;
        this.quantityStorage = quantityStorage;

    }

    Produto(String name, double price, String unity, int quantityStorage) {
        
        this.id = -1;
        this.name = name;
        this.price = price;
        this.unity = unity;
        this.quantityStorage = quantityStorage;
   
    }

    public Produto() {

        this.id = -1;
        this.name = "undefined";
        this.price = 0f;
        this.unity = "undefined";
        this.quantityStorage = 0;

    }

    public String getName() {
        return this.name;
    }

    // getters
    public double getprice() {
        return this.price;
    }

    public String getUnity() {
        return this.unity;
    }

    public int getQuantityStorage() {
        return this.quantityStorage;
    }

    public int getId() {
        return this.id;
    }

    // setters
    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantityStorage(int quantityStorage) {
        this.quantityStorage = quantityStorage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(this.id);
        dos.writeUTF(this.name);
        dos.writeDouble(this.price);
        dos.writeUTF(this.unity);
        dos.writeInt(this.quantityStorage);
        return baos.toByteArray();
    }

    @Override
    public void fromByteArray(byte[] ba) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        DataInputStream dis = new DataInputStream(bais);
        this.id = dis.readInt();
        this.name = dis.readUTF(); 
        this.price = dis.readDouble();
        this.unity = dis.readUTF();
        this.quantityStorage = dis.readInt();
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\n" + "name: " + this.name + "\n" + "price: " + this.price + "\n" + 
        "unity; " + this.unity + "\n" + "QuantityStorage: " + this.quantityStorage;
    }

}
