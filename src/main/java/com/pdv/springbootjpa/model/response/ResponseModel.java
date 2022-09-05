package com.pdv.springbootjpa.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel<T> {

    private ResponseStatus status;
    private T data;

    public ResponseModel(int code) {
        if (this.getStatus() == null) {
            this.status = new ResponseStatus().setCode(code);
        } else {
            this.status.setCode(code);
        }
    }
}