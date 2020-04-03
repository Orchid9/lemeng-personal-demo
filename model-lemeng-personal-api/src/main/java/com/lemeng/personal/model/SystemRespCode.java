package com.lemeng.personal.model;

public enum SystemRespCode {
    SUCCESS(0, "成功"),
    SEARCH_ERROR(10001, "查询失败");

    private final Integer respCode;
    private final String repDesc;

    public Integer getRespCode() {
        return respCode;
    }

    public String getRepDesc() {
        return repDesc;
    }

    SystemRespCode(Integer code, String describe) {
        this.respCode = code;
        this.repDesc = describe;
    }

}
