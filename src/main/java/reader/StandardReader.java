package reader;

import com.google.common.base.Splitter;
import org.json.JSONArray;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StandardReader implements Reader {
    @Override
    public Map<String, Integer> readFromCashRegister(String input) {
        Map<String, Integer> productMap = new LinkedHashMap<String, Integer>();

        JSONArray jsonArray = new JSONArray(input);
        for (int i = 0; i < jsonArray.length(); i++) {
            String barCode = jsonArray.getString(i);
            if (barCode.contains("-")) {
                parseNonStandardBarcode(productMap, barCode);
            } else {
                parseStandardBarcode(productMap, barCode);
            }
        }

        return productMap;
    }

    private void parseNonStandardBarcode(Map<String, Integer> productMap, String barCodeString) {
        List<String> barCodeAndAmount = Splitter.on("-").splitToList(barCodeString);
        String barCode = barCodeAndAmount.get(0);
        Integer amount = Integer.valueOf(barCodeAndAmount.get(1));

        Integer originalAmount = productMap.get(barCodeAndAmount.get(0));
        if (originalAmount == null) {
            productMap.put(barCode, amount);
        } else {
            productMap.put(barCode, amount + originalAmount);
        }
    }

    private void parseStandardBarcode(Map<String, Integer> productMap, String barCode) {
        Integer amount = productMap.get(barCode);

        if (amount == null) {
            productMap.put(barCode, 1);
        } else {
            productMap.put(barCode, amount + 1);
        }
    }
}
