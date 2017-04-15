package com.example.handler;

import com.example.constants.WxErrorCode;
import com.example.entity.ResponseDto;
import com.example.entity.Result;
import com.example.exception.MyException;
import com.example.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by cc on 17-4-12.
 */
@RestControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e){

        if (e instanceof MyException){
            MyException myException = (MyException) e;
            return ResultUtil.error(myException.getCode(),myException.getMessage(),myException.getData());
        }else if (e instanceof HttpMessageNotReadableException){
            logger.error("[输入参数错误]"+e);
            return ResultUtil.error(WxErrorCode.SYS_ERROR_PARAMS);
        }else {
            logger.error("[系统错误]"+e);
            return ResultUtil.error(WxErrorCode.SYS_ERROR);
        }

    }
}
