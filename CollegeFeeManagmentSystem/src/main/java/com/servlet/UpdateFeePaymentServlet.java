package com.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.FeePaymentDAO;
import model.FeePayment;

@WebServlet("/UpdateFeePaymentServlet")
public class UpdateFeePaymentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String idStr = request.getParameter("id");
            String studentIdStr = request.getParameter("studentId");
            String name = request.getParameter("payerName");
            String amountStr = request.getParameter("amount");
            String dateStr = request.getParameter("date");
            String method = request.getParameter("method");
            String statusStr = request.getParameter("status");

            // Safe validation
            if (idStr == null || idStr.trim().isEmpty() ||
                studentIdStr == null || studentIdStr.trim().isEmpty() ||
                name == null || name.trim().isEmpty() ||
                amountStr == null || amountStr.trim().isEmpty() ||
                dateStr == null || dateStr.trim().isEmpty() ||
                method == null || method.trim().isEmpty() ||
                statusStr == null || statusStr.trim().isEmpty()) {

                response.getWriter().println("All fields are required!");
                return;
            }

            FeePayment p = new FeePayment();

            p.setId(Integer.parseInt(idStr));
            p.setStudentId(Integer.parseInt(studentIdStr));
            p.setPayerName(name);
            p.setAmount(Double.parseDouble(amountStr));
            p.setPaymentDate(Date.valueOf(dateStr));
            p.setPaymentMethod(method);
            p.setStatus(statusStr);

            FeePaymentDAO dao = new FeePaymentDAO();
            boolean result = dao.updatePayment(p);

            if (result) {
                response.sendRedirect("DisplayFeePaymentsServlet");
            } else {
                response.getWriter().println("Update Failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Update Error: " + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("DisplayFeePaymentsServlet");
    }
}