package p681me.jessyan.autosize.unit;

import p681me.jessyan.autosize.utils.Preconditions;

/* renamed from: me.jessyan.autosize.unit.UnitsManager */
public class UnitsManager {
    private boolean isSupportDP = true;
    private boolean isSupportSP = true;
    private boolean isSupportScreenSizeDP = false;
    private float mDesignHeight;
    private float mDesignWidth;
    private Subunits mSupportSubunits = Subunits.NONE;

    public UnitsManager setDesignSize(float f, float f2) {
        setDesignWidth(f);
        setDesignHeight(f2);
        return this;
    }

    public float getDesignWidth() {
        return this.mDesignWidth;
    }

    public UnitsManager setDesignWidth(float f) {
        Preconditions.checkArgument(f > 0.0f, "designWidth must be > 0");
        this.mDesignWidth = f;
        return this;
    }

    public float getDesignHeight() {
        return this.mDesignHeight;
    }

    public UnitsManager setDesignHeight(float f) {
        Preconditions.checkArgument(f > 0.0f, "designHeight must be > 0");
        this.mDesignHeight = f;
        return this;
    }

    public boolean isSupportDP() {
        return this.isSupportDP;
    }

    public UnitsManager setSupportDP(boolean z) {
        this.isSupportDP = z;
        return this;
    }

    public boolean isSupportSP() {
        return this.isSupportSP;
    }

    public UnitsManager setSupportSP(boolean z) {
        this.isSupportSP = z;
        return this;
    }

    public Subunits getSupportSubunits() {
        return this.mSupportSubunits;
    }

    public boolean isSupportScreenSizeDP() {
        return this.isSupportScreenSizeDP;
    }

    public UnitsManager setSupportScreenSizeDP(boolean z) {
        this.isSupportScreenSizeDP = z;
        return this;
    }

    public UnitsManager setSupportSubunits(Subunits subunits) {
        this.mSupportSubunits = (Subunits) Preconditions.checkNotNull(subunits, "The supportSubunits can not be null, use Subunits.NONE instead");
        return this;
    }
}
