package DB;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    private Map<String, Product> productMap = new HashMap<String, Product>();

    public ProductRepository() {
        List<Discount> buyTwoGetOneFree = Lists.newArrayList(Discount.BUY_TWO_GET_ONE_FREE);
        List<Discount> fivePercentOff = Lists.newArrayList(Discount.FIVE_PERCENT_OFF);
        List<Discount> twoDiscount = Lists.newArrayList(Discount.FIVE_PERCENT_OFF, Discount.BUY_TWO_GET_ONE_FREE);


        productMap.put("ITEM000001", new Product("可口可乐", "瓶", 3.00, "饮料饮品", "ITEM000001", buyTwoGetOneFree));
        productMap.put("ITEM000003", new Product("苹果", "斤", 5.50, "新鲜水果", "ITEM000003", fivePercentOff));
        productMap.put("ITEM000005", new Product("羽毛球", "个", 1.00, "体育用品", "ITEM000005", Lists.<Discount>newArrayList()));
    }

    public Product getOne(String productBarCode) {
        return productMap.get(productBarCode);
    }
}
