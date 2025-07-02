package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataItem {
    private int id;
    private String date;
    private String description;
    private String category;
    private double amount;
    private String currency;
    private String type;
}
