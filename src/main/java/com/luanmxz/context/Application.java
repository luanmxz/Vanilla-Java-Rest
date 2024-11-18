package com.luanmxz.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luanmxz.application.services.InvoiceService;
import com.luanmxz.application.services.UserService;

public class Application {
  public static final UserService userService = new UserService();
  public static final InvoiceService invoiceService = new InvoiceService(userService);
  public static final ObjectMapper objectMapper = new ObjectMapper();

}
