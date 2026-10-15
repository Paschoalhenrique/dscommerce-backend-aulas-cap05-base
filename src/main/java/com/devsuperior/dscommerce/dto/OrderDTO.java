package com.devsuperior.dscommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderItem;
import com.devsuperior.dscommerce.entities.Payment;

public class OrderDTO {

	private Long id;
	private Instant moment;
	private String status;
	private ClientDTO client;
	private PaymentDTO payment;
	private List<OrderItemDTO> items = new ArrayList<>();

	public OrderDTO() {
	}

	public OrderDTO(Order entity) {
		id = entity.getId();
		moment = entity.getMoment();
		status = entity.getStatus().name();
		client = new ClientDTO(entity.getClient());
		if (entity.getPayment() != null) {
			payment = new PaymentDTO(entity.getPayment());
		}
		for (OrderItem item : entity.getItems()) {
			items.add(new OrderItemDTO(item));
		}
	}

	public Long getId() { return id; }
	public Instant getMoment() { return moment; }
	public String getStatus() { return status; }
	public ClientDTO getClient() { return client; }
	public PaymentDTO getPayment() { return payment; }
	public List<OrderItemDTO> getItems() { return items; }
}
