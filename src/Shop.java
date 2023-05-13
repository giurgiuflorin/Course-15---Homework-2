import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Shop<T extends ShopItem> {

    private List<T> shopList;

    public Shop(List<T> shopList) {
        this.shopList = shopList;
    }

    public void addItem(T item) {
        if (shopList.contains(item)) {
            throw new MyException("Product already present in your list!");
        }
        shopList.add(item);
    }

    public List<T> findByCategory(Category category) {
        List<T> listByCategory = new ArrayList<>();

        for (T t : shopList) {
            if (t.category() == category) {
                listByCategory.add(t);
            }
        }
        return listByCategory;
    }

    public List<T> findWithLowerPrice(int maxPrice) {
        if (maxPrice < 0) {
            throw new MyException("Negative price value not allowed!");
        }
        List<T> listLowerPrice = new ArrayList<>();

        for (T t : shopList) {
            if (t.price() < maxPrice) {
                listLowerPrice.add(t);
            }
        }
        return listLowerPrice;
    }

    public List<T> findWithHigherPrice(int minPrice) {
        if (minPrice < 0) {
            throw new MyException("Negative price value not allowed!");
        }
        List<T> listHigherPrice = new ArrayList<>();

        for (T t : shopList) {
            if (t.price() > minPrice) {
                listHigherPrice.add(t);
            }
        }
        return listHigherPrice;
    }

    public List<T> findWithExactPrice(int price) {
        if (price < 0) {
            throw new MyException("Negative price value not allowed!");
        }
        List<T> listWithSamePrice = new ArrayList<>();

        for (T t : shopList) {
            if (t.price() == price) {
                listWithSamePrice.add(t);
            }
        }
        return listWithSamePrice;
    }

    public Optional<T> findByName(String name) {
        for (T t : shopList) {
            if (t.name() == name) {
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    public Optional<T> removeItem(String name) {
        for (T t : shopList) {
            if (t.name().equals(name)) {
                shopList.remove(t);
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

   public void printList() {
        for (T t : shopList) {
            System.out.println("Category [" + t.category() + "], Price: " +
                    t.price() + "$," + " Name: " + t.name());
        }
   }

}
