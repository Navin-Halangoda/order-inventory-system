package com.example.order.common;

import lombok.Getter;

@Getter
public class ErrorOrderResponse implements Orderesponse{
    private final String errormessage;

    public ErrorOrderResponse(String errormessage) {
        this.errormessage = errormessage;
    }
}
