package com.alibaba.baichuan.trade.biz.utils;

import android.text.TextUtils;

public enum AlibcURLCheck {
    regular(0) {
        public boolean check(String[] strArr, String str) {
            if (str == null) {
                return false;
            }
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str2 = strArr[i];
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && str.matches(str2)) {
                    return true;
                }
            }
            return false;
        }
    },
    contains(1) {
        public boolean check(String[] strArr, String str) {
            if (str == null) {
                return false;
            }
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str2 = strArr[i];
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && str.contains(str2)) {
                    return true;
                }
            }
            return false;
        }
    },
    equal(2) {
        public boolean check(String[] strArr, String str) {
            if (str == null) {
                return false;
            }
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str2 = strArr[i];
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && TextUtils.equals(str2, str)) {
                    return true;
                }
            }
            return false;
        }
    };
    
    public int type;
    public String[] urlList;

    private AlibcURLCheck(int i) {
        this.type = -1;
    }

    public static AlibcURLCheck getUrlCheckType(int i) {
        AlibcURLCheck alibcURLCheck = regular;
        return i != 0 ? i != 1 ? i != 2 ? alibcURLCheck : equal : contains : alibcURLCheck;
    }

    public abstract boolean check(String[] strArr, String str);
}
