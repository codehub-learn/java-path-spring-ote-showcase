package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Override
	@Query("""
		   select p
		   from Product p
		   join fetch p.category
		   """)
	List<Product> findAll();

	@Query("""
		   select p
		   from Product p
		   join fetch p.category
		   where p.id = :id
		   """)
	Product getWithCategory(Long id);

	Product findBySerial(final String serial);
}
