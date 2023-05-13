import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Clothes objects
        Clothes pants = new Clothes("denim pants", Category.NEW, 12);
//        Clothes pants2 = new Clothes("pants", Category.NEW, -12); - throws exception - negative price;
        Clothes dress = new Clothes("woman dress", Category.NEW, 20);
        Clothes blazer = new Clothes("men blazer", Category.ON_SALE, 10);

        //Fruits objects
        Fruits banana = new Fruits("organic banana", Category.ON_SALE, 5);
        Fruits regularBanana = new Fruits("non-organic banana", Category.ON_SALE, 3);
        Fruits apple = new Fruits("organic apple", Category.NEW, 2);

        //Shop object that contains only clothes
        Shop<Clothes> clothesShop = new Shop<>(new ArrayList<Clothes>());
        clothesShop.addItem(pants);
//        clothesShop.addItem(pants); -- Throws exceptions - object pants already in list;
        clothesShop.addItem(dress);
        clothesShop.addItem(blazer);

        clothesShop.printList();

        System.out.println(clothesShop.findByCategory(Category.NEW));
        System.out.println(clothesShop.findWithHigherPrice(12));
        System.out.println(clothesShop.findWithExactPrice(20));
//        System.out.println(clothesShop.findWithHigherPrice(-12)); - throws exceptions
        System.out.println(clothesShop.findByName("denim pants"));
        clothesShop.removeItem("denim pants");
        clothesShop.printList(); // denim pants were removed;

        //Shop object that contains only fruits;
        Shop<Fruits> fruitsShop = new Shop<>(new ArrayList<Fruits>());
        fruitsShop.addItem(banana);
        fruitsShop.addItem(regularBanana);
        fruitsShop.addItem(apple);

        fruitsShop.printList();



    }
}