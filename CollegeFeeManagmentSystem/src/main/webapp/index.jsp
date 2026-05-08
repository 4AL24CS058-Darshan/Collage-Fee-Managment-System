<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>College Fee Payment System</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">

</head>

<body>

<!-- NAVBAR -->
<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <span class="navbar-brand mb-0 h1">🎓 College Fee System</span>
    </div>
</nav>

<!-- MAIN -->
<div class="container mt-5 text-center">

<h2 class="mb-4">Welcome to Fee Payment Management</h2>

<p class="text-muted mb-4">
Manage student fee payments easily using this system.
</p>

<div class="d-flex justify-content-center gap-3">

<a href="feepaymentadd.jsp" class="btn btn-primary btn-lg">
➕ Add Payment
</a>

<a href="DisplayFeePaymentsServlet" class="btn btn-success btn-lg">
📋 View Payments
</a>

</div>

</div>

<!-- FOOTER -->
<footer class="text-center mt-5 text-muted">
<hr>
<p>© 2026 College Fee System | JSP + Servlet + JDBC</p>
</footer>

</body>
</html>