import java.util.Objects;

public class Product {
    private static int nextKey = 1;
    private int key;
    private String name;
    private int price;

    public Product(String name, int price) {
        this.key = nextKey++;
        this.name = name;
        this.price = price;
    }

    // HashSet 중복 제거
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(name, product.name);
    }

    // HashSet 중복 제거
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    // 상품이름을 get
    public String getName() {
        return name;
    }

    // 상품가격을 get
    public int getPrice() {
        return price;
    }

}
