package com.nghiasoftware.uniclub08.payload.response;

import lombok.Data;

@Data
public class BaseResponse {

    private int code;
    private String message;
    private Object data;

}
