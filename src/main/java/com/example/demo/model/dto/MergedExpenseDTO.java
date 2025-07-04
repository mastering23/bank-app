package com.example.demo.model.dto;

import lombok.Data;

@Data
public class MergedExpenseDTO {
    private int id;
    private String fullName;
    private String ssnLast4;
    private double amount;
    private String currency;
}
