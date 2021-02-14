package dev.tkhm.ddddemo.domain;

public class ProductStock {
    String productId;
    String productName;
    ProductType productType;
    int count;

    public ProductStock(String productId, String productName, ProductType type, int count ) {
        if (productId.length() == 6) {
            this.productId = productId;
        } else {
            throw new IllegalArgumentException("製品IDは固定6桁です");
        } 

        this.productName = productName;

        if (type instanceof ProductType == true) {
            this.productType = type;
        } else {
            throw new IllegalArgumentException("製品タイプが不適切です");
        } 

        if (count >= 0 && count < 100) {
            this.count = count;
        } else {
            throw new IllegalArgumentException("製品は1品目につき99件までしか持てません");
        }
    }

    public int getCount() {
        return this.count;
    }
}
