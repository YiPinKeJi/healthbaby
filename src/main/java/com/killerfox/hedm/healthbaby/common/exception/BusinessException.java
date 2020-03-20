package com.killerfox.hedm.healthbaby.common.exception;

import com.killerfox.hedm.healthbaby.common.ResultCode;
import lombok.Data;

@Data
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private ResultCode resultCode;

    private String message;

    public BusinessException() {}

    public BusinessException(ResultCode resultCode) {
        super(resultCode.message());
        this.message = resultCode.message();
        this.resultCode = resultCode;
    }

    public BusinessException(ResultCode resultCode , String message) {
        super(resultCode.message());
        this.message = message;
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode(){
        return resultCode;
    }

}
