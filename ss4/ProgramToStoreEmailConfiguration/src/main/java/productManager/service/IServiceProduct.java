package productManager.service;

import productManager.model.Product;

import java.util.List;

public interface IServiceProduct {
    List<Product> getAll();

    Product getProductById(int id);

    void update(Product product);

    void delete(int id);

    void createProduct(Product product);
}
