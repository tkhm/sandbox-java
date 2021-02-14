package dev.tkhm.ddddemo.application.productstock;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dev.tkhm.ddddemo.domain.ProductStock;
import dev.tkhm.ddddemo.domain.ProductStockRepository;

@ApplicationScoped
public class ProductStockApplicationService {
    @Inject
    ProductStockRepository repo;

    public int checkProductStock() {
        ProductStock stock = repo.findBy("");
        return stock.getCount();
    }

    public boolean orderProductStock(String prodcutId, int amount) {
        ProductStock stock = repo.findBy("");
        return stock.getCount();
    }
}