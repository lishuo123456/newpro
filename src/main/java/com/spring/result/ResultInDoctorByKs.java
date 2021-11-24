package com.spring.result;

public class ResultInDoctorByKs {

    private Integer code;
    private String message;
    private Object object;
    private Object object2;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getObject2() {
        return object2;
    }

    public void setObject2(Object object2) {
        this.object2 = object2;
    }

    public ResultInDoctorByKs(Integer code, String message, Object object, Object object2) {
        this.code = code;
        this.message = message;
        this.object = object;
        this.object2 = object2;
    }

    public ResultInDoctorByKs() {
    }

    @Override
    public String toString() {
        return "ResultInDoctorByKs{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", object=" + object +
                ", object2=" + object2 +
                '}';
    }
}
