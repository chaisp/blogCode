package com.example.demo.refactor.MetricsModel.Second;

import org.springframework.beans.factory.annotation.Autowired;

import cn.hutool.core.util.StrUtil;

public class MetricsCollector {
    @Autowired
    private MetricsStorage metricsStorage;// 基于接口而非实现编程

    // 依赖注入
    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    // 用一个函数代替了最小原型中的两个函数
    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StrUtil.isBlank(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}
