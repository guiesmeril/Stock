package stock.test.inatel.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quotes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double values;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValues() {
		return values;
	}

	public void setValues(double values) {
		this.values = values;
	}

	@Override
	public String toString() {
		return "Quotes [id=" + id + ", values=" + values + "]";
	}
}
