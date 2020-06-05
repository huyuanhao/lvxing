package ezy.p653ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.LayoutParams;
import reezy.lib.common.R;

/* renamed from: ezy.ui.widget.CenteredTitleBar */
public class CenteredTitleBar extends Toolbar {
    int mCenteredSubtitleTextAppearance;
    int mCenteredSubtitleTextColor;
    int mCenteredTitleTextAppearance;
    int mCenteredTitleTextColor;
    CharSequence mSubtitle;
    CharSequence mTitle;
    LinearLayout vCenteredBox;
    TextView vCenteredSubtitle;
    TextView vCenteredTitle;

    public CenteredTitleBar(Context context) {
        super(context);
        init(null, 0);
    }

    public CenteredTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0);
    }

    public CenteredTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i);
    }

    private void init(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Toolbar, i, 0);
        this.mCenteredTitleTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        this.mCenteredSubtitleTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        obtainStyledAttributes.recycle();
        setTitleTextAppearance(getContext(), this.mCenteredTitleTextAppearance);
        setSubtitleTextAppearance(getContext(), this.mCenteredSubtitleTextAppearance);
    }

    private void ensureCenteredBox() {
        if (this.vCenteredBox == null) {
            this.vCenteredBox = new LinearLayout(getContext());
            this.vCenteredBox.setOrientation(1);
            addView(this.vCenteredBox, new LayoutParams(-2, -2, 1));
        }
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.vCenteredTitle == null) {
            ensureCenteredBox();
            this.vCenteredTitle = new AppCompatTextView(getContext());
            this.vCenteredTitle.setSingleLine();
            this.vCenteredTitle.setEllipsize(TruncateAt.END);
            this.vCenteredTitle.setGravity(17);
            if (this.mCenteredTitleTextAppearance != 0) {
                this.vCenteredTitle.setTextAppearance(getContext(), this.mCenteredTitleTextAppearance);
            }
            int i = this.mCenteredTitleTextColor;
            if (i != 0) {
                this.vCenteredTitle.setTextColor(i);
            }
            this.vCenteredTitle.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.vCenteredBox.addView(this.vCenteredTitle, 0);
        }
        TextView textView = this.vCenteredTitle;
        if (textView != null) {
            textView.setText(charSequence);
        }
        this.mTitle = charSequence;
    }

    public void setTitleTextColor(int i) {
        this.mCenteredTitleTextColor = i;
        TextView textView = this.vCenteredTitle;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setTitleTextAppearance(Context context, int i) {
        this.mCenteredTitleTextAppearance = i;
        TextView textView = this.vCenteredTitle;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.vCenteredSubtitle == null) {
            ensureCenteredBox();
            this.vCenteredSubtitle = new AppCompatTextView(getContext());
            this.vCenteredSubtitle.setSingleLine();
            this.vCenteredSubtitle.setEllipsize(TruncateAt.END);
            this.vCenteredSubtitle.setGravity(17);
            this.vCenteredSubtitle.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            if (this.mCenteredSubtitleTextAppearance != 0) {
                this.vCenteredSubtitle.setTextAppearance(getContext(), this.mCenteredSubtitleTextAppearance);
            }
            int i = this.mCenteredSubtitleTextColor;
            if (i != 0) {
                this.vCenteredSubtitle.setTextColor(i);
            }
            this.vCenteredBox.addView(this.vCenteredSubtitle);
        }
        TextView textView = this.vCenteredSubtitle;
        if (textView != null) {
            textView.setText(charSequence);
        }
        this.mSubtitle = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        this.mCenteredSubtitleTextColor = i;
        TextView textView = this.vCenteredSubtitle;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setSubtitleTextAppearance(Context context, int i) {
        this.mCenteredSubtitleTextAppearance = i;
        TextView textView = this.vCenteredSubtitle;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }
}
