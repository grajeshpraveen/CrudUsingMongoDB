package guru.springframework.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Product {
	@Id
	public String _id;

	public String name;
	public int price;
	public List<String> model;

	// Constructors
	public Product() {
	}

	public Product(String _id, String name, int price, List<String> model) {
		this._id = _id;
		this.name = name;
		this.price = price;
		this.model = model;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<String> getModel() {
		return model;
	}

	public void setModel(List<String> model) {
		this.model = model;
	}

}