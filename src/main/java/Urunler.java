public class Urunler {
    String id;
    String name;
    Double price;


    public Urunler(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "id=" + id +
                " name=" + name +
                " price=" + price+"\n";
    }


    public String toString1() {
        return "id=" + id +
                " name=" + name +
                " price=" + price+ "  Kilo "+ Depo.kilo+"\n";
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
