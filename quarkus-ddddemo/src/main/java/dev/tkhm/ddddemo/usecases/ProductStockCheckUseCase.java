package dev.tkhm.ddddemo.usecases;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dev.tkhm.ddddemo.domain.ProductStock;
import dev.tkhm.ddddemo.domain.ProductStockRepository;

@ApplicationScoped
public class ProductStockCheckUseCase {
    @Inject
    ProductStockRepository repo;

    public int checkProductStock() {
        ProductStock stock = repo.findBy("");
        return stock.getCount();
    }
}