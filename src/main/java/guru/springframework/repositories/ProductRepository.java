package guru.springframework.repositories;
 
import org.springframework.data.mongodb.repository.MongoRepository;

import guru.springframework.domain.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	Product findBy_id(String _id);
	//Product findByname(String name);
}