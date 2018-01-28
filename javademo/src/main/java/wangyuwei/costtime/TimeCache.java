package wangyuwei.costtime;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bazhang on 2017/3/1.
 */
public class TimeCache {

    public static Map<String, Long> sStartTime = new HashMap<>();
    public static Map<String, Long> sEndTime = new HashMap<>();

    public static void setStartTime(String methodName, long time) {
        Thread thread = Thread.currentThread();
        sStartTime.put(thread.getId()+methodName, time);
    }

    public static void setEndTime(String methodName, long time) {
        Thread thread = Thread.currentThread();
        sEndTime.put(thread.getId()+methodName, time);
    }

    public static String getCostTime(String methodName) {
        Thread thread = Thread.currentThread();
        long id = thread.getId();
        long start = sStartTime.get(id+methodName);
        long end = sEndTime.get(id +methodName);
        return "ThreadId:"+id+" method: " + methodName + " main " + Long.valueOf(end - start) + " ns";
    }

}
