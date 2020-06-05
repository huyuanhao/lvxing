package com.tencent.qqpim.discovery;

import java.util.List;

public interface IConch {

    /* renamed from: com.tencent.qqpim.discovery.IConch$CommonConchArgs */
    public static class CommonConchArgs {
        public String arg0;
        public String arg1;
        public String arg2;
        public String arg3;
        public String arg4;

        public CommonConchArgs() {
            String str = "";
            this.arg0 = str;
            this.arg1 = str;
            this.arg2 = str;
            this.arg3 = str;
            this.arg4 = str;
        }
    }

    /* renamed from: com.tencent.qqpim.discovery.IConch$IConchPushListener */
    public static abstract class IConchPushListener {
        public abstract void onRecvPush(int i, CommonConchArgs commonConchArgs);
    }

    void registerConchPush(List<Integer> list, IConchPushListener iConchPushListener);

    void unRegisterConchPush(int i);
}
