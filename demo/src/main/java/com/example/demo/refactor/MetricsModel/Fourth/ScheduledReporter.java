package com.example.demo.refactor.MetricsModel.Fourth;

import java.util.List;
import java.util.Map;

import com.example.demo.refactor.MetricsModel.Second.MetricsStorage;
import com.example.demo.refactor.MetricsModel.Second.RequestInfo;
import com.example.demo.refactor.MetricsModel.Second.RequestStat;
import com.example.demo.refactor.MetricsModel.Third.Aggregator;
import com.example.demo.refactor.MetricsModel.Third.StatViewer;

public abstract class ScheduledReporter {
    protected MetricsStorage metricsStorage;
    protected Aggregator aggregator;
    protected StatViewer viewer;

    public ScheduledReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }

    protected void doStatAndReport(long startTimeInMillis, long endTimeInMillis) {
        long durationInMillis = endTimeInMillis - startTimeInMillis;
        Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis,
                endTimeInMillis);
        Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfos, durationInMillis);
        viewer.output(requestStats, startTimeInMillis, endTimeInMillis);
    }

}