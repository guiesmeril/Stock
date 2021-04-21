package stock.test.inatel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stock.test.inatel.models.Quotes;
import stock.test.inatel.models.Stocks;
import stock.test.inatel.repository.QuotesRepository;
import stock.test.inatel.repository.StockRepository;
import stock.test.inatel.service.exceptions.ExcecaoDadosNaoEncontrado;
import stock.test.inatel.service.exceptions.ExcecaoStockDuplicado;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private QuotesRepository quotesRepository;

	public Stocks insert(Stocks request) {
		
		Stocks stocks = stockRepository.findByName(request.getName());
		if(stocks != null) {
			throw new ExcecaoStockDuplicado("Stock já existe");
		}

		
		Stocks stock = new Stocks();
		List<Quotes> listQuotes = new ArrayList<>();

		for (int i = 0; i < request.getQuotes().size(); i++) {
			listQuotes.add((Quotes) request.getQuotes().get(i));
		}
		stock.setQuotes(listQuotes);
		stock.setName(request.getName());
		stockRepository.save(stock);
		return stock;
	}

	public Stocks findByName(String name) {
		Stocks stocks = stockRepository.findByName(name);
		if(stocks == null) {
			throw new ExcecaoDadosNaoEncontrado("Stock não existe , verifique o nome e tente novamente.");
		}

		return stocks;
	}

	public List<Stocks> fidAll() {
		List<Stocks> listStock = stockRepository.findAll();
		return listStock;
	}

	public void delete(String name) {

		Stocks stocks = findByName(name);
		
		if(stocks == null) {
			throw new ExcecaoDadosNaoEncontrado("Stock não existe , verifique o nome e tente novamente.");
		}

		if (stocks != null) {
			long idStocs = stocks.getId();

			quotesRepository.deleteByIdQuotes(idStocs);
			stockRepository.deleteByName(name);
		}

	}

	public Stocks patchStock(String name, Stocks request) {
		Stocks stocks = findByName(name);
		
		if(stocks == null) {
			throw new ExcecaoDadosNaoEncontrado("Stock não existe , verifique o nome e tente novamente.");
		}

		Stocks stock = new Stocks();
		List<Quotes> listQuotes = new ArrayList<>();

		if (stocks != null) {

			for (int i = 0; i < stocks.getQuotes().size(); i++) {
				listQuotes.add((Quotes) stocks.getQuotes().get(i));
			}

			for (int i = 0; i < request.getQuotes().size(); i++) {
				listQuotes.add((Quotes) request.getQuotes().get(i));
			}
			stock.setQuotes(listQuotes);
			stock.setName(name);
			stock.setId(stocks.getId());
			stockRepository.save(stock);
		}

		return stock;
	}

}
