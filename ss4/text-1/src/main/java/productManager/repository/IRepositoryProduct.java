package productManager.repository;

import productManager.model.Product;

import java.util.List;

public interface IRepositoryProduct {
    List<Product> getAll();

    Product getProductById(int id);

    void update(Product product);

    void delete(int id);
}
