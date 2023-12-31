import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CartApp {
    public static void main(String[] args) {
        // 상품 목록 생성
        Set<Product> productSet = readProductsCSV("products.csv");
        // TODO: 상품 클래스를 생성하여 상품목록에 넣는다.

        // 상품 목록 확인
        System.out.println("고유한 상품 목록:");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }
        System.out.println();

        // 장바구니 생성
        Cart myCart = new Cart();

        // TODO: 상품을 장바구니에 추가
        myCart.addProduct(productSet, "우유", "1", "사과", "3");

        System.out.println("장바구니 목록: ");
        myCart.showItems();

        System.out.println();

        // TODO: 상품을 장바구니에서 제거
        myCart.removeProduct("사과", "1", "우유", "1");


        // TODO: 장바구니에 현재 담긴 상품들을 출력 (상품이름, 각 상품의 갯수)
        System.out.println("장바구니 목록: ");
        myCart.showItems();



    }

    public static Set<Product> readProductsCSV(String filePath) {
        Set<Product> products = new HashSet<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] datas = line.split(",");
                if(datas.length == 2) {
                    String name = datas[0].trim();
                    int price = Integer.parseInt(datas[1].trim());
                    products.add(new Product(name, price));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
