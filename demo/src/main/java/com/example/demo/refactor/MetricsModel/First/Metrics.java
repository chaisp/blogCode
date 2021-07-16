package com.example.demo.refactor.MetricsModel.First;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

/**
 * 
 * 1.接口统计信息：包括接口响应时间的统计信息，以及接口调用次数的统计信息等。
 * 
 * 2.统计信息的类型：max、min、avg、percentile、count、tps 等。
 * 
 * 3.统计信息显示格式：Json、Html、自定义显示格式。
 * 
 * 4.统计信息显示终端：Console、Email、HTTP 网页、日志、自定义显示终端
 * 
 * 5.统计触发方式：包括主动和被动两种。主动表示以一定的频率定时统计数据，并主动推送到显示终端，比如邮件推送。被动表示用户触发统计，
 * 比如用户在网页中选择要统计的时间区间，触发统计，并将结果显示给用户。
 * 
 * 6. 统计时间区间：框架需要支持自定义统计时间区间，比如统计最近 10 分钟的某接口的 tps、访问次数，或者统计 12 月 11 日 00 点到 12
 * 月 12 日 00 点之间某接口响应时间的最大值、最小值、平均值等。
 * 
 * 7.统计时间间隔：对于主动触发统计，我们还要支持指定统计时间间隔，也就是多久触发一次统计显示。比如，每间隔 10s 统计一次接口信息并显示到命令行中，
 * 每间隔24 小时发送一封统计信息邮件。
 */
public class Metrics {
    // Map的key是接口名称，value对应接口请求的响应时间或时间戳；
    private Map<String, List<Double>> responseTimes = new HashMap<>();
    private Map<String, List<Double>> timestamps = new HashMap<>();
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public void recordResponseTime(String apiName, double responseTime) {
        responseTimes.putIfAbsent(apiName, new ArrayList<>());
        responseTimes.get(apiName).add(responseTime);
    }

    public void recordTimestamp(String apiName, double timestamp) {
        timestamps.putIfAbsent(apiName, new ArrayList<>());
        timestamps.get(apiName).add(timestamp);
    }

    public void startRepeatedReport(long period, TimeUnit unit) {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                Map<String, Map<String, Double>> stats = new HashMap<>();
                for (Map.Entry<String, List<Double>> entry : responseTimes.entrySet()) {
                    String apiName = entry.getKey();
                    List<Double> apiRespTimes = entry.getValue();
                    stats.putIfAbsent(apiName, new HashMap<>());
                    stats.get(apiName).put("max", max(apiRespTimes));
                    stats.get(apiName).put("avg", avg(apiRespTimes));
                }

                for (Map.Entry<String, List<Double>> entry : timestamps.entrySet()) {
                    String apiName = entry.getKey();
                    List<Double> apiTimestamps = entry.getValue();
                    stats.putIfAbsent(apiName, new HashMap<>());
                    stats.get(apiName).put("count", (double) apiTimestamps.size());
                }
                System.out.println(gson.toJson(stats));
            }
        }, 0, period, unit);
    }

    private double max(List<Double> dataset) {// 省略代码实现
        return 0d;
    }

    private double avg(List<Double> dataset) {// 省略代码实现
        return 0d;
    }
}