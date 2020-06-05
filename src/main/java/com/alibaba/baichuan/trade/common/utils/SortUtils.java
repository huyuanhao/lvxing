package com.alibaba.baichuan.trade.common.utils;

import java.io.Serializable;

public class SortUtils {

    /* renamed from: com.alibaba.baichuan.trade.common.utils.SortUtils$SortInfo */
    public static class SortInfo implements Serializable {
        private static final long serialVersionUID = 3959903664223165585L;
        public String[] after;
        public Boolean afterAll;
        public String[] before;
        public Boolean beforeAll;
        public String name;
    }
}
