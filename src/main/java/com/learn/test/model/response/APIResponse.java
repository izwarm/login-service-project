package com.learn.test.model.response;

import lombok.Data;

@Data
public class APIResponse {

    private Object status;

    private Object responseData;

    private Object error;

}
