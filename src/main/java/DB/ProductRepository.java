package DB;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    private Map<String, Product> productMap = new HashMap<String, Product>();

    public ProductRepository() {
        productMap.put("ITEM000001", new Product("可口可乐", "瓶", 3.00, "饮料饮品", "ITEM000001"));
        productMap.put("ITEM000003", new Product("苹果", "斤", 5.50, "新鲜水果", "ITEM000003"));
        productMap.put("ITEM000005", new Product("羽毛球", "个", 1.00, "体育用品", "ITEM000005"));
    }

    public Product getOne(String productBarCode) {
        return productMap.get(productBarCode);
    }
}
