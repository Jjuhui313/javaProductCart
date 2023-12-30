import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Cart {
    private HashMap<Product, Integer> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    // 장바구니에 상품추가
    public void addProduct(Set<Product> productSet, String... products) {
        if (products.length % 2 != 0) {
            throw new IllegalArgumentException("각 상품에 대한 수량을 함께 적어주세요.");
        }

        for (int i = 0; i < products.length; i += 2) {
            String productName = products[i];
            int quantity = Integer.parseInt(products[i + 1]);

            Product product = getProductByName(productSet, productName);
            if (product == null) {
                throw new IllegalArgumentException("상품리스트에 존재하지 않는 상품은 장바구니에 담을 수 없습니다.");
            }

            int newQuantity = items.getOrDefault(product, 0) + quantity;
            items.put(product, newQuantity);
        }
    }

    // 상품이 리스트에 존재하는지, 존재한다면 상품정보를 return, 존재하지 않다면 null return
    private Product getProductByName(Set<Product> productSet, String productName) {
        for (Product product : productSet) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    // 장바구니에서 상품 삭제
    public void removeProduct(String... products) {
        if (products.length % 2 != 0) {
            throw new IllegalArgumentException("제거할 상품에 대한 수량을 함께 적어주세요.");
        }

        for (int i = 0; i < products.length; i += 2) {
            String productName = products[i];
            int removeQuantity = Integer.parseInt(products[i + 1]);

            Product product = getProductByName(items.keySet(), productName);
            if(product == null) {
                System.out.println(productName + "상품이 장바구니에 존재하지 않습니다.");
            } else {
                int quantity = items.getOrDefault(product, 0);
                int newQuantity = Math.max(0, quantity - removeQuantity);
                if(newQuantity > 0) {
                    items.put(product, newQuantity);
                } else {
                    items.remove(product);
                }
            }
        }
    }

    // 현재 장바구니에 존재하는 상품과 수량 출력
    public void showItems() {
        for(Product cartKey: items.keySet()) {
            System.out.println(cartKey.getName() + " " + items.get(cartKey) + "개");
        }
    }
}
