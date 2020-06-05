package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class FilterWord {
    /* renamed from: a */
    private String f6363a;
    /* renamed from: b */
    private String f6364b;
    /* renamed from: c */
    private boolean f6365c;
    /* renamed from: d */
    private List<FilterWord> f6366d;

    public String getId() {
        return this.f6363a;
    }

    public void setId(String str) {
        this.f6363a = str;
    }

    public String getName() {
        return this.f6364b;
    }

    public void setName(String str) {
        this.f6364b = str;
    }

    public boolean getIsSelected() {
        return this.f6365c;
    }

    public void setIsSelected(boolean z) {
        this.f6365c = z;
    }

    public List<FilterWord> getOptions() {
        return this.f6366d;
    }

    public void addOption(FilterWord filterWord) {
        if (filterWord != null) {
            if (this.f6366d == null) {
                this.f6366d = new ArrayList();
            }
            this.f6366d.add(filterWord);
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.f6363a) && !TextUtils.isEmpty(this.f6364b);
    }

    public boolean hasSecondOptions() {
        List<FilterWord> list = this.f6366d;
        return list != null && !list.isEmpty();
    }
}
