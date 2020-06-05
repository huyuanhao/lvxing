package com.tencent.stat;

import android.app.Application;
import android.content.Context;
import com.tencent.stat.StatConfig.AccountType;
import com.tencent.stat.StatConfig.CurrencyType;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.json.JSONObject;

public class StatService {
    public static void trackBeginPage(Context context, String str) {
        StatServiceImpl.trackBeginPage(context, str, null);
    }

    public static void trackEndPage(Context context, String str) {
        StatServiceImpl.trackEndPage(context, str, null);
    }

    public static void startNewSession(Context context) {
        StatServiceImpl.startNewSession(context, null);
    }

    public static void stopSession() {
        StatServiceImpl.stopSession();
    }

    public static void registerActivityLifecycleCallbacks(Application application) {
        StatServiceImpl.registerActivityLifecycleAutoStat(application, null);
    }

    public static void onResume(Context context) {
        StatServiceImpl.onResume(context, null);
    }

    public static void setEnvAttributes(Context context, Map<String, String> map) {
        StatServiceImpl.setEnvAttributes(context, map);
    }

    public static void reportQQ(Context context, String str) {
        StatServiceImpl.reportQQ(context, str, null);
    }

    public static void reportAccount(Context context, StatAccount statAccount) {
        StatServiceImpl.reportAccount(context, statAccount, null);
    }

    public static void reportGameUser(Context context, StatGameUser statGameUser) {
        StatServiceImpl.reportGameUser(context, statGameUser, null);
    }

    public static boolean startStatService(Context context, String str, String str2) throws MtaSDkException {
        return StatServiceImpl.startStatService(context, str, str2, null);
    }

    public static void onPause(Context context) {
        StatServiceImpl.onPause(context, null);
    }

    public static int reportError(Context context, String str) {
        return StatServiceImpl.reportError(context, str, null);
    }

    public static int reportException(Context context, Throwable th) {
        return StatServiceImpl.reportException(context, th, (StatSpecifyReportedInfo) null);
    }

    public static int reportException(Context context, int i, String str, String str2) {
        return reportException(context, i, -1, str, str2);
    }

    public static int reportException(Context context, int i, long j, String str, String str2) {
        return StatServiceImpl.reportException(context, i, j, str, str2, null);
    }

    public static int trackCustomEvent(Context context, String str, String... strArr) {
        return StatServiceImpl.trackCustomEvent(context, str, null, strArr);
    }

    public static int reportCustomProperty(Context context, JSONObject jSONObject) {
        return StatServiceImpl.reportCustomProperty(context, jSONObject, null);
    }

    public static void trackCustomKVEvent(Context context, String str, Properties properties) {
        StatServiceImpl.trackCustomKVEvent(context, str, properties, null);
    }

    public static void trackRegAccountEvent(Context context, String str, AccountType accountType) {
        StatServiceImpl.trackRegAccountEvent(context, str, accountType);
    }

    public static void trackPayEvent(Context context, String str, String str2, double d, CurrencyType currencyType) {
        StatServiceImpl.trackPayEvent(context, str, str2, d, currencyType);
    }

    public static int trackCustomKVTimeIntervalEvent(Context context, int i, String str, Properties properties) {
        return StatServiceImpl.trackCustomKVTimeIntervalEvent(context, str, properties, i, null);
    }

    public static int trackCustomBeginEvent(Context context, String str, String... strArr) {
        return StatServiceImpl.trackCustomBeginEvent(context, str, null, strArr);
    }

    public static int trackCustomEndEvent(Context context, String str, String... strArr) {
        return StatServiceImpl.trackCustomEndEvent(context, str, null, strArr);
    }

    public static int trackCustomBeginKVEvent(Context context, String str, Properties properties) {
        return StatServiceImpl.trackCustomBeginKVEvent(context, str, properties, null);
    }

    public static int trackCustomEndKVEvent(Context context, String str, Properties properties) {
        return StatServiceImpl.trackCustomEndKVEvent(context, str, properties, null);
    }

    public static void reportAppMonitorStat(Context context, StatAppMonitor statAppMonitor) {
        StatServiceImpl.reportAppMonitorStat(context, statAppMonitor, null);
    }

    public static void commitEvents(Context context, int i) {
        StatServiceImpl.commitEvents(context, i);
    }

    public static void testSpeed(Context context) {
        StatServiceImpl.testSpeed(context);
    }

    public static void testSpeed(Context context, Map<String, Integer> map) {
        StatServiceImpl.testSpeed(context, map, null);
    }

    public static void flushDataToDB(Context context) {
        StatServiceImpl.flushDataToDB(context);
    }

    public static void getFeedBackMessage(Context context, int i, int i2, StatFBDispatchCallback statFBDispatchCallback) {
        StatServiceImpl.getFeedBackMessage(context, i, i2, statFBDispatchCallback);
    }

    public static void replyFeedBackMessage(Context context, String str, String str2, StatFBDispatchCallback statFBDispatchCallback) {
        StatServiceImpl.replyFeedBackMessage(context, str, str2, statFBDispatchCallback);
    }

    public static void postFeedBackFiles(Context context, String str, String str2, StatFBDispatchCallback statFBDispatchCallback) {
        StatServiceImpl.postFeedBackFiles(context, str, str2, statFBDispatchCallback);
    }

    public static void setContext(Context context) {
        StatServiceImpl.setContext(context);
    }

    public static void onStop(Context context) {
        StatServiceImpl.onStop(context, null);
    }

    public static void onLowMemory(Context context) {
        StatServiceImpl.onLowMemory(context);
    }

    public static void setCommonKeyValueForKVEvent(String str, Properties properties) {
        StatServiceImpl.setCommonKeyValueForKVEvent(str, properties);
    }

    public static Properties getCommonKeyValueForKVEvent(String str) {
        return StatServiceImpl.getCommonKeyValueForKVEvent(str);
    }

    public static boolean isForeground() {
        return StatServiceImpl.isForeground();
    }

    public static boolean isBackground() {
        return StatServiceImpl.isBackground();
    }

    public static void addActionListener(StatActionListener statActionListener) {
        StatServiceImpl.addActionListener(statActionListener);
    }

    public static void removeActionListener(StatActionListener statActionListener) {
        StatServiceImpl.removeActionListener(statActionListener);
    }

    public static void testJavaCrash(Context context) {
        StatServiceImpl.testJavaCrash(context);
    }

    public static Map<StatMultiAccount.AccountType, StatMultiAccount> getMultiAccount() {
        return StatServiceImpl.getMultiAccount();
    }

    public static void removeMultiAccount(Context context, StatMultiAccount.AccountType accountType) {
        StatServiceImpl.removeMultiAccount(context, accountType, null);
    }

    public static void reportAccountLogout(Context context, StatMultiAccount.AccountType accountType) {
        StatServiceImpl.removeMultiAccount(context, accountType, null);
    }

    public static void reportMultiAccount(Context context, StatMultiAccount statMultiAccount) {
        StatServiceImpl.reportMultiAccount(context, statMultiAccount, (StatSpecifyReportedInfo) null);
    }

    public static void reportMultiAccount(Context context, List<StatMultiAccount> list) {
        StatServiceImpl.reportMultiAccount(context, list, (StatSpecifyReportedInfo) null);
    }
}
