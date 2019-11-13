package dk.kea.dat18c.webshopmini.Repository;

import dk.kea.dat18c.webshopmini.Model.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Integer>
{

}
