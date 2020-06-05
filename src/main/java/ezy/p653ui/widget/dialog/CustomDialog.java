package ezy.p653ui.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import androidx.appcompat.widget.LinearLayoutCompat;

/* renamed from: ezy.ui.widget.dialog.CustomDialog */
public class CustomDialog extends Dialog {
    Animation mAnimationEnter;
    Animation mAnimationExit;
    boolean mIsCanceledOnTouchOutside;
    LinearLayoutCompat vRoot;

    /* renamed from: ezy.ui.widget.dialog.CustomDialog$Builder */
    public static class Builder {
        private final Context mContext;
        private final int mTheme;
        private View mView;

        public Builder(Context context) {
            this(context, 0);
        }

        public Builder(Context context, int i) {
            this.mContext = context;
            this.mTheme = i;
        }

        public Builder setView(View view) {
            this.mView = view;
            return this;
        }

        public CustomDialog create() {
            CustomDialog customDialog = new CustomDialog(this.mContext, this.mTheme);
            customDialog.setView(this.mView);
            return customDialog;
        }

        public CustomDialog show() {
            CustomDialog create = create();
            create.show();
            return create;
        }
    }

    /* renamed from: ezy.ui.widget.dialog.CustomDialog$DismissAction */
    static class DismissAction implements OnClickListener {
        final Dialog dialog;
        final DialogInterface.OnClickListener listener;

        public DismissAction(Dialog dialog2, DialogInterface.OnClickListener onClickListener) {
            this.dialog = dialog2;
            this.listener = onClickListener;
        }

        public void onClick(View view) {
            DialogInterface.OnClickListener onClickListener = this.listener;
            if (onClickListener != null) {
                onClickListener.onClick(this.dialog, view.getId());
            }
            this.dialog.dismiss();
        }
    }

    public CustomDialog(Context context) {
        this(context, 0);
    }

    public CustomDialog(Context context, int i) {
        super(context, i);
        this.mIsCanceledOnTouchOutside = false;
        setAnimation(scale(0.8f, 1.0f, 0.8f, 1.0f), null);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().clearFlags(2);
        getWindow().setWindowAnimations(0);
        getWindow().setLayout(-2, -2);
        this.vRoot = new LinearLayoutCompat(getContext());
        this.vRoot.setOrientation(1);
    }

    public CustomDialog setDimAmount(float f) {
        if (f > 0.0f) {
            getWindow().setFlags(2, 2);
            getWindow().setDimAmount(f);
        } else {
            getWindow().clearFlags(2);
            getWindow().setDimAmount(0.0f);
        }
        return this;
    }

    public CustomDialog setAnimation(Animation animation, Animation animation2) {
        this.mAnimationEnter = animation;
        this.mAnimationExit = animation2;
        return this;
    }

    public CustomDialog setView(View view) {
        setContentView(view);
        return this;
    }

    public CustomDialog setView(int i) {
        setContentView(i);
        return this;
    }

    public CustomDialog setActions(OnClickListener onClickListener, int... iArr) {
        for (int findViewById : iArr) {
            View findViewById2 = this.vRoot.findViewById(findViewById);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(onClickListener);
            }
        }
        return this;
    }

    public CustomDialog setDismissActions(DialogInterface.OnClickListener onClickListener, int... iArr) {
        setActions(new DismissAction(this, onClickListener), iArr);
        return this;
    }

    public CustomDialog showIt() {
        show();
        return this;
    }

    public void dismissImmediately() {
        super.dismiss();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(this.vRoot, new LayoutParams(-1, -2));
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        this.mIsCanceledOnTouchOutside = z;
    }

    public void setContentView(View view) {
        this.vRoot.addView(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        this.vRoot.addView(view, layoutParams);
    }

    public void setContentView(int i) {
        setContentView(getLayoutInflater().inflate(i, this.vRoot, false));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.vRoot.getChildCount() != 0) {
            Animation animation = this.mAnimationEnter;
            if (animation != null && !isAnimating(animation)) {
                this.mAnimationEnter.reset();
                this.vRoot.startAnimation(this.mAnimationEnter);
            }
        }
    }

    public void dismiss() {
        if (this.vRoot.getChildCount() != 0) {
            Animation animation = this.mAnimationExit;
            if (animation != null) {
                if (!isAnimating(animation)) {
                    this.mAnimationExit.reset();
                    this.mAnimationExit.setAnimationListener(new AnimationListener() {
                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }

                        public void onAnimationEnd(Animation animation) {
                            CustomDialog.this.dismissImmediately();
                        }
                    });
                    this.vRoot.startAnimation(this.mAnimationExit);
                    return;
                }
                return;
            }
        }
        dismissImmediately();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isAnimating(this.mAnimationEnter) || isAnimating(this.mAnimationExit)) {
            return true;
        }
        if (motionEvent.getAction() == 0) {
            Rect rect = new Rect();
            this.vRoot.getHitRect(rect);
            if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY()) && this.mIsCanceledOnTouchOutside) {
                dismiss();
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onBackPressed() {
        if (!isAnimating(this.mAnimationEnter) && !isAnimating(this.mAnimationExit)) {
            super.onBackPressed();
        }
    }

    protected static Animation translate(float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 1, f, 1, f2);
        translateAnimation.setDuration(250);
        return translateAnimation;
    }

    protected static Animation scale(float f, float f2, float f3, float f4) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f3, f4, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(250);
        return scaleAnimation;
    }

    /* access modifiers changed from: 0000 */
    public boolean isAnimating(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    /* access modifiers changed from: protected */
    public int dp2px(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }
}
