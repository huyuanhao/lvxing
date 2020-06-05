package p681me.jessyan.autosize;

import android.app.Activity;

/* renamed from: me.jessyan.autosize.WrapperAutoAdaptStrategy */
public class WrapperAutoAdaptStrategy implements AutoAdaptStrategy {
    private final AutoAdaptStrategy mAutoAdaptStrategy;

    public WrapperAutoAdaptStrategy(AutoAdaptStrategy autoAdaptStrategy) {
        this.mAutoAdaptStrategy = autoAdaptStrategy;
    }

    public void applyAdapt(Object obj, Activity activity) {
        onAdaptListener onAdaptListener = AutoSizeConfig.getInstance().getOnAdaptListener();
        if (onAdaptListener != null) {
            onAdaptListener.onAdaptBefore(obj, activity);
        }
        AutoAdaptStrategy autoAdaptStrategy = this.mAutoAdaptStrategy;
        if (autoAdaptStrategy != null) {
            autoAdaptStrategy.applyAdapt(obj, activity);
        }
        if (onAdaptListener != null) {
            onAdaptListener.onAdaptAfter(obj, activity);
        }
    }
}
