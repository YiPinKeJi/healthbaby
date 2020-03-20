package com.killerfox.hedm.healthbaby.common.exception;


import com.killerfox.hedm.healthbaby.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Slf4j
@ControllerAdvice
public class GlobalDefultExceptionHandler {

    //声明要捕获的异常
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result handleExceptionHandler(HttpServletResponse response, Exception e) {

        BusinessException excep = (BusinessException)e;

        response.setStatus(excep.getResultCode().code());

        Result result = new Result();
        result.setResultCodeMessage(excep.getResultCode(), excep.getMessage());

        return result;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result handleMethodArgumentNotValidException(HttpServletResponse response, MethodArgumentNotValidException e){

        BindingResult bindingResult = e.getBindingResult();
        final List<ObjectError> errorList = bindingResult.getAllErrors();
        String error = "[";
        for (ObjectError objectError : errorList) {
            error += objectError.getDefaultMessage() + "|";
        }
        error = error.substring(0, error.lastIndexOf("|"));
        error += "]";

        Result ret = MethodArgumentNotValid.getResult(error);
        response.setStatus(ret.getCode());
        return ret;
    }

}
