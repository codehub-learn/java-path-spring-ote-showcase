package gr.codelearn.spring.showcase.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "products", indexes = {@Index(columnList = "serial")})
@SequenceGenerator(name = "idGenerator", sequenceName = "products_seq", initialValue = 1, allocationSize = 1)
public class Product extends BaseModel {
	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 30, nullable = false, unique = true)
	private String serial;

	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal price;

	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;
}
