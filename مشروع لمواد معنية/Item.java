public class Item {
    private int QTY;
    private double Price;
    private int Code;
    private String name;
    public Item(){}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getQTY() {return QTY;}
    public int getCode() {return Code;}
    public void setCode(int code) {Code = code;}
    public void setQTY(int QTY) {this.QTY = QTY;}
    public double getPrice() {return Price;}
    public void setPrice(double price) {Price = price;}
}
