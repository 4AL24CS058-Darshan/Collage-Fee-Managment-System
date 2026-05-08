package dao;

import java.sql.*;
import java.util.*;

import model.FeePayment;
import dao.DBConnection;   // ✅ CORRECT PACKAGE

public class FeePaymentDAO {

    // =========================
    // INSERT
    // =========================
    public boolean addPayment(FeePayment p) {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO feepayments (StudentID, payer_name, amount, Status, payment_date, payment_method) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, p.getStudentId());
            ps.setString(2, p.getPayerName());
            ps.setDouble(3, p.getAmount());
            ps.setString(4, p.getStatus());
            ps.setDate(5, p.getPaymentDate());
            ps.setString(6, p.getPaymentMethod());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // =========================
    // FETCH ALL
    // =========================
    public List<FeePayment> getAllPayments() {

        List<FeePayment> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT * FROM feepayments";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                FeePayment p = new FeePayment();

                p.setId(rs.getInt("id"));
                p.setStudentId(rs.getInt("StudentID"));
                p.setPayerName(rs.getString("payer_name"));
                p.setAmount(rs.getDouble("amount"));
                p.setStatus(rs.getString("Status"));
                p.setPaymentDate(rs.getDate("payment_date"));
                p.setPaymentMethod(rs.getString("payment_method"));

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // =========================
    // DELETE
    // =========================
    public boolean deletePayment(int id) {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "DELETE FROM feepayments WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // =========================
    // UPDATE
    // =========================
    public boolean updatePayment(FeePayment p) {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "UPDATE feepayments SET StudentID=?, payer_name=?, amount=?, Status=?, payment_date=?, payment_method=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, p.getStudentId());
            ps.setString(2, p.getPayerName());
            ps.setDouble(3, p.getAmount());
            ps.setString(4, p.getStatus());
            ps.setDate(5, p.getPaymentDate());
            ps.setString(6, p.getPaymentMethod());
            ps.setInt(7, p.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // =========================
    // GET BY ID (FOR EDIT)
    // =========================
    public FeePayment getPaymentById(int id) {

        FeePayment p = null;

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT * FROM feepayments WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                p = new FeePayment();

                p.setId(rs.getInt("id"));
                p.setStudentId(rs.getInt("StudentID"));
                p.setPayerName(rs.getString("payer_name"));
                p.setAmount(rs.getDouble("amount"));
                p.setStatus(rs.getString("Status"));
                p.setPaymentDate(rs.getDate("payment_date"));
                p.setPaymentMethod(rs.getString("payment_method"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }
 // =========================
 // GET BY ID (FOR UPDATE PAGE)
 // =========================

}