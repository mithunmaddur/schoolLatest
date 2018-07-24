package com.school.service.common;

public enum ErrorCode {
	   
    SUCCESS("TRAN_2000", "SUCCESS"),
    PTOID_MISSING_ERR("TRAN_1005", "PTO ID is missing or invalid."),
    UUID_MISSING_ERR("TRAN_1001", "UUID is missing or invalid."),
    CARDID_MISSING_ERR("TRAN_1006", "CARD ID is missing or invalid."),
	CARD_ADD("TRAN_1007", "Unable to add Card"),
	STATUS_MESSAGE_FAILURE("TRAN_1008", "Unable to process the request");

    public final String errCode; 
    public final String message;



    private ErrorCode(String errCode, String message) {
        this.errCode = errCode; 
        this.message = message;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getMessage() {
        return message;
    }

    public static ErrorCode getErrCode(String code, ErrorCode defaultEC){
        for(ErrorCode ec:ErrorCode.values()){
            if(ec.getErrCode() == code){
                return ec;
            }
        }
        return defaultEC;
    }
}