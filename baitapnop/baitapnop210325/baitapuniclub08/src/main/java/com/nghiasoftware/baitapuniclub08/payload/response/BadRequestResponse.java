package com.nghiasoftware.baitapuniclub08.payload.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BadRequestResponse<ErrMessage> extends BaseResponse<ErrMessage> {
    private static final int code = HttpStatus.BAD_REQUEST.value();
    private static final String message = HttpStatus.BAD_REQUEST.getReasonPhrase();

    public BadRequestResponse(ErrMessage errMessage) {
        super(code, message);
        setData(errMessage);
    }
}
