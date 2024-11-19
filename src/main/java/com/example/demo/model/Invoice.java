package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Invoice {

    public  double getTotalAmount;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date purchaseDate;

    @ManyToOne
    private Employee employee;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<InvoiceItem> items;

    public Invoice() {}
    private double totalAmount;

    public Invoice(Date purchaseDate, Employee employee, List<InvoiceItem> items) {
        this.purchaseDate = purchaseDate;
        this.employee = employee;
        this.items = items;
        this.totalAmount = getTotalAmount();
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;

    }



    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // Custom Getter for Total Amount
    public double getTotalAmount() {
        return items.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }
}
