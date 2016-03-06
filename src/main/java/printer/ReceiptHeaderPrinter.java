package printer;

public class ReceiptHeaderPrinter implements ReceiptPrinter {
    private String header = "***<没钱赚商店>购物清单***";


    @Override
    public ReceiptPrinter input(String inputString) {
        return this;
    }

    @Override
    public String print() {
        return header;
    }
}
