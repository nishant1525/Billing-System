<%@ page import="java.util.List" %>
<%@ page import="com.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bill</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col text-center">
            <h2>D mart</h2>
            <p>Firm Number: U78564</p>
            <p>Bill No:201</p>
        </div>
    </div>
    <hr>
    <h3 class="text-center">Bill</h3>
    <div class="row mt-4">
        <div class="col">
            <table class="table table-bordered">
                <thead class="thead-dark"> 
                    <tr>
                        <th>Item</th>
                        <th>Item Code</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total (w/o tax)</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        List<Product> products = (List<Product>) request.getAttribute("products");
                        double totalWithoutTaxes = 0;
                        if (products != null) {
                            for (Product product : products) {
                    %>
                    <tr>
                        <td><%= product.getItem() %></td>
                        <td><%= product.getItemCode() %></td>
                        <td><%= product.getPrice() %></td>
                        <td><%= product.getQuantity() %></td>
                        <td><%= product.getTotalWithoutTaxes() %></td>
                    </tr>
                    <% 
                                totalWithoutTaxes += product.getTotalWithoutTaxes();
                            }
                        } else {
                    %>
                    <tr><td colspan='5'>No products found</td></tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col text-right">
            <p>Total (w/o tax): <%= totalWithoutTaxes %></p>
            <hr>
            <p>Tax (18%): <%= totalWithoutTaxes * 0.18 %></p>
            <hr> 
            <p><strong>Grand Total: <%= totalWithoutTaxes + (totalWithoutTaxes * 0.18) %></strong></p>
       <button class="btn btn-primary" onClick="window.print()">Print Bill</button>
<button class="btn btn-success" onclick="document.getElementById('newBillForm').submit()">New Bill</button>
<form id="newBillForm" action="ClearProductsServlet" method="post"></form>

        </div>
    </div>
</div>

</body>
</html>
