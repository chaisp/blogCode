package com.example.demo.refactor.MetricsModel.Fourth;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.example.demo.refactor.MetricsModel.Second.MetricsStorage;
import com.example.demo.refactor.MetricsModel.Third.Aggregator;
import com.example.demo.refactor.MetricsModel.Third.StatViewer;
import com.google.common.annotations.VisibleForTesting;

public class EmailReporter extends ScheduledReporter {
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    private MetricsStorage metricsStorage;
    private Aggregator aggregator;
    private StatViewer viewer;

    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        super(metricsStorage, aggregator, viewer);
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }

    public void startDailyReport() {
        Date firstTime = trimTimeFieldsToZeroOfNextDay(new Date());

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                doStatAndReport(startTimeInMillis, endTimeInMillis);
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }

    @VisibleForTesting
    protected Date trimTimeFieldsToZeroOfNextDay(Date date) {
        // 这里可以获取当前时间
        Calendar calendar = Calendar.getInstance();
        // 重新设置时间
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}