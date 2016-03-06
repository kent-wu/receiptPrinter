package printer;

import DB.Product;
import DB.ProductRepository;
import reader.Reader;
import reader.StandardReader;

import java.math.BigDecimal;
import java.util.Map;

public class ReceiptFooterPrinter implements ReceiptPrinter {
    private ProductRepository productRepository = new ProductRepository();
    private Reader reader = new StandardReader();
    private Map<String, Integer> shoppingCart;

    private String footerTemplate = "总计：%.2f(元)";

    @Override
    public ReceiptPrinter input(String inputString) {
        shoppingCart = reader.readFromCashRegister(inputString);
        return this;
    }

    @Override
    public String print() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<String, Integer> item : shoppingCart.entrySet()) {
            Product product = productRepository.getOne(item.getKey());

            totalPrice = totalPrice.add(product.getUnitPrice().multiply(BigDecimal.valueOf(item.getValue())));
        }
        return String.format(footerTemplate, totalPrice).concat("\n**********************");
    }
}
