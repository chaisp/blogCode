package com.example.demo.refactor.MetricsModel.Third;

import java.util.Map;

public interface StatViewer {
    void output(Map requestStats, long startTimeInMillis, long endTimeInMills);
}