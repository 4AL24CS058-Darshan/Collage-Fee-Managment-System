<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Payment</title>

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

<!-- MAIN CONTENT -->
<div class="container mt-5">

<div class="card shadow p-4">

<h3 class="mb-4 text-center">Add Fee Payment</h3>

<form action="AddFeePaymentServlet" method="post">

<!-- Student ID -->
<div class="mb-3">
<label>Student ID</label>
<input type="number" name="studentId" class="form-control" required min="1">
</div>

<!-- Name -->
<div class="mb-3">
<label>Student Name</label>
<input type="text" name="payerName" class="form-control" required>
</div>

<!-- Amount -->
<div class="mb-3">
<label>Amount (₹)</label>
<input type="number" name="amount" class="form-control" required min="1">
</div>

<!-- Date -->
<div class="mb-3">
<label>Payment Date</label>
<input type="date" name="date" class="form-control" required>
</div>

<!-- Method -->
<div class="mb-3">
<label>Payment Method</label>
<select name="method" class="form-control" required>
    <option value="">Select</option>
    <option>Cash</option>
    <option>UPI</option>
    <option>Card</option>
</select>
</div>

<!-- Status -->
<div class="mb-3">
<label>Status</label>
<select name="status" class="form-control" required>
    <option value="">Select</option>
    <option value="Paid">Paid</option>
    <option value="Overdue">Overdue</option>
</select>
</div>

<!-- BUTTONS -->
<div class="text-center mt-4">
    <button type="submit" class="btn btn-primary px-4">Submit</button>
    <a href="index.jsp" class="btn btn-secondary px-4">Back</a>
</div>

</form>

</div>

</div>

</body>
</html>