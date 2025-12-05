package com.example.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Productdto {
    public int Id;
    public int productId;
    public String prodctName;
    public String description;
    public int forsale;
}
