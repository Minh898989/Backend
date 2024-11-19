package com.example.demo.dto;

import java.util.Date;
import java.util.List;

public class InvoiceRequest {
    private Long id;  // ID hóa đơn (nếu có)
    private Date purchaseDate;  // Ngày mua
    private Long employeeId;  // ID nhân viên
    private List<ProductDetail> products;  // Danh sách sản phẩm

    // Constructor
    public InvoiceRequest(Long id, Date purchaseDate, Long employeeId, List<ProductDetail> products) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.employeeId = employeeId;
        this.products = products;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public List<ProductDetail> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDetail> products) {
        this.products = products;
    }
}
