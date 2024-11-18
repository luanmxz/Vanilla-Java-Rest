package com.luanmxz.web;

import java.io.IOException;
import java.util.List;

import com.luanmxz.context.Application;
import com.luanmxz.domain.model.Invoice;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (request.getRequestURI().equalsIgnoreCase("/")) {
      response.setContentType("text/html; charset=UTF-8");
      response.getWriter().print(
          "<html>\n" +
              "<body>\n" +
              "<h1>Hello World</h1>\n" +
              "<p>This is my very first, embedded Tomcat, HTML Page!</p>\n" +
              "</body>\n" +
              "</html>");
    }

    if (request.getRequestURI().equalsIgnoreCase("/invoices")) {
      response.setContentType("application/json; charset=UTF-8");

      List<Invoice> invoices = Application.invoiceService.findAll();

      response.getWriter().print(Application.objectMapper.writeValueAsString(invoices));
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    if (request.getRequestURI().equalsIgnoreCase("/invoices")) {

      String userId = request.getParameter("user_id");
      Integer amount = Integer.valueOf(request.getParameter("amount"));

      Invoice invoice = Application.invoiceService.create(userId, amount);

      response.setContentType("application/json; charset=UTF-8");
      String json = Application.objectMapper.writeValueAsString(invoice);
      response.getWriter().print(json);
    } else {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
  }
}