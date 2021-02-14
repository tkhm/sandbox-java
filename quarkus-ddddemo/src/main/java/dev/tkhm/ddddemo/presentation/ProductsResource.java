package dev.tkhm.ddddemo.presentation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.tkhm.ddddemo.application.productstock.ProductStockApplicationService;

@Path("/products")
public class ProductsResource {
    @Inject
    ProductStockApplicationService productStockCheckUseCase;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public int getProductStock() {
        int stockCount = productStockCheckUseCase.checkProductStock();
        return stockCount;
    }
}
