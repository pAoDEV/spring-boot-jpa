package com.pdv.springbootjpa.util;

import com.pdv.springbootjpa.model.response.ResponseModel;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil {

    public static ResponseModel createResponseModel(int code) {
        return new ResponseModel(code);
    }

    public static ResponseModel createResponseModel(Object data) {
        return new ResponseModel(1000).setData(data);
    }

    public static ResponseModel createResponseModel(int code, Object data) {
        return new ResponseModel(code).setData(data);
    }
}
