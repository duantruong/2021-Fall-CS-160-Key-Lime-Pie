package com.microegg.response;


public class ApiRestResponse {

    private Boolean isSuccess = true;

    private Boolean isError = false;

    private String errorMessage = null;

    private Object data;

    public ApiRestResponse(){
        isSuccess = true;
        isError = false;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public Boolean getError() {
        return isError;
    }

    public void setError(Boolean error) {
        isError = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
