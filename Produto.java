
import java.io.*;


class Produto  {
    private String name;
    private double price;
    private String unity;
    private int quantityStorage;

    Produto(int id, String name, double price, String unity, int quantityStorage) {

        this.name = name;
        this.price = price;
        this.unity = unity;
        this.quantityStorage = quantityStorage;

    }

    Produto(String name, double price, String unity, int quantityStorage) {
        
        this.name = name;
        this.price = price;
        this.unity = unity;
        this.quantityStorage = quantityStorage;
   
    }

    public Produto() {

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
    
    //entrada
    public void addEstoque(int incremento) {
        this.quantityStorage += incremento;
    }

    //saida
    public void removerEstoque(int decremento) {
         this.quantityStorage -= decremento;
    }

    @Override
    public String toString() {
        return  "name: " + this.name + "\n" + "price: " + this.price + "\n" + 
        "unity: " + this.unity + "\n" + "QuantityStorage: " + this.quantityStorage + "\n";
    }

}
