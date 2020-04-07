package com.lemeng.personal.model;

/**
 * 系统返回码
 *
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
public enum SystemRespCode {
    /**
     * 成功
     */
    SUCCESS(0, "成功"),
    /**
     * 方法执行失败
     */
    METHOD_ERROR(10001, "方法执行失败"),
    /**
     * 方法执行失败
     */
    SYSTEM_ERROR(10001, "系统异常");

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
