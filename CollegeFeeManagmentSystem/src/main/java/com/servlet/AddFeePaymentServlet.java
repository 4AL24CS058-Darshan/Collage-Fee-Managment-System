package com.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.FeePaymentDAO;
import model.FeePayment;

@WebServlet("/AddFeePaymentServlet")
public class AddFeePaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String studentId = request.getParameter("studentId");
            String name = request.getParameter("payerName");
            String amount = request.getParameter("amount");
            String date = request.getParameter("date");
            String method = request.getParameter("method");
            String status = request.getParameter("status");

            FeePayment p = new FeePayment();

            p.setStudentId(Integer.parseInt(studentId));
            p.setPayerName(name);
            p.setAmount(Double.parseDouble(amount));
            p.setPaymentDate(Date.valueOf(date));
            p.setPaymentMethod(method);
            p.setStatus(status);

            FeePaymentDAO dao = new FeePaymentDAO();

            if (dao.addPayment(p)) {
                response.sendRedirect("DisplayFeePaymentsServlet");
            } else {
                response.getWriter().println("Insert Failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}