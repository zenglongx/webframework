package com.xx.webframework.app.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseResult{
    private String code;
    private String data;
    private String message;
}
