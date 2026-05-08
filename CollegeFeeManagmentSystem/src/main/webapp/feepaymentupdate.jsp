<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dao.FeePaymentDAO, model.FeePayment" %>

<%
FeePayment p = null;

try {
    int id = Integer.parseInt(request.getParameter("id"));
    FeePaymentDAO dao = new FeePaymentDAO();
    p = dao.getPaymentById(id);
} catch(Exception e) {
    e.printStackTrace();
}

if(p == null){
%>
    <h3 style="color:red;">Record not found!</h3>
    <a href="DisplayFeePaymentsServlet">Back</a>
<%
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Payment</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">

</head>

<body class="container mt-5">

<h3 class="mb-4 text-center">Update Payment</h3>

<form action="UpdateFeePaymentServlet" method="post">

<!-- Hidden ID -->
<input type="hidden" name="id" value="<%=p.getId()%>">

<!-- Student ID -->
<div class="mb-3">
<label>Student ID</label>
<input type="number" name="studentId" value="<%=p.getStudentId()%>" class="form-control" required>
</div>

<!-- Name -->
<div class="mb-3">
<label>Student Name</label>
<input type="text" name="payerName" value="<%=p.getPayerName()%>" class="form-control" required>
</div>

<!-- Amount -->
<div class="mb-3">
<label>Amount</label>
<input type="number" name="amount" value="<%=p.getAmount()%>" class="form-control" required min="1">
</div>

<!-- Date -->
<div class="mb-3">
<label>Payment Date</label>
<input type="date" name="date"
value="<%= (p.getPaymentDate() != null) ? new java.text.SimpleDateFormat("yyyy-MM-dd").format(p.getPaymentDate()) : "" %>"
class="form-control" required>
</div>

<!-- Payment Method -->
<div class="mb-3">
<label>Payment Method</label>
<select name="method" class="form-control" required>
    <option <%= "Cash".equals(p.getPaymentMethod()) ? "selected" : "" %>>Cash</option>
    <option <%= "UPI".equals(p.getPaymentMethod()) ? "selected" : "" %>>UPI</option>
    <option <%= "Card".equals(p.getPaymentMethod()) ? "selected" : "" %>>Card</option>
</select>
</div>

<!-- Status -->
<div class="mb-3">
<label>Status</label>
<select name="status" class="form-control" required>
    <option value="Paid" <%= "Paid".equals(p.getStatus()) ? "selected" : "" %>>Paid</option>
    <option value="Overdue" <%= "Overdue".equals(p.getStatus()) ? "selected" : "" %>>Overdue</option>
</select>
</div>

<!-- Buttons -->
<div class="text-center">
    <button type="submit" class="btn btn-success">Update</button>
    <a href="DisplayFeePaymentsServlet" class="btn btn-secondary">Back</a>
</div>

</form>

</body>
</html>