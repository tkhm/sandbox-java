package dev.tkhm.ddddemo.domain;

public class ProductStock {
    public ProductStock() {
        this.productId = "pid001";
        this.productName = "マスク";
        this.productType = ProductType.MASK;
        this.count = 10;
    }

    String productId;
    String productName;
    ProductType productType;
    int count;

    public int getCount() {
        // 呼ばれる度に減らす
        return this.count--;
    }
}

enum ProductType {
    MASK;
}
