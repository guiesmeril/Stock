package stock.test.inatel.service.exceptions;

public class ExcecaoStockDuplicado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcecaoStockDuplicado(String msg) {
		super(msg);
	}
}