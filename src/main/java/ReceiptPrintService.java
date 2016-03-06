import com.google.common.base.Joiner;
import printer.ReceiptBodyPrinter;
import printer.ReceiptFooterPrinter;
import printer.ReceiptHeaderPrinter;

public class ReceiptPrintService {
    public String printReceipt(String inputJson) {
        String header = new ReceiptHeaderPrinter().input(inputJson).print();
        String body = new ReceiptBodyPrinter().input(inputJson).print();
        String footer = new ReceiptFooterPrinter().input(inputJson).print();

        return Joiner.on("\n").join(header, body, footer);
    }
}
