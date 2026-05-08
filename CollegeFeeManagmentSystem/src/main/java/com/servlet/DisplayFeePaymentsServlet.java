package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.FeePaymentDAO;
import model.FeePayment;

@WebServlet("/DisplayFeePaymentsServlet")
public class DisplayFeePaymentsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DisplayFeePaymentsServlet() {
        super();
    }

    // HANDLE GET REQUEST
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Create DAO object
            FeePaymentDAO dao = new FeePaymentDAO();

            // Fetch all payments
            List<FeePayment> list = dao.getAllPayments();

            // Set data to request scope
            request.setAttribute("list", list);

            // Forward to JSP page
            request.getRequestDispatcher("feepaymentdisplay.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();

            // Show user-friendly error
            response.setContentType("text/html");
            response.getWriter().println("<h3>Error loading data!</h3>");
            response.getWriter().println("<p>" + e.getMessage() + "</p>");
        }
    }

    // HANDLE POST REQUEST (redirect to GET)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}