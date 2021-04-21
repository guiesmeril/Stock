package stock.test.inatel.repository;

 
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import stock.test.inatel.models.Quotes; 

@Repository

public interface QuotesRepository extends JpaRepository<Quotes, Long> {
 
	@Modifying
	@Query(value = "DELETE from Quotes where id_stocks = :id_stocks", nativeQuery = true)
	@Transactional
	void deleteByIdQuotes(@Param("id_stocks") long id_stocks);
	
	 
}
