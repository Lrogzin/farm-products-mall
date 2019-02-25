package com.nuzoul.mall.user.service.resp;

import com.nuzoul.mall.common.service.BaseResp;

/**
 * @Author: nuzoul
 * @Date: 2019/2/24 22:23
 */
public class TestUserResp extends BaseResp {

    private String testResult;

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
}
