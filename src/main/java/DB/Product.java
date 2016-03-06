package DB;

import java.math.BigDecimal;

public class Product {
    private String name;
    private String unit;
    private BigDecimal unitPrice;
    private String category;
    private String barCode;

    public Product(String name, String unit, double unitPrice, String category, String barcode) {
        this.name = name;
        this.unit = unit;
        this.unitPrice = new BigDecimal(unitPrice);
        this.category = category;
        this.barCode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
}
