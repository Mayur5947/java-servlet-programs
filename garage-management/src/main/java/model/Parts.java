package model;

public class Parts {

    private int part_id;
    private int price;
    private int qty_available;
    private String part_name;

    public int getPart_id() {
        return part_id;
    }

    public void setPart_id(int part_id) {
        this.part_id = part_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty_available() {
        return qty_available;
    }

    public void setQty_available(int qty_available) {
        this.qty_available = qty_available;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "part_id=" + part_id +
                ", price=" + price +
                ", qty_available=" + qty_available +
                ", part_name='" + part_name + '\'' +
                '}';
    }
}
