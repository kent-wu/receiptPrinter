package printer;

import DB.Product;
import DB.ProductRepository;
import com.google.common.base.Joiner;
import reader.Reader;
import reader.StandardReader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReceiptBodyPrinter implements ReceiptPrinter {
    private ProductRepository productRepository = new ProductRepository();
    private Reader reader = new StandardReader();
    private Map<String, Integer> shoppingCart;

    private String productDetailTemplate = "名称：%s，数量：%s%s，单价：%.2f(元)，小计：%.2f(元)";

    @Override
    public ReceiptPrinter input(String inputString) {
        this.shoppingCart = reader.readFromCashRegister(inputString);
        return this;
    }

    @Override
    public String print() {
        List<String> productDetails = new ArrayList<String>();

        for (Map.Entry<String, Integer> item : shoppingCart.entrySet()) {
            Product product = productRepository.getOne(item.getKey());

            productDetails.add(String.format(productDetailTemplate, product.getName(),
                    item.getValue(), product.getUnit(), product.getUnitPrice(),
                    product.getUnitPrice().multiply(BigDecimal.valueOf(item.getValue()))));
        }

        productDetails.add("----------------------");
        return Joiner.on("\n").join(productDetails);
    }
}
