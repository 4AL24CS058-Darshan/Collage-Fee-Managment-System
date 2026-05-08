<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, model.FeePayment" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Payments</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<!-- NAVBAR -->
<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <span class="navbar-brand">🎓 College Fee System</span>
    </div>
</nav>

<!-- MAIN -->
<div class="container mt-5">

<h3 class="mb-4 text-center">All Payments</h3>

<table class="table table-bordered table-striped table-hover">

<thead class="table-dark">
<tr>
<th>ID</th>
<th>Student ID</th>
<th>Name</th>
<th>Amount</th>
<th>Status</th>
<th>Date</th>
<th>Method</th>
<th>Action</th>
</tr>
</thead>

<tbody>

<%
List<FeePayment> list = (List<FeePayment>) request.getAttribute("list");

if(list != null && !list.isEmpty()){
    for(FeePayment p : list){
%>

<tr>
<td><%=p.getId()%></td>
<td><%=p.getStudentId()%></td>
<td><%=p.getPayerName()%></td>
<td>₹ <%=p.getAmount()%></td>

<td>
<span class="badge bg-<%= "Paid".equals(p.getStatus()) ? "success" : "danger" %>">
    <%=p.getStatus()%>
</span>
</td>

<td>
<%= (p.getPaymentDate() != null) 
    ? new java.text.SimpleDateFormat("dd-MM-yyyy").format(p.getPaymentDate()) 
    : "" %>
</td>

<td><%=p.getPaymentMethod()%></td>

<td>

<a href="feepaymentupdate.jsp?id=<%=p.getId()%>" 
   class="btn btn-warning btn-sm">Edit</a>

<a href="DeleteFeePaymentServlet?id=<%=p.getId()%>" 
   class="btn btn-danger btn-sm"
   onclick="return confirm('Delete this record?')">Delete</a>

</td>

</tr>

<%
    }
} else {
%>

<tr>
<td colspan="8" class="text-center text-muted">No records found</td>
</tr>

<% } %>

</tbody>
</table>

<div class="text-center">
    <a href="index.jsp" class="btn btn-primary">Home</a>
</div>

</div>

</body>
</html>