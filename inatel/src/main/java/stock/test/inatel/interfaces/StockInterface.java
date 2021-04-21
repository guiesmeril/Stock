package stock.test.inatel.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import stock.test.inatel.models.Stocks;

@RequestMapping("/stock")
public interface StockInterface {

	@PostMapping
	public ResponseEntity<Stocks> insert(@RequestBody Stocks stocks);
	
	@PatchMapping("/{name}")
	public ResponseEntity<Stocks> patchStock(@PathVariable(required = true) String name, @RequestBody Stocks stocks);

	@GetMapping
	public ResponseEntity<List<Stocks>> findAll();
	
	@GetMapping(params = "name")
	public ResponseEntity<Stocks> findByName(@RequestParam(required = false) String name);
	
	@DeleteMapping("/{name}")
	public ResponseEntity<Void> delete(@PathVariable(required = true) String name);

}
