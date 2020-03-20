package com.killerfox.hedm.healthbaby.common.exception;


import com.killerfox.hedm.healthbaby.common.Result;
import com.killerfox.hedm.healthbaby.common.ResultCode;

public class MethodArgumentNotValid extends RuntimeException {


    public static Result getResult(String message){

        Result ret = new Result(ResultCode.PARAM_IS_ERROR.code() , message);

        return ret;
    }

    public static Result getResult(){

        return Result.failure(ResultCode.PARAM_IS_ERROR);
    }
}
