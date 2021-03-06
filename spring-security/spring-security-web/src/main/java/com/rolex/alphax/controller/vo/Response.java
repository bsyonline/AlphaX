/*
 * Copyright (C) 2021 bsyonline
 */
package com.rolex.alphax.controller.vo;

import com.sun.org.apache.regexp.internal.RE;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author rolex
 * @since 2021
 */
@Data
@AllArgsConstructor
public class Response {

    private int code;
    private String msg;

    public static Response success(){
        return new Response(200, "success");
    }

    public static Response failure(int code, String msg){
        return new Response(code, msg);
    }

}
