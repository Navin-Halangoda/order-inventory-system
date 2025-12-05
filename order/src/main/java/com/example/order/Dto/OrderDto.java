package com.example.order.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    public   int Id;
    public  int ItemId;
    public  String Date;
    public  int Amount;
}
