package gr.codelearn.spring.showcase.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "order_items")
@SequenceGenerator(name = "idGenerator", sequenceName = "order_items_seq", initialValue = 1, allocationSize = 1)
public class OrderItem extends BaseModel {
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Product product;

	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Order order;

	@Column(nullable = false)
	private Integer quantity;

	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal price;
}
