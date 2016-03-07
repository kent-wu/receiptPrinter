package printer;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReceiptFooterPrinterTest {
    private ReceiptFooterPrinter receiptFooterPrinter;

    @Before
    public void setUp() throws Exception {
        receiptFooterPrinter = new ReceiptFooterPrinter();
    }

    @Test
    public void should_print_footer_when_there_are_standard_barcodes() throws Exception {
        String inputJson = "['ITEM000001','ITEM000001','ITEM000001','ITEM000005','ITEM000005','ITEM000005','ITEM000005','ITEM000005']";

        String receiptBody = "总计：14.00(元)\n" +
                "**********************";

        assertThat(receiptFooterPrinter.input(inputJson).print(), is(receiptBody));
    }
}