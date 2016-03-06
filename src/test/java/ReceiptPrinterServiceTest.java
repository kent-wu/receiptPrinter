import org.junit.Before;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReceiptPrinterServiceTest {
    private ReceiptPrintService receiptPrintService;

    @Before
    public void setUp() throws Exception {
        receiptPrintService = new ReceiptPrintService();
    }

    @org.junit.Test
    public void shoud_print_a_receipt() throws Exception {
        String inputJson = "['ITEM000001','ITEM000001','ITEM000001','ITEM000005','ITEM000005','ITEM000005','ITEM000005','ITEM000005']";

        String receiptBody = "***<没钱赚商店>购物清单***\n" +
                "名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：9.00(元)\n" +
                "名称：羽毛球，数量：5个，单价：1.00(元)，小计：5.00(元)\n" +
                "----------------------\n" +
                "总计：14.00(元)\n" +
                "**********************";

        assertThat(receiptPrintService.printReceipt(inputJson), is(receiptBody));
    }
}