package printer;

import org.junit.Before;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReceiptPrinterTest {
    private ReceiptPrinter receiptBodyPrinter;

    @Before
    public void setUp() throws Exception {
        receiptBodyPrinter = new ReceiptBodyPrinter();
    }

    @org.junit.Test
    public void should_print_2_item_detail() throws Exception {
        String inputJson = "['ITEM000001','ITEM000001','ITEM000001','ITEM000005','ITEM000005','ITEM000005','ITEM000005','ITEM000005']";

        String receiptBody = "名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：9.00(元)\n" +
                "名称：羽毛球，数量：5个，单价：1.00(元)，小计：5.00(元)\n" +
                "----------------------";

        assertThat(receiptBodyPrinter.input(inputJson).print(), is(receiptBody));
    }
}