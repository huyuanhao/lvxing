package com.kingja.loadsir.callback;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Callback implements Serializable {
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public OnReloadListener onReloadListener;
    /* access modifiers changed from: private */
    public View rootView;
    private boolean successViewVisible;

    /* renamed from: com.kingja.loadsir.callback.Callback$OnReloadListener */
    public interface OnReloadListener extends Serializable {
        void onReload(View view);
    }

    public void onAttach(Context context2, View view) {
    }

    /* access modifiers changed from: protected */
    public View onBuildView(Context context2) {
        return null;
    }

    public abstract int onCreateView();

    public void onDetach() {
    }

    /* access modifiers changed from: protected */
    public boolean onReloadEvent(Context context2, View view) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onRetry(Context context2, View view) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onViewCreate(Context context2, View view) {
    }

    public Callback() {
    }

    Callback(View view, Context context2, OnReloadListener onReloadListener2) {
        this.rootView = view;
        this.context = context2;
        this.onReloadListener = onReloadListener2;
    }

    public Callback setCallback(View view, Context context2, OnReloadListener onReloadListener2) {
        this.rootView = view;
        this.context = context2;
        this.onReloadListener = onReloadListener2;
        return this;
    }

    public View getRootView() {
        if (onCreateView() == 0) {
            View view = this.rootView;
            if (view != null) {
                return view;
            }
        }
        if (onBuildView(this.context) != null) {
            this.rootView = onBuildView(this.context);
        }
        if (this.rootView == null) {
            this.rootView = View.inflate(this.context, onCreateView(), null);
        }
        this.rootView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Callback callback = Callback.this;
                if (!callback.onReloadEvent(callback.context, Callback.this.rootView) && Callback.this.onReloadListener != null) {
                    Callback.this.onReloadListener.onReload(view);
                }
            }
        });
        onViewCreate(this.context, this.rootView);
        return this.rootView;
    }

    public boolean getSuccessVisible() {
        return this.successViewVisible;
    }

    /* access modifiers changed from: 0000 */
    public void setSuccessVisible(boolean z) {
        this.successViewVisible = z;
    }

    public Callback copy() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Object obj = null;
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            obj = objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (Callback) obj;
    }

    public View obtainRootView() {
        if (this.rootView == null) {
            this.rootView = View.inflate(this.context, onCreateView(), null);
        }
        return this.rootView;
    }
}
