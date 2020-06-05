package com.bytedance.sdk.openadsdk;

public interface TTAdDislike {

    /* renamed from: com.bytedance.sdk.openadsdk.TTAdDislike$DislikeInteractionCallback */
    public interface DislikeInteractionCallback {
        void onCancel();

        void onSelected(int i, String str);
    }

    void setDislikeInteractionCallback(DislikeInteractionCallback dislikeInteractionCallback);

    void showDislikeDialog();
}
