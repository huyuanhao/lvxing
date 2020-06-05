package com.qiyukf.unicorn.api.pop;

import java.util.List;

public interface OnSessionListChangedListener {
    void onSessionDelete(String str);

    void onSessionUpdate(List<Session> list);
}
