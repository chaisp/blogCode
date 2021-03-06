package com.example.demo.refactor.MetricsModel.Third;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.demo.refactor.MetricsModel.Second.EmailSender;

public class EmailViewer implements StatViewer {
    private EmailSender emailSender;
    private List<String> toAddresses = new ArrayList<>();

    public EmailViewer() {
        this.emailSender = new EmailSender(/* 省略参数 */);
    }

    public EmailViewer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    @Override
    public void output(Map requestStats, long startTimeInMillis, long endTimeInMills) {
        // format the requestStats to
        // HTML style. // send it to
        // email toAddresses.
    }

}