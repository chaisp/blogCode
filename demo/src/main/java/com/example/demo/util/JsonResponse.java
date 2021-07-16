package com.example.demo.util;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JsonResponse {

    protected String status;

    protected Object data;

    protected String message;

    public static JsonResponse success() {
        return success(null);
    }

    public static JsonResponse success(Object returnValue) {
        return JsonResponse.builder().status("success").data(returnValue).build();
    }

    public static JsonResponse exception(String message) {
        return JsonResponse.builder().status("exception").message(message).build();
    }
}
