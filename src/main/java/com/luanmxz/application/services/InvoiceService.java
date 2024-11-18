package com.luanmxz.application.services;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.luanmxz.domain.model.Invoice;
import com.luanmxz.domain.model.User;

public class InvoiceService {

  private final UserService userService;

  List<Invoice> invoices = new CopyOnWriteArrayList<>();

  public InvoiceService(UserService userService) {
    this.userService = userService;
  }

  public List<Invoice> findAll() {
    return this.invoices;
  }

  public Invoice create(String userId, Integer amount) {
    User user = userService.findById(userId);
    if (user == null) {
      throw new IllegalStateException();
    }

    // REAL PDF GENERATION HERE
    Invoice invoice = new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");
    this.invoices.add(invoice);

    return invoice;
  }
}
