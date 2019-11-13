package dk.kea.dat18c.webshopmini.Service;

import dk.kea.dat18c.webshopmini.Model.Product;

import dk.kea.dat18c.webshopmini.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//annoter som service
@Service
public class ProductService {

    //Annoter med autowired til repository
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll()
    {
        //kald repo.getall og returner
        List<Product> products = new ArrayList<>();
        for(Product product:productRepository.findAll()) {
            products.add(product);
        }
        return products;
    }

    public void create(Product product)
    {
        productRepository.save(product);
    }

    public void delete(int id) { productRepository.deleteById(id); }



    public Product findById(int id) {
        //findById giver en optional
        Optional<Product> productOptional = productRepository.findById(id);
        //hvis der ikke findes et product på id, kastes der en fejl
        if (!productOptional.isPresent())
        {
            throw new RuntimeException("Product not found");
        }
        //returner product vha. .get()
        return productOptional.get();
    }

    public void update(Product product) { productRepository.save(product); }

}
