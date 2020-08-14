package dev.tkhm.ddddemo.infrastructure;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

import dev.tkhm.ddddemo.domain.ProductStock;
import dev.tkhm.ddddemo.domain.ProductStockRepository;
import dev.tkhm.ddddemo.domain.ProductType;

@ApplicationScoped
@Default
public class ProductStockDummyRepository implements ProductStockRepository {

    final ProductStock productStock;
    ProductStockDummyRepository() {
        productStock = new ProductStock("msk001", "マスク", ProductType.MASK, 10);
    }

    public ProductStock findBy(final String productId) {
        return productStock;
    }
}