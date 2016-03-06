package printer;

import org.junit.Before;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReceiptHeaderPrinterTest {

    private ReceiptHeaderPrinter receiptHeaderPrinter;

    @Before
    public void setUp() throws Exception {
        receiptHeaderPrinter = new ReceiptHeaderPrinter();

    }

    @org.junit.Test
    public void should_print_the_header_of_receipt() throws Exception {
        assertThat(receiptHeaderPrinter.print(), is("***<没钱赚商店>购物清单***"));
    }
}