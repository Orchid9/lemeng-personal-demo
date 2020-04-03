package com.lemeng.personal.config;

import com.lemeng.personal.model.SystemRespCode;
import com.nhsoft.provider.common.AbstractException;

public class SystemException extends AbstractException {
    public SystemException(SystemRespCode systemRespCode) {
        super(systemRespCode.getRespCode(), systemRespCode.getRepDesc());
    }
}
