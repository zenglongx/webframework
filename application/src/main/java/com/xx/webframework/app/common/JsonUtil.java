package com.xx.webframework.app.common;

import com.google.gson.Gson;

public class JsonUtil {

    public static String toJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }
}
