package com.example.order.common;


import com.example.order.Dto.OrderDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;

@Getter
public class succesOrderResponse implements Orderesponse {
    @JsonUnwrapped
    private final OrderDto order;
    public succesOrderResponse(OrderDto order) {
        this.order = order;
    }
}
