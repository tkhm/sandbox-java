package dev.tkhm.ddddemo.domain;

public interface ProductStockRepository {
    public ProductStock findBy(String productId);
}