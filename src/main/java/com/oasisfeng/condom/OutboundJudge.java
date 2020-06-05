package com.oasisfeng.condom;

import android.content.Intent;

public interface OutboundJudge {
    boolean shouldAllow(OutboundType outboundType, Intent intent, String str);
}
