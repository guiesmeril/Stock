package stock.test.inatel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import stock.test.inatel.interfaces.StockInterface;
import stock.test.inatel.models.Stocks;
import stock.test.inatel.service.StockService;

@RestController
public class StockController implements StockInterface {

	@Autowired
	private StockService stockService;

	@Override
	public ResponseEntity<Stocks> insert(Stocks stock) {
		Stocks response = stockService.insert(stock);
		return ResponseEntity.ok().body(response);
	}

	@Override
	public ResponseEntity<List<Stocks>> findAll() {
		List<Stocks> response = stockService.fidAll();
		return ResponseEntity.ok().body(response);
	}

	@Override
	public ResponseEntity<Void> delete(String name) {
		stockService.delete(name);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Stocks> findByName(String name) {
		Stocks stocks = stockService.findByName(name);
		return ResponseEntity.ok().body(stocks);
	}


	@Override
	public ResponseEntity<Stocks> patchStock(String name, Stocks stocks) {
		Stocks response = stockService.patchStock(name,stocks);
		return ResponseEntity.ok().body(response);
	}
}
