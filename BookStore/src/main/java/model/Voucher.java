/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Dang
 */
import java.time.LocalDate;

public class Voucher {
    private int id;
    private String customerPhone;
    private String code;
    private double discount;
    private String status;
    private LocalDate expiry;

    public Voucher(int id, String customerPhone, String code, double discount, String status, LocalDate expiry) {
        this.id = id;
        this.customerPhone = customerPhone;
        this.code = code;
        this.discount = discount;
        this.status = status;
        this.expiry = expiry;
    }

    public int getId() {
        return id;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCode() {
        return code;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getExpiry() {
        return expiry;
    }

    public boolean isValid() {
        return "active".equalsIgnoreCase(status) && expiry.isAfter(LocalDate.now());
    }
}
