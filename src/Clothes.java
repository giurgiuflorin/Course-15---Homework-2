public class Clothes implements ShopItem {

    private String name;
    private Category category;
    private int price;

    public Clothes(String name, Category category, int price) {
        if (price < 0 || name == null) {
            throw new MyException("Negative or null values not allowed!");
        }
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int price() {
        return price;
    }

    @Override
    public Category category() {
        return category;
    }

    @Override
    public String toString() {
        return "Category [" + category + "] " +
                "Price: " + price + "$ " +
                "Name: " + name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
