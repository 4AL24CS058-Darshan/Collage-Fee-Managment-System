package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.FeePaymentDAO;

@WebServlet("/DeleteFeePaymentServlet")
public class DeleteFeePaymentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DeleteFeePaymentServlet() {
        super();
    }

    // HANDLE DELETE (GET REQUEST)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Get ID from URL
            int id = Integer.parseInt(request.getParameter("id"));

            // Call DAO
            FeePaymentDAO dao = new FeePaymentDAO();
            boolean status = dao.deletePayment(id);

            // Redirect after delete
            response.sendRedirect("DisplayFeePaymentsServlet");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Delete Error: " + e.getMessage());
        }
    }

    // OPTIONAL: POST calls GET
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}