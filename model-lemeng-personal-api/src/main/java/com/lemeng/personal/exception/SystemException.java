package com.lemeng.personal.exception;

import com.nhsoft.provider.common.AbstractException;

/**
 * 系统异常
 *
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
public class SystemException extends AbstractException {
    public SystemException(SystemRespCode systemRespCode) {
        super(systemRespCode.getRespCode(), systemRespCode.getRepDesc());
    }
}
