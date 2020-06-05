package com.kwad.sdk.core.request;

public enum ErrorCode {
    ERROR_NO_NETWORK(40001, "网络错误"),
    ERROR_DATA_PARSE_FAIL(40002, "数据解析错误"),
    ERROR_DATA_EMPTY(40003, "广告数据为空"),
    ERROR_CACHE_VIDEO_FAIL(40004, "视频资源缓存失败");
    
    public int errorCode;
    public String msg;

    private ErrorCode(int i, String str) {
        this.errorCode = i;
        this.msg = str;
    }
}
