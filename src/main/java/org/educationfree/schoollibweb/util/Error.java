package org.educationfree.schoollibweb.util;

public enum Error {
    BAD_REQUEST(400, "Bad request!"),
    UNAUTHORIZED(401, "Unauthorized!"),
    FORBIDDEN(401, "Forbidden!"),
    NOT_FOUND(404, "Not found!"),
    INTERNAL_SERVER_ERROR(500, "Internal server error!");

    int errorCode;
    String errorMessage;

    Error(int errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public static Error getError(int errorCode){
        for (Error error: Error.values()){
            if (errorCode == error.getErrorCode()){
                return error;
            }
        }
        return null;
    }
}
