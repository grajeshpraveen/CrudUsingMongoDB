package guru.springframework.controllers;

import java.io.Serializable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.domain.Product;
import guru.springframework.repositories.ProductRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController 
public class ProductController implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@Autowired
	private ProductRepository repository;

	@ApiOperation(value = "View a list of available products", response = Product.class, tags = { "crud" })
	@ApiResponse(code = 200, message = "Successfully retrieved list", response = Product.class)
	@GetMapping(value = "/product" , produces= {"application/json"})
	public Product getPetById(@RequestParam("name")  String name) {
		System.out.println(repository.findBy_id(name));
		return repository.findBy_id(name);
	}

	@ApiOperation(value = "View a list of available products", response = Product.class, tags = { "crud" })
	@ApiResponse(code = 200, message = "Successfully retrieved list", response = Product.class)
	@PostMapping(value = "/product" , produces= {"application/json"},consumes= {"application/json"})
	public ResponseEntity<?> modifyPetById(@RequestParam("id") String id, @Valid @RequestBody Product product) {
		product.set_id(id);
		repository.save(product);
	 return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
