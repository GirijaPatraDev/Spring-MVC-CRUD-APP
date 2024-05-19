package mvcNoXml.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Book {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	@NotEmpty(message="Book Name Must Not Be Empty")
    @Size(min = 2, max = 14, message="Book Name must be between 2-14 characters")
	private String name;
	@Column
	@NotEmpty(message="Author Name Must Not Be Empty")
	@Size(min=2, max=14, message="Author name must be between 2-14 characters")
	private String author;
	@Column
	@NotNull(message="Price Must be number")
	@DecimalMin(value="10.0", inclusive=true, message="Price Must be at least 10 dollars")
	private BigDecimal price;
	@Column
	@NotNull(message="Quantity must be a Number")
	@Min(value=1, message="Minimun Qty provided must be 1")
	private Integer qty;
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", author=" + author + ", qty=" + qty + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
}
