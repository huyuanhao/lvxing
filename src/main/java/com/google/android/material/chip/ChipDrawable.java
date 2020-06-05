package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat.FontCallback;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import com.google.android.material.C2622R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParserException;

public class ChipDrawable extends Drawable implements Callback, TintAwareDrawable {
    private static final boolean DEBUG = false;
    private static final int[] DEFAULT_STATE = {16842910};
    private static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    private int alpha = 255;
    private boolean checkable;
    private Drawable checkedIcon;
    private boolean checkedIconVisible;
    private ColorStateList chipBackgroundColor;
    private float chipCornerRadius;
    private float chipEndPadding;
    private Drawable chipIcon;
    private float chipIconSize;
    private ColorStateList chipIconTint;
    private boolean chipIconVisible;
    private float chipMinHeight;
    private final Paint chipPaint = new Paint(1);
    private float chipStartPadding;
    private ColorStateList chipStrokeColor;
    private float chipStrokeWidth;
    private Drawable closeIcon;
    private CharSequence closeIconContentDescription;
    private float closeIconEndPadding;
    private float closeIconSize;
    private float closeIconStartPadding;
    private int[] closeIconStateSet;
    private ColorStateList closeIconTint;
    private boolean closeIconVisible;
    private ColorFilter colorFilter;
    private ColorStateList compatRippleColor;
    private final Context context;
    private boolean currentChecked;
    private int currentChipBackgroundColor;
    private int currentChipStrokeColor;
    private int currentCompatRippleColor;
    private int currentTextColor;
    private int currentTint;
    private final Paint debugPaint;
    private WeakReference<Delegate> delegate = new WeakReference<>(null);
    private final FontCallback fontCallback = new FontCallback() {
        public void onFontRetrievalFailed(int i) {
        }

        public void onFontRetrieved(Typeface typeface) {
            ChipDrawable.this.textWidthDirty = true;
            ChipDrawable.this.onSizeChange();
            ChipDrawable.this.invalidateSelf();
        }
    };
    private final FontMetrics fontMetrics = new FontMetrics();
    private MotionSpec hideMotionSpec;
    private float iconEndPadding;
    private float iconStartPadding;
    private int maxWidth;
    private final PointF pointF = new PointF();
    private CharSequence rawText;
    private final RectF rectF = new RectF();
    private ColorStateList rippleColor;
    private boolean shouldDrawText;
    private MotionSpec showMotionSpec;
    private TextAppearance textAppearance;
    private float textEndPadding;
    private final TextPaint textPaint = new TextPaint(1);
    private float textStartPadding;
    private float textWidth;
    /* access modifiers changed from: private */
    public boolean textWidthDirty = true;
    private ColorStateList tint;
    private PorterDuffColorFilter tintFilter;
    private Mode tintMode = Mode.SRC_IN;
    private TruncateAt truncateAt;
    private CharSequence unicodeWrappedText;
    private boolean useCompatRipple;

    /* renamed from: com.google.android.material.chip.ChipDrawable$Delegate */
    public interface Delegate {
        void onChipDrawableSizeChange();
    }

    public int getOpacity() {
        return -3;
    }

    public static ChipDrawable createFromAttributes(Context context2, AttributeSet attributeSet, int i, int i2) {
        ChipDrawable chipDrawable = new ChipDrawable(context2);
        chipDrawable.loadFromAttributes(attributeSet, i, i2);
        return chipDrawable;
    }

    public static ChipDrawable createFromResource(Context context2, int i) {
        int next;
        try {
            XmlResourceParser xml = context2.getResources().getXml(i);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            } else if (TextUtils.equals(xml.getName(), "chip")) {
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                int styleAttribute = asAttributeSet.getStyleAttribute();
                if (styleAttribute == 0) {
                    styleAttribute = C2622R.style.Widget_MaterialComponents_Chip_Entry;
                }
                return createFromAttributes(context2, asAttributeSet, C2622R.attr.chipStandaloneStyle, styleAttribute);
            } else {
                throw new XmlPullParserException("Must have a <chip> start tag");
            }
        } catch (IOException | XmlPullParserException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't load chip resource ID #0x");
            sb.append(Integer.toHexString(i));
            NotFoundException notFoundException = new NotFoundException(sb.toString());
            notFoundException.initCause(e);
            throw notFoundException;
        }
    }

    private ChipDrawable(Context context2) {
        this.context = context2;
        this.rawText = "";
        this.textPaint.density = context2.getResources().getDisplayMetrics().density;
        this.debugPaint = null;
        Paint paint = this.debugPaint;
        if (paint != null) {
            paint.setStyle(Style.STROKE);
        }
        setState(DEFAULT_STATE);
        setCloseIconState(DEFAULT_STATE);
        this.shouldDrawText = true;
    }

    private void loadFromAttributes(AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(this.context, attributeSet, C2622R.styleable.Chip, i, i2, new int[0]);
        setChipBackgroundColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, C2622R.styleable.Chip_chipBackgroundColor));
        setChipMinHeight(obtainStyledAttributes.getDimension(C2622R.styleable.Chip_chipMinHeight, 0.0f));
        setChipCornerRadius(obtainStyledAttributes.getDimension(C2622R.styleable.Chip_chipCornerRadius, 0.0f));
        setChipStrokeColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, C2622R.styleable.Chip_chipStrokeColor));
        setChipStrokeWidth(obtainStyledAttributes.getDimension(C2622R.styleable.Chip_chipStrokeWidth, 0.0f));
        setRippleColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, C2622R.styleable.Chip_rippleColor));
        setText(obtainStyledAttributes.getText(C2622R.styleable.Chip_android_text));
        setTextAppearance(MaterialResources.getTextAppearance(this.context, obtainStyledAttributes, C2622R.styleable.Chip_android_textAppearance));
        int i3 = obtainStyledAttributes.getInt(C2622R.styleable.Chip_android_ellipsize, 0);
        if (i3 == 1) {
            setEllipsize(TruncateAt.START);
        } else if (i3 == 2) {
            setEllipsize(TruncateAt.MIDDLE);
        } else if (i3 == 3) {
            setEllipsize(TruncateAt.END);
        }
        setChipIconVisible(obtainStyledAttributes.getBoolean(C2622R.styleable.Chip_chipIconVisible, false));
        String str = NAMESPACE_APP;
        if (!(attributeSet == null || attributeSet.getAttributeValue(str, "chipIconEnabled") == null || attributeSet.getAttributeValue(str, "chipIconVisible") != null)) {
            setChipIconVisible(obtainStyledAttributes.getBoolean(C2622R.styleable.Chip_chipIconEnabled, false));
        }
        setChipIcon(MaterialResources.getDrawable(this.context, obtainStyledAttributes, C2622R.styleable.Chip_chipIcon));
        setChipIconTint(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, C2622R.styleable.Chip_chipIconTint));
        setChipIconSize(obtainStyledAttributes.getDimension(C2622R.styleable.Chip_chipIconSize, 0.0f));
        setCloseIconVisible(obtainStyledAttributes.getBoolean(C2622R.styleable.Chip_closeIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue(str, "closeIconEnabled") == null || attributeSet.getAttributeValue(str, "closeIconVisible") != null)) {
            setCloseIconVisible(obtainStyledAttributes.getBoolean(C2622R.styleable.Chip_closeIconEnabled, false));
        }
        setCloseIcon(MaterialResources.getDrawable(this.context, obtainStyledAttributes, C2622R.styleable.Chip_closeIcon));
        setCloseIconTint(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, C2622R.styleable.Chip_closeIconTint));
        setCloseIconSize(obtainStyledAttributes.getDimension(C2622R.styleable.Chip_closeIconSize, 0.0f));
        setCheckable(obtainStyledAttributes.getBoolean(C2622R.styleable.Chip_android_checkable, false));
        setCheckedIconVisible(obtainStyledAttributes.getBoolean(C2622R.styleable.Chip_checkedIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue(str, "checkedIconEnabled") == null || attributeSet.getAttributeValue(str, "checkedIconVisible") != null)) {
            setCheckedIconVisible(obtainStyledAttributes.getBoolean(C2622R.styleable.Chip_checkedIconEnabled, false));
        }
        setCheckedIcon(MaterialResources.getDrawable(this.context, obtainStyledAttributes, C2622R.styleable.Chip_checkedIcon));
        setShowMotionSpec(MotionSpec.createFromAttribute(this.context, obtainStyledAttributes, C2622R.styleable.Chip_showMotionSpec));
        setHideMotionSpec(MotionSpec.createFromAttribute(this.context, obtainStyledAttributes, C2622R.styleable.Chip_hideMotionSpec));
        setChipStartPadding(obtainStyledAttributes.getDimension(C2622R.styleable.Chip_chipStartPadding, 0.0f));
        setIconStartPadding(obtainStyledAttributes.getDimension(C2622R.styleable.Chip_iconStartPadding, 0.0f));
        setIconEndPadding(obtainStyledAttributes.getDimension(C2622R.styleable.Chip_iconEndPadding, 0.0f));
        setTextStartPadding(obtainStyledAttributes.getDimension(C2622R.styleable.Chip_textStartPadding, 0.0f));
        setTextEndPadding(obtainStyledAttributes.getDimension(C2622R.styleable.Chip_textEndPadding, 0.0f));
        setCloseIconStartPadding(obtainStyledAttributes.getDimension(C2622R.styleable.Chip_closeIconStartPadding, 0.0f));
        setCloseIconEndPadding(obtainStyledAttributes.getDimension(C2622R.styleable.Chip_closeIconEndPadding, 0.0f));
        setChipEndPadding(obtainStyledAttributes.getDimension(C2622R.styleable.Chip_chipEndPadding, 0.0f));
        setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(C2622R.styleable.Chip_android_maxWidth, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
        obtainStyledAttributes.recycle();
    }

    public void setUseCompatRipple(boolean z) {
        if (this.useCompatRipple != z) {
            this.useCompatRipple = z;
            updateCompatRippleColor();
            onStateChange(getState());
        }
    }

    public boolean getUseCompatRipple() {
        return this.useCompatRipple;
    }

    public void setDelegate(Delegate delegate2) {
        this.delegate = new WeakReference<>(delegate2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChange() {
        Delegate delegate2 = (Delegate) this.delegate.get();
        if (delegate2 != null) {
            delegate2.onChipDrawableSizeChange();
        }
    }

    public void getChipTouchBounds(RectF rectF2) {
        calculateChipTouchBounds(getBounds(), rectF2);
    }

    public void getCloseIconTouchBounds(RectF rectF2) {
        calculateCloseIconTouchBounds(getBounds(), rectF2);
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding + getTextWidth() + this.textEndPadding + calculateCloseIconWidth() + this.chipEndPadding), this.maxWidth);
    }

    public int getIntrinsicHeight() {
        return (int) this.chipMinHeight;
    }

    private boolean showsChipIcon() {
        return this.chipIconVisible && this.chipIcon != null;
    }

    private boolean showsCheckedIcon() {
        return this.checkedIconVisible && this.checkedIcon != null && this.currentChecked;
    }

    private boolean showsCloseIcon() {
        return this.closeIconVisible && this.closeIcon != null;
    }

    private boolean canShowCheckedIcon() {
        return this.checkedIconVisible && this.checkedIcon != null && this.checkable;
    }

    /* access modifiers changed from: 0000 */
    public float calculateChipIconWidth() {
        if (showsChipIcon() || showsCheckedIcon()) {
            return this.iconStartPadding + this.chipIconSize + this.iconEndPadding;
        }
        return 0.0f;
    }

    private float getTextWidth() {
        if (!this.textWidthDirty) {
            return this.textWidth;
        }
        this.textWidth = calculateTextWidth(this.unicodeWrappedText);
        this.textWidthDirty = false;
        return this.textWidth;
    }

    private float calculateTextWidth(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.textPaint.measureText(charSequence, 0, charSequence.length());
    }

    private float calculateCloseIconWidth() {
        if (showsCloseIcon()) {
            return this.closeIconStartPadding + this.closeIconSize + this.closeIconEndPadding;
        }
        return 0.0f;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int i = 0;
            if (this.alpha < 255) {
                i = CanvasCompat.saveLayerAlpha(canvas, (float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.alpha);
            }
            drawChipBackground(canvas, bounds);
            drawChipStroke(canvas, bounds);
            drawCompatRipple(canvas, bounds);
            drawChipIcon(canvas, bounds);
            drawCheckedIcon(canvas, bounds);
            if (this.shouldDrawText) {
                drawText(canvas, bounds);
            }
            drawCloseIcon(canvas, bounds);
            drawDebug(canvas, bounds);
            if (this.alpha < 255) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void drawChipBackground(Canvas canvas, Rect rect) {
        this.chipPaint.setColor(this.currentChipBackgroundColor);
        this.chipPaint.setStyle(Style.FILL);
        this.chipPaint.setColorFilter(getTintColorFilter());
        this.rectF.set(rect);
        RectF rectF2 = this.rectF;
        float f = this.chipCornerRadius;
        canvas.drawRoundRect(rectF2, f, f, this.chipPaint);
    }

    private void drawChipStroke(Canvas canvas, Rect rect) {
        if (this.chipStrokeWidth > 0.0f) {
            this.chipPaint.setColor(this.currentChipStrokeColor);
            this.chipPaint.setStyle(Style.STROKE);
            this.chipPaint.setColorFilter(getTintColorFilter());
            this.rectF.set(((float) rect.left) + (this.chipStrokeWidth / 2.0f), ((float) rect.top) + (this.chipStrokeWidth / 2.0f), ((float) rect.right) - (this.chipStrokeWidth / 2.0f), ((float) rect.bottom) - (this.chipStrokeWidth / 2.0f));
            float f = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
            canvas.drawRoundRect(this.rectF, f, f, this.chipPaint);
        }
    }

    private void drawCompatRipple(Canvas canvas, Rect rect) {
        this.chipPaint.setColor(this.currentCompatRippleColor);
        this.chipPaint.setStyle(Style.FILL);
        this.rectF.set(rect);
        RectF rectF2 = this.rectF;
        float f = this.chipCornerRadius;
        canvas.drawRoundRect(rectF2, f, f, this.chipPaint);
    }

    private void drawChipIcon(Canvas canvas, Rect rect) {
        if (showsChipIcon()) {
            calculateChipIconBounds(rect, this.rectF);
            float f = this.rectF.left;
            float f2 = this.rectF.top;
            canvas.translate(f, f2);
            this.chipIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            this.chipIcon.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void drawCheckedIcon(Canvas canvas, Rect rect) {
        if (showsCheckedIcon()) {
            calculateChipIconBounds(rect, this.rectF);
            float f = this.rectF.left;
            float f2 = this.rectF.top;
            canvas.translate(f, f2);
            this.checkedIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            this.checkedIcon.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void drawText(Canvas canvas, Rect rect) {
        if (this.unicodeWrappedText != null) {
            Align calculateTextOriginAndAlignment = calculateTextOriginAndAlignment(rect, this.pointF);
            calculateTextBounds(rect, this.rectF);
            if (this.textAppearance != null) {
                this.textPaint.drawableState = getState();
                this.textAppearance.updateDrawState(this.context, this.textPaint, this.fontCallback);
            }
            this.textPaint.setTextAlign(calculateTextOriginAndAlignment);
            int i = 0;
            boolean z = Math.round(getTextWidth()) > Math.round(this.rectF.width());
            if (z) {
                i = canvas.save();
                canvas.clipRect(this.rectF);
            }
            CharSequence charSequence = this.unicodeWrappedText;
            if (z && this.truncateAt != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.textPaint, this.rectF.width(), this.truncateAt);
            }
            CharSequence charSequence2 = charSequence;
            canvas.drawText(charSequence2, 0, charSequence2.length(), this.pointF.x, this.pointF.y, this.textPaint);
            if (z) {
                canvas.restoreToCount(i);
            }
        }
    }

    private void drawCloseIcon(Canvas canvas, Rect rect) {
        if (showsCloseIcon()) {
            calculateCloseIconBounds(rect, this.rectF);
            float f = this.rectF.left;
            float f2 = this.rectF.top;
            canvas.translate(f, f2);
            this.closeIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            this.closeIcon.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void drawDebug(Canvas canvas, Rect rect) {
        Paint paint = this.debugPaint;
        if (paint != null) {
            paint.setColor(ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, 127));
            canvas.drawRect(rect, this.debugPaint);
            if (showsChipIcon() || showsCheckedIcon()) {
                calculateChipIconBounds(rect, this.rectF);
                canvas.drawRect(this.rectF, this.debugPaint);
            }
            if (this.unicodeWrappedText != null) {
                canvas.drawLine((float) rect.left, rect.exactCenterY(), (float) rect.right, rect.exactCenterY(), this.debugPaint);
            }
            if (showsCloseIcon()) {
                calculateCloseIconBounds(rect, this.rectF);
                canvas.drawRect(this.rectF, this.debugPaint);
            }
            this.debugPaint.setColor(ColorUtils.setAlphaComponent(SupportMenu.CATEGORY_MASK, 127));
            calculateChipTouchBounds(rect, this.rectF);
            canvas.drawRect(this.rectF, this.debugPaint);
            this.debugPaint.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
            calculateCloseIconTouchBounds(rect, this.rectF);
            canvas.drawRect(this.rectF, this.debugPaint);
        }
    }

    private void calculateChipIconBounds(Rect rect, RectF rectF2) {
        rectF2.setEmpty();
        if (showsChipIcon() || showsCheckedIcon()) {
            float f = this.chipStartPadding + this.iconStartPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF2.left = ((float) rect.left) + f;
                rectF2.right = rectF2.left + this.chipIconSize;
            } else {
                rectF2.right = ((float) rect.right) - f;
                rectF2.left = rectF2.right - this.chipIconSize;
            }
            rectF2.top = rect.exactCenterY() - (this.chipIconSize / 2.0f);
            rectF2.bottom = rectF2.top + this.chipIconSize;
        }
    }

    /* access modifiers changed from: 0000 */
    public Align calculateTextOriginAndAlignment(Rect rect, PointF pointF2) {
        pointF2.set(0.0f, 0.0f);
        Align align = Align.LEFT;
        if (this.unicodeWrappedText != null) {
            float calculateChipIconWidth = this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                pointF2.x = ((float) rect.left) + calculateChipIconWidth;
                align = Align.LEFT;
            } else {
                pointF2.x = ((float) rect.right) - calculateChipIconWidth;
                align = Align.RIGHT;
            }
            pointF2.y = ((float) rect.centerY()) - calculateTextCenterFromBaseline();
        }
        return align;
    }

    private float calculateTextCenterFromBaseline() {
        this.textPaint.getFontMetrics(this.fontMetrics);
        return (this.fontMetrics.descent + this.fontMetrics.ascent) / 2.0f;
    }

    private void calculateTextBounds(Rect rect, RectF rectF2) {
        rectF2.setEmpty();
        if (this.unicodeWrappedText != null) {
            float calculateChipIconWidth = this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding;
            float calculateCloseIconWidth = this.chipEndPadding + calculateCloseIconWidth() + this.textEndPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF2.left = ((float) rect.left) + calculateChipIconWidth;
                rectF2.right = ((float) rect.right) - calculateCloseIconWidth;
            } else {
                rectF2.left = ((float) rect.left) + calculateCloseIconWidth;
                rectF2.right = ((float) rect.right) - calculateChipIconWidth;
            }
            rectF2.top = (float) rect.top;
            rectF2.bottom = (float) rect.bottom;
        }
    }

    private void calculateCloseIconBounds(Rect rect, RectF rectF2) {
        rectF2.setEmpty();
        if (showsCloseIcon()) {
            float f = this.chipEndPadding + this.closeIconEndPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF2.right = ((float) rect.right) - f;
                rectF2.left = rectF2.right - this.closeIconSize;
            } else {
                rectF2.left = ((float) rect.left) + f;
                rectF2.right = rectF2.left + this.closeIconSize;
            }
            rectF2.top = rect.exactCenterY() - (this.closeIconSize / 2.0f);
            rectF2.bottom = rectF2.top + this.closeIconSize;
        }
    }

    private void calculateChipTouchBounds(Rect rect, RectF rectF2) {
        rectF2.set(rect);
        if (showsCloseIcon()) {
            float f = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF2.right = ((float) rect.right) - f;
            } else {
                rectF2.left = ((float) rect.left) + f;
            }
        }
    }

    private void calculateCloseIconTouchBounds(Rect rect, RectF rectF2) {
        rectF2.setEmpty();
        if (showsCloseIcon()) {
            float f = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF2.right = (float) rect.right;
                rectF2.left = rectF2.right - f;
            } else {
                rectF2.left = (float) rect.left;
                rectF2.right = ((float) rect.left) + f;
            }
            rectF2.top = (float) rect.top;
            rectF2.bottom = (float) rect.bottom;
        }
    }

    public boolean isStateful() {
        return isStateful(this.chipBackgroundColor) || isStateful(this.chipStrokeColor) || (this.useCompatRipple && isStateful(this.compatRippleColor)) || isStateful(this.textAppearance) || canShowCheckedIcon() || isStateful(this.chipIcon) || isStateful(this.checkedIcon) || isStateful(this.tint);
    }

    public boolean isCloseIconStateful() {
        return isStateful(this.closeIcon);
    }

    public boolean setCloseIconState(int[] iArr) {
        if (!Arrays.equals(this.closeIconStateSet, iArr)) {
            this.closeIconStateSet = iArr;
            if (showsCloseIcon()) {
                return onStateChange(getState(), iArr);
            }
        }
        return false;
    }

    public int[] getCloseIconState() {
        return this.closeIconStateSet;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        return onStateChange(iArr, getCloseIconState());
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00dc  */
    private boolean onStateChange(int[] r6, int[] r7) {
        /*
        r5 = this;
        boolean r0 = super.onStateChange(r6)
        android.content.res.ColorStateList r1 = r5.chipBackgroundColor
        r2 = 0
        if (r1 == 0) goto L_0x0010
        int r3 = r5.currentChipBackgroundColor
        int r1 = r1.getColorForState(r6, r3)
        goto L_0x0011
    L_0x0010:
        r1 = 0
    L_0x0011:
        int r3 = r5.currentChipBackgroundColor
        r4 = 1
        if (r3 == r1) goto L_0x0019
        r5.currentChipBackgroundColor = r1
        r0 = 1
    L_0x0019:
        android.content.res.ColorStateList r1 = r5.chipStrokeColor
        if (r1 == 0) goto L_0x0024
        int r3 = r5.currentChipStrokeColor
        int r1 = r1.getColorForState(r6, r3)
        goto L_0x0025
    L_0x0024:
        r1 = 0
    L_0x0025:
        int r3 = r5.currentChipStrokeColor
        if (r3 == r1) goto L_0x002c
        r5.currentChipStrokeColor = r1
        r0 = 1
    L_0x002c:
        android.content.res.ColorStateList r1 = r5.compatRippleColor
        if (r1 == 0) goto L_0x0037
        int r3 = r5.currentCompatRippleColor
        int r1 = r1.getColorForState(r6, r3)
        goto L_0x0038
    L_0x0037:
        r1 = 0
    L_0x0038:
        int r3 = r5.currentCompatRippleColor
        if (r3 == r1) goto L_0x0043
        r5.currentCompatRippleColor = r1
        boolean r1 = r5.useCompatRipple
        if (r1 == 0) goto L_0x0043
        r0 = 1
    L_0x0043:
        com.google.android.material.resources.TextAppearance r1 = r5.textAppearance
        if (r1 == 0) goto L_0x0056
        android.content.res.ColorStateList r1 = r1.textColor
        if (r1 == 0) goto L_0x0056
        com.google.android.material.resources.TextAppearance r1 = r5.textAppearance
        android.content.res.ColorStateList r1 = r1.textColor
        int r3 = r5.currentTextColor
        int r1 = r1.getColorForState(r6, r3)
        goto L_0x0057
    L_0x0056:
        r1 = 0
    L_0x0057:
        int r3 = r5.currentTextColor
        if (r3 == r1) goto L_0x005e
        r5.currentTextColor = r1
        r0 = 1
    L_0x005e:
        int[] r1 = r5.getState()
        r3 = 16842912(0x10100a0, float:2.3694006E-38)
        boolean r1 = hasState(r1, r3)
        if (r1 == 0) goto L_0x0071
        boolean r1 = r5.checkable
        if (r1 == 0) goto L_0x0071
        r1 = 1
        goto L_0x0072
    L_0x0071:
        r1 = 0
    L_0x0072:
        boolean r3 = r5.currentChecked
        if (r3 == r1) goto L_0x008c
        android.graphics.drawable.Drawable r3 = r5.checkedIcon
        if (r3 == 0) goto L_0x008c
        float r0 = r5.calculateChipIconWidth()
        r5.currentChecked = r1
        float r1 = r5.calculateChipIconWidth()
        int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
        if (r0 == 0) goto L_0x008b
        r0 = 1
        r1 = 1
        goto L_0x008d
    L_0x008b:
        r0 = 1
    L_0x008c:
        r1 = 0
    L_0x008d:
        android.content.res.ColorStateList r3 = r5.tint
        if (r3 == 0) goto L_0x0097
        int r2 = r5.currentTint
        int r2 = r3.getColorForState(r6, r2)
    L_0x0097:
        int r3 = r5.currentTint
        if (r3 == r2) goto L_0x00a8
        r5.currentTint = r2
        android.content.res.ColorStateList r0 = r5.tint
        android.graphics.PorterDuff$Mode r2 = r5.tintMode
        android.graphics.PorterDuffColorFilter r0 = com.google.android.material.drawable.DrawableUtils.updateTintFilter(r5, r0, r2)
        r5.tintFilter = r0
        r0 = 1
    L_0x00a8:
        android.graphics.drawable.Drawable r2 = r5.chipIcon
        boolean r2 = isStateful(r2)
        if (r2 == 0) goto L_0x00b7
        android.graphics.drawable.Drawable r2 = r5.chipIcon
        boolean r2 = r2.setState(r6)
        r0 = r0 | r2
    L_0x00b7:
        android.graphics.drawable.Drawable r2 = r5.checkedIcon
        boolean r2 = isStateful(r2)
        if (r2 == 0) goto L_0x00c6
        android.graphics.drawable.Drawable r2 = r5.checkedIcon
        boolean r6 = r2.setState(r6)
        r0 = r0 | r6
    L_0x00c6:
        android.graphics.drawable.Drawable r6 = r5.closeIcon
        boolean r6 = isStateful(r6)
        if (r6 == 0) goto L_0x00d5
        android.graphics.drawable.Drawable r6 = r5.closeIcon
        boolean r6 = r6.setState(r7)
        r0 = r0 | r6
    L_0x00d5:
        if (r0 == 0) goto L_0x00da
        r5.invalidateSelf()
    L_0x00da:
        if (r1 == 0) goto L_0x00df
        r5.onSizeChange()
    L_0x00df:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipDrawable.onStateChange(int[], int[]):boolean");
    }

    private static boolean isStateful(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private static boolean isStateful(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean isStateful(TextAppearance textAppearance2) {
        return (textAppearance2 == null || textAppearance2.textColor == null || !textAppearance2.textColor.isStateful()) ? false : true;
    }

    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (showsChipIcon()) {
            onLayoutDirectionChanged |= this.chipIcon.setLayoutDirection(i);
        }
        if (showsCheckedIcon()) {
            onLayoutDirectionChanged |= this.checkedIcon.setLayoutDirection(i);
        }
        if (showsCloseIcon()) {
            onLayoutDirectionChanged |= this.closeIcon.setLayoutDirection(i);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (showsChipIcon()) {
            onLevelChange |= this.chipIcon.setLevel(i);
        }
        if (showsCheckedIcon()) {
            onLevelChange |= this.checkedIcon.setLevel(i);
        }
        if (showsCloseIcon()) {
            onLevelChange |= this.closeIcon.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (showsChipIcon()) {
            visible |= this.chipIcon.setVisible(z, z2);
        }
        if (showsCheckedIcon()) {
            visible |= this.checkedIcon.setVisible(z, z2);
        }
        if (showsCloseIcon()) {
            visible |= this.closeIcon.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void setAlpha(int i) {
        if (this.alpha != i) {
            this.alpha = i;
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setColorFilter(ColorFilter colorFilter2) {
        if (this.colorFilter != colorFilter2) {
            this.colorFilter = colorFilter2;
            invalidateSelf();
        }
    }

    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.tint != colorStateList) {
            this.tint = colorStateList;
            onStateChange(getState());
        }
    }

    public void setTintMode(Mode mode) {
        if (this.tintMode != mode) {
            this.tintMode = mode;
            this.tintFilter = DrawableUtils.updateTintFilter(this, this.tint, mode);
            invalidateSelf();
        }
    }

    public void getOutline(Outline outline) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.chipCornerRadius);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.chipCornerRadius);
        }
        outline.setAlpha(((float) getAlpha()) / 255.0f);
    }

    public void invalidateDrawable(Drawable drawable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    private void unapplyChildDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void applyChildDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.closeIcon) {
                if (drawable.isStateful()) {
                    drawable.setState(getCloseIconState());
                }
                DrawableCompat.setTintList(drawable, this.closeIconTint);
            } else if (drawable.isStateful()) {
                drawable.setState(getState());
            }
        }
    }

    private ColorFilter getTintColorFilter() {
        ColorFilter colorFilter2 = this.colorFilter;
        return colorFilter2 != null ? colorFilter2 : this.tintFilter;
    }

    private void updateCompatRippleColor() {
        this.compatRippleColor = this.useCompatRipple ? RippleUtils.convertToRippleDrawableColor(this.rippleColor) : null;
    }

    private static boolean hasState(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public ColorStateList getChipBackgroundColor() {
        return this.chipBackgroundColor;
    }

    public void setChipBackgroundColorResource(int i) {
        setChipBackgroundColor(AppCompatResources.getColorStateList(this.context, i));
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        if (this.chipBackgroundColor != colorStateList) {
            this.chipBackgroundColor = colorStateList;
            onStateChange(getState());
        }
    }

    public float getChipMinHeight() {
        return this.chipMinHeight;
    }

    public void setChipMinHeightResource(int i) {
        setChipMinHeight(this.context.getResources().getDimension(i));
    }

    public void setChipMinHeight(float f) {
        if (this.chipMinHeight != f) {
            this.chipMinHeight = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public float getChipCornerRadius() {
        return this.chipCornerRadius;
    }

    public void setChipCornerRadiusResource(int i) {
        setChipCornerRadius(this.context.getResources().getDimension(i));
    }

    public void setChipCornerRadius(float f) {
        if (this.chipCornerRadius != f) {
            this.chipCornerRadius = f;
            invalidateSelf();
        }
    }

    public ColorStateList getChipStrokeColor() {
        return this.chipStrokeColor;
    }

    public void setChipStrokeColorResource(int i) {
        setChipStrokeColor(AppCompatResources.getColorStateList(this.context, i));
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        if (this.chipStrokeColor != colorStateList) {
            this.chipStrokeColor = colorStateList;
            onStateChange(getState());
        }
    }

    public float getChipStrokeWidth() {
        return this.chipStrokeWidth;
    }

    public void setChipStrokeWidthResource(int i) {
        setChipStrokeWidth(this.context.getResources().getDimension(i));
    }

    public void setChipStrokeWidth(float f) {
        if (this.chipStrokeWidth != f) {
            this.chipStrokeWidth = f;
            this.chipPaint.setStrokeWidth(f);
            invalidateSelf();
        }
    }

    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    public void setRippleColorResource(int i) {
        setRippleColor(AppCompatResources.getColorStateList(this.context, i));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            updateCompatRippleColor();
            onStateChange(getState());
        }
    }

    public CharSequence getText() {
        return this.rawText;
    }

    public void setTextResource(int i) {
        setText(this.context.getResources().getString(i));
    }

    public void setText(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (this.rawText != charSequence) {
            this.rawText = charSequence;
            this.unicodeWrappedText = BidiFormatter.getInstance().unicodeWrap(charSequence);
            this.textWidthDirty = true;
            invalidateSelf();
            onSizeChange();
        }
    }

    public TextAppearance getTextAppearance() {
        return this.textAppearance;
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(new TextAppearance(this.context, i));
    }

    public void setTextAppearance(TextAppearance textAppearance2) {
        if (this.textAppearance != textAppearance2) {
            this.textAppearance = textAppearance2;
            if (textAppearance2 != null) {
                textAppearance2.updateMeasureState(this.context, this.textPaint, this.fontCallback);
                this.textWidthDirty = true;
            }
            onStateChange(getState());
            onSizeChange();
        }
    }

    public TruncateAt getEllipsize() {
        return this.truncateAt;
    }

    public void setEllipsize(TruncateAt truncateAt2) {
        this.truncateAt = truncateAt2;
    }

    public boolean isChipIconVisible() {
        return this.chipIconVisible;
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public void setChipIconVisible(int i) {
        setChipIconVisible(this.context.getResources().getBoolean(i));
    }

    public void setChipIconVisible(boolean z) {
        if (this.chipIconVisible != z) {
            boolean showsChipIcon = showsChipIcon();
            this.chipIconVisible = z;
            boolean showsChipIcon2 = showsChipIcon();
            if (showsChipIcon != showsChipIcon2) {
                if (showsChipIcon2) {
                    applyChildDrawable(this.chipIcon);
                } else {
                    unapplyChildDrawable(this.chipIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    public Drawable getChipIcon() {
        Drawable drawable = this.chipIcon;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public void setChipIconResource(int i) {
        setChipIcon(AppCompatResources.getDrawable(this.context, i));
    }

    public void setChipIcon(Drawable drawable) {
        Drawable chipIcon2 = getChipIcon();
        if (chipIcon2 != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.chipIcon = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(chipIcon2);
            if (showsChipIcon()) {
                applyChildDrawable(this.chipIcon);
            }
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public ColorStateList getChipIconTint() {
        return this.chipIconTint;
    }

    public void setChipIconTintResource(int i) {
        setChipIconTint(AppCompatResources.getColorStateList(this.context, i));
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        if (this.chipIconTint != colorStateList) {
            this.chipIconTint = colorStateList;
            if (showsChipIcon()) {
                DrawableCompat.setTintList(this.chipIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float getChipIconSize() {
        return this.chipIconSize;
    }

    public void setChipIconSizeResource(int i) {
        setChipIconSize(this.context.getResources().getDimension(i));
    }

    public void setChipIconSize(float f) {
        if (this.chipIconSize != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.chipIconSize = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public boolean isCloseIconVisible() {
        return this.closeIconVisible;
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(this.context.getResources().getBoolean(i));
    }

    public void setCloseIconVisible(boolean z) {
        if (this.closeIconVisible != z) {
            boolean showsCloseIcon = showsCloseIcon();
            this.closeIconVisible = z;
            boolean showsCloseIcon2 = showsCloseIcon();
            if (showsCloseIcon != showsCloseIcon2) {
                if (showsCloseIcon2) {
                    applyChildDrawable(this.closeIcon);
                } else {
                    unapplyChildDrawable(this.closeIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    public Drawable getCloseIcon() {
        Drawable drawable = this.closeIcon;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public void setCloseIconResource(int i) {
        setCloseIcon(AppCompatResources.getDrawable(this.context, i));
    }

    public void setCloseIcon(Drawable drawable) {
        Drawable closeIcon2 = getCloseIcon();
        if (closeIcon2 != drawable) {
            float calculateCloseIconWidth = calculateCloseIconWidth();
            this.closeIcon = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            float calculateCloseIconWidth2 = calculateCloseIconWidth();
            unapplyChildDrawable(closeIcon2);
            if (showsCloseIcon()) {
                applyChildDrawable(this.closeIcon);
            }
            invalidateSelf();
            if (calculateCloseIconWidth != calculateCloseIconWidth2) {
                onSizeChange();
            }
        }
    }

    public ColorStateList getCloseIconTint() {
        return this.closeIconTint;
    }

    public void setCloseIconTintResource(int i) {
        setCloseIconTint(AppCompatResources.getColorStateList(this.context, i));
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        if (this.closeIconTint != colorStateList) {
            this.closeIconTint = colorStateList;
            if (showsCloseIcon()) {
                DrawableCompat.setTintList(this.closeIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float getCloseIconSize() {
        return this.closeIconSize;
    }

    public void setCloseIconSizeResource(int i) {
        setCloseIconSize(this.context.getResources().getDimension(i));
    }

    public void setCloseIconSize(float f) {
        if (this.closeIconSize != f) {
            this.closeIconSize = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        if (this.closeIconContentDescription != charSequence) {
            this.closeIconContentDescription = BidiFormatter.getInstance().unicodeWrap(charSequence);
            invalidateSelf();
        }
    }

    public CharSequence getCloseIconContentDescription() {
        return this.closeIconContentDescription;
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    public void setCheckableResource(int i) {
        setCheckable(this.context.getResources().getBoolean(i));
    }

    public void setCheckable(boolean z) {
        if (this.checkable != z) {
            this.checkable = z;
            float calculateChipIconWidth = calculateChipIconWidth();
            if (!z && this.currentChecked) {
                this.currentChecked = false;
            }
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public boolean isCheckedIconVisible() {
        return this.checkedIconVisible;
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public void setCheckedIconVisible(int i) {
        setCheckedIconVisible(this.context.getResources().getBoolean(i));
    }

    public void setCheckedIconVisible(boolean z) {
        if (this.checkedIconVisible != z) {
            boolean showsCheckedIcon = showsCheckedIcon();
            this.checkedIconVisible = z;
            boolean showsCheckedIcon2 = showsCheckedIcon();
            if (showsCheckedIcon != showsCheckedIcon2) {
                if (showsCheckedIcon2) {
                    applyChildDrawable(this.checkedIcon);
                } else {
                    unapplyChildDrawable(this.checkedIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(this.context.getResources().getBoolean(i));
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    public Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    public void setCheckedIconResource(int i) {
        setCheckedIcon(AppCompatResources.getDrawable(this.context, i));
    }

    public void setCheckedIcon(Drawable drawable) {
        if (this.checkedIcon != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.checkedIcon = drawable;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(this.checkedIcon);
            applyChildDrawable(this.checkedIcon);
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(MotionSpec.createFromResource(this.context, i));
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        this.showMotionSpec = motionSpec;
    }

    public MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(MotionSpec.createFromResource(this.context, i));
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        this.hideMotionSpec = motionSpec;
    }

    public float getChipStartPadding() {
        return this.chipStartPadding;
    }

    public void setChipStartPaddingResource(int i) {
        setChipStartPadding(this.context.getResources().getDimension(i));
    }

    public void setChipStartPadding(float f) {
        if (this.chipStartPadding != f) {
            this.chipStartPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public float getIconStartPadding() {
        return this.iconStartPadding;
    }

    public void setIconStartPaddingResource(int i) {
        setIconStartPadding(this.context.getResources().getDimension(i));
    }

    public void setIconStartPadding(float f) {
        if (this.iconStartPadding != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconStartPadding = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public float getIconEndPadding() {
        return this.iconEndPadding;
    }

    public void setIconEndPaddingResource(int i) {
        setIconEndPadding(this.context.getResources().getDimension(i));
    }

    public void setIconEndPadding(float f) {
        if (this.iconEndPadding != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconEndPadding = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public float getTextStartPadding() {
        return this.textStartPadding;
    }

    public void setTextStartPaddingResource(int i) {
        setTextStartPadding(this.context.getResources().getDimension(i));
    }

    public void setTextStartPadding(float f) {
        if (this.textStartPadding != f) {
            this.textStartPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public float getTextEndPadding() {
        return this.textEndPadding;
    }

    public void setTextEndPaddingResource(int i) {
        setTextEndPadding(this.context.getResources().getDimension(i));
    }

    public void setTextEndPadding(float f) {
        if (this.textEndPadding != f) {
            this.textEndPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public float getCloseIconStartPadding() {
        return this.closeIconStartPadding;
    }

    public void setCloseIconStartPaddingResource(int i) {
        setCloseIconStartPadding(this.context.getResources().getDimension(i));
    }

    public void setCloseIconStartPadding(float f) {
        if (this.closeIconStartPadding != f) {
            this.closeIconStartPadding = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public float getCloseIconEndPadding() {
        return this.closeIconEndPadding;
    }

    public void setCloseIconEndPaddingResource(int i) {
        setCloseIconEndPadding(this.context.getResources().getDimension(i));
    }

    public void setCloseIconEndPadding(float f) {
        if (this.closeIconEndPadding != f) {
            this.closeIconEndPadding = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public float getChipEndPadding() {
        return this.chipEndPadding;
    }

    public void setChipEndPaddingResource(int i) {
        setChipEndPadding(this.context.getResources().getDimension(i));
    }

    public void setChipEndPadding(float f) {
        if (this.chipEndPadding != f) {
            this.chipEndPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public void setMaxWidth(int i) {
        this.maxWidth = i;
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldDrawText() {
        return this.shouldDrawText;
    }

    /* access modifiers changed from: 0000 */
    public void setShouldDrawText(boolean z) {
        this.shouldDrawText = z;
    }
}
