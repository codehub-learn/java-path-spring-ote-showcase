package gr.codelearn.spring.showcase.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "orders")
@SequenceGenerator(name = "idGenerator", sequenceName = "orders_seq", initialValue = 1, allocationSize = 1)
public class Order extends BaseModel {
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Customer customer;

	@ToString.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private final Set<OrderItem> orderItems = new HashSet<>();

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date submitDate;

	@Enumerated(EnumType.STRING)
	@Column(length = 11, nullable = false)
	private OrderStatus status;

	@Enumerated(EnumType.STRING)
	@Column(length = 11, nullable = false)
	private PaymentMethod paymentMethod;

	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal cost;

}
