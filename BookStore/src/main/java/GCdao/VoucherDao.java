/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GCdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import model.Voucher;
import util.DatabaseUtil;

/**
 *
 * @author Dang
 */
public class VoucherDao {
     public Voucher getVoucherByCode(String code) {
        Voucher voucher = null;
        String sql = "SELECT TOP 1 vou_id, cus_phone, vou_code, vou_discount, vou_status, vou_expiry FROM Voucher WHERE vou_code = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, code);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("vou_id");
                    String customerPhone = resultSet.getString("cus_phone");
                    String voucherCode = resultSet.getString("vou_code");
                    double discount = resultSet.getDouble("vou_discount");
                    String status = resultSet.getString("vou_status");
                    LocalDate expiry = resultSet.getDate("vou_expiry").toLocalDate();

                    voucher = new Voucher(id, customerPhone, voucherCode, discount, status, expiry);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voucher;
    }
}
