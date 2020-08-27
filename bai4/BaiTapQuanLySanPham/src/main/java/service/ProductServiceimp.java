package service;

import model.Product;
import repository.ProductRepo;
import repository.ProductRepoimp;

import java.util.List;

public class ProductServiceimp implements ProductService {
    private ProductRepo productRepo=new ProductRepoimp();
    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        productRepo.update(id,product);
    }

    @Override
    public void remove(int id) {
        productRepo.remove(id);
    }
}
