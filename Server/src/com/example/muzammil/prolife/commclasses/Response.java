package com.example.muzammil.prolife.commclasses;

import java.io.Serializable;

public class Response implements Serializable {
    private ResponseType responseType;

    public Response(ResponseType responseType) {
        this.responseType = responseType;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }
}
