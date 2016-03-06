package reader;

import org.json.JSONArray;

import java.util.LinkedHashMap;
import java.util.Map;

public class StandardReader implements Reader {
    @Override
    public Map<String, Integer> readFromCashRegister(String input) {
        Map<String, Integer> productMap = new LinkedHashMap<String, Integer>();

        JSONArray jsonArray = new JSONArray(input);
        for (int i = 0; i < jsonArray.length(); i++) {
            String barcode = jsonArray.getString(i);
            Integer amount = productMap.get(barcode);

            if (amount == null) {
                productMap.put(barcode, 1);
            } else {
                productMap.put(barcode, amount + 1);
            }
        }

        return productMap;
    }
}
