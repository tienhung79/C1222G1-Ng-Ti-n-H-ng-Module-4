package productManager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productManager.model.Product;
import productManager.repository.IRepositoryProduct;
import productManager.repository.impl.RepositoryProduct;
import productManager.service.IServiceProduct;

import java.util.List;

@Service
public class ServiceProduct implements IServiceProduct {
    @Autowired
    IRepositoryProduct repositoryProduct;
    @Override
    public List<Product> getAll() {
        return repositoryProduct.getAll();
    }

    @Override
    public Product getProductById(int id) {
        return repositoryProduct.getProductById(id);
    }

    @Override
    public void update(Product product) {
        repositoryProduct.update(product);
    }

    @Override
    public void delete(int id) {
        repositoryProduct.delete(id);
    }

    @Override
    public void createProduct(Product product) {
        repositoryProduct.create(product);
    }
}
