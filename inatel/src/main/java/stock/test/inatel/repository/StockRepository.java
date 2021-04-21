package stock.test.inatel.repository;

 

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import stock.test.inatel.models.Stocks;

@Repository

public interface StockRepository extends JpaRepository<Stocks, Long> {
	
	 Stocks findByName(String name);

	@Modifying
	@Query(value = "DELETE from Stocks where name = :name", nativeQuery = true)
	@Transactional
	void deleteByName(@Param("name") String name);
	
	
	 
}
