package dev.tkhm.ddddemo.infrastructure;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

import dev.tkhm.ddddemo.domain.ProductStock;
import dev.tkhm.ddddemo.domain.ProductStockRepository;

@ApplicationScoped
@Default
public class ProductStockDummyRepository implements ProductStockRepository {

    final ProductStock productStock;
    ProductStockDummyRepository() {
        productStock = new ProductStock();
    }

    public ProductStock findBy(final String productId) {
        return productStock;
    }
}