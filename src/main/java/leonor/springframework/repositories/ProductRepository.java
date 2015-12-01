package leonor.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import leonor.springframework.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
}
