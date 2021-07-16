package com.example.demo.refactor.MetricsModel.Third;

import java.util.Map;

import com.google.gson.Gson;

public class ConsoleViewer implements StatViewer {
    public void output(Map requestStats, long startTimeInMillis, long endTimeInMills) {
        System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMills + "]");
        Gson gson = new Gson();
        System.out.println(gson.toJson(requestStats));
    }
}