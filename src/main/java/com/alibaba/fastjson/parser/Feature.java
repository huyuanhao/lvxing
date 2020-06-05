package com.alibaba.fastjson.parser;

public enum Feature {
    AutoCloseSource,
    AllowComment,
    AllowUnQuotedFieldNames,
    AllowSingleQuotes,
    InternFieldNames,
    AllowISO8601DateFormat,
    AllowArbitraryCommas,
    UseBigDecimal,
    IgnoreNotMatch,
    SortFeidFastMatch,
    DisableASM,
    DisableCircularReferenceDetect,
    InitStringFieldAsEmpty,
    SupportArrayToBean,
    OrderedField,
    DisableSpecialKeyDetect,
    UseObjectArray,
    SupportNonPublicField,
    IgnoreAutoType,
    DisableFieldSmartMatch,
    SupportAutoType;
    
    public final int mask;

    public final int getMask() {
        return this.mask;
    }

    public static boolean isEnabled(int i, Feature feature) {
        return (i & feature.mask) != 0;
    }

    public static int config(int i, Feature feature, boolean z) {
        if (z) {
            return i | feature.mask;
        }
        return i & (~feature.mask);
    }

    /* renamed from: of */
    public static int m2571of(Feature[] featureArr) {
        if (featureArr == null) {
            return 0;
        }
        int i = 0;
        for (Feature feature : featureArr) {
            i |= feature.mask;
        }
        return i;
    }
}
