package stock.test.inatel.erros;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import stock.test.inatel.service.exceptions.ExcecaoDadosNaoEncontrado;
import stock.test.inatel.service.exceptions.ExcecaoStockDuplicado;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ExcecaoDadosNaoEncontrado.class)
	public ResponseEntity<Error> dadosNaoEncontrado(ExcecaoDadosNaoEncontrado e, HttpServletRequest request) {
		Error error = new Error();
		error.setTimestamp(Instant.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setError("Not found");
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	@org.springframework.web.bind.annotation.ExceptionHandler(ExcecaoStockDuplicado.class)
	public ResponseEntity<Error> excecaoStockDuplicado(ExcecaoStockDuplicado e, HttpServletRequest request) {
		Error error = new Error();
		error.setTimestamp(Instant.now());
		error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		error.setMessage(e.getMessage());
		error.setError("Stock duplicado");
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error);
	}

}
