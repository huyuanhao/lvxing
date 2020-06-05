package com.kwad.sdk.feed;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p342b.C4322a;
import com.kwad.sdk.core.response.p342b.C4324c;

public enum FeedType {
    FEED_TYPE_UNKNOWN(0),
    FEED_TYPE_TEXT_IMMERSE(1),
    FEED_TYPE_TEXT_LEFT(2),
    FEED_TYPE_TEXT_RIGHT(3),
    FEED_TYPE_TEXT_ABOVE(4),
    FEED_TYPE_TEXT_BELOW(5),
    FEED_TYPE_TEXT_ABOVE_GROUP(6);
    
    private int type;

    private FeedType(int i) {
        this.type = i;
    }

    public static boolean checkTypeValid(AdTemplate adTemplate) {
        boolean z;
        int z2 = C4322a.m17658z(C4324c.m17668e(adTemplate));
        FeedType fromInt = fromInt(adTemplate.type);
        boolean z3 = false;
        if (z2 == 1) {
            if (fromInt == FEED_TYPE_TEXT_ABOVE || fromInt == FEED_TYPE_TEXT_BELOW) {
                z = true;
            }
            return z;
        } else if (z2 == 2) {
            if (!(fromInt == FEED_TYPE_UNKNOWN || fromInt == FEED_TYPE_TEXT_ABOVE_GROUP)) {
                z3 = true;
            }
            return z3;
        } else if (z2 != 3) {
            return false;
        } else {
            if (fromInt != FEED_TYPE_UNKNOWN) {
                z3 = true;
            }
            return z3;
        }
    }

    public static FeedType fromInt(int i) {
        FeedType[] values;
        for (FeedType feedType : values()) {
            if (feedType.type == i) {
                return feedType;
            }
        }
        return FEED_TYPE_UNKNOWN;
    }
}
