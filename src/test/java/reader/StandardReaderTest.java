package reader;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StandardReaderTest {
    private StandardReader standardReader;

    @Before
    public void setUp() throws Exception {
        standardReader = new StandardReader();

    }

    @Test
    public void should_return_product_map() throws Exception {
        String inputJson = "['ITEM000001','ITEM000001','ITEM000001','ITEM000001','ITEM000001','ITEM000005','ITEM000005','ITEM000005']";
        Map<String, Integer> productMap = standardReader.readFromCashRegister(inputJson);

        assertThat(productMap.get("ITEM000001"), is(5));
        assertThat(productMap.get("ITEM000005"), is(3));
    }
}