package com.example.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvetoryDto {
    public int Id;
    public int ItemId;
    public int ProductId;
    public int quantity;
}
