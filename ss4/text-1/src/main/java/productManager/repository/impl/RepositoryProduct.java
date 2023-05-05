package productManager.repository.impl;

import org.springframework.stereotype.Repository;
import productManager.model.Product;
import productManager.repository.IRepositoryProduct;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryProduct implements IRepositoryProduct {
    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"car",23000));
        productList.add(new Product(2,"plane",32000));
        productList.add(new Product(3,"bycle",23000));
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public Product getProductById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==id){
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId()==productList.get(i).getId()){
                productList.set(i,product);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==id){
                productList.remove(i);
                return;
            }
        }
    }
}
