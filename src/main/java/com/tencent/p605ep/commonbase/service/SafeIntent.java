package com.tencent.p605ep.commonbase.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;

/* renamed from: com.tencent.ep.commonbase.service.SafeIntent */
public class SafeIntent extends Intent {
    public SafeIntent(Intent intent) {
        super(intent);
    }

    public boolean[] getBooleanArrayExtra(String str) {
        try {
            return super.getBooleanArrayExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean getBooleanExtra(String str, boolean z) {
        try {
            z = super.getBooleanExtra(str, z);
            return z;
        } catch (Throwable unused) {
            return z;
        }
    }

    public Bundle getBundleExtra(String str) {
        try {
            return super.getBundleExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public byte[] getByteArrayExtra(String str) {
        try {
            return super.getByteArrayExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public byte getByteExtra(String str, byte b) {
        try {
            b = super.getByteExtra(str, b);
            return b;
        } catch (Throwable unused) {
            return b;
        }
    }

    public char[] getCharArrayExtra(String str) {
        try {
            return super.getCharArrayExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public char getCharExtra(String str, char c) {
        try {
            c = super.getCharExtra(str, c);
            return c;
        } catch (Throwable unused) {
            return c;
        }
    }

    public CharSequence getCharSequenceExtra(String str) {
        try {
            return super.getCharSequenceExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public double[] getDoubleArrayExtra(String str) {
        try {
            return super.getDoubleArrayExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public double getDoubleExtra(String str, double d) {
        try {
            d = super.getDoubleExtra(str, d);
            return d;
        } catch (Throwable unused) {
            return d;
        }
    }

    public float[] getFloatArrayExtra(String str) {
        try {
            return super.getFloatArrayExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public float getFloatExtra(String str, float f) {
        try {
            f = super.getFloatExtra(str, f);
            return f;
        } catch (Throwable unused) {
            return f;
        }
    }

    public int[] getIntArrayExtra(String str) {
        try {
            return super.getIntArrayExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getIntExtra(String str, int i) {
        try {
            i = super.getIntExtra(str, i);
            return i;
        } catch (Throwable unused) {
            return i;
        }
    }

    public ArrayList<Integer> getIntegerArrayListExtra(String str) {
        try {
            return super.getIntegerArrayListExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public long[] getLongArrayExtra(String str) {
        try {
            return super.getLongArrayExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public long getLongExtra(String str, long j) {
        try {
            j = super.getLongExtra(str, j);
            return j;
        } catch (Throwable unused) {
            return j;
        }
    }

    public Parcelable[] getParcelableArrayExtra(String str) {
        try {
            return super.getParcelableArrayExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String str) {
        try {
            return super.getParcelableArrayListExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public <T extends Parcelable> T getParcelableExtra(String str) {
        try {
            return super.getParcelableExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public Serializable getSerializableExtra(String str) {
        try {
            return super.getSerializableExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public short[] getShortArrayExtra(String str) {
        try {
            return super.getShortArrayExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public short getShortExtra(String str, short s) {
        try {
            s = super.getShortExtra(str, s);
            return s;
        } catch (Throwable unused) {
            return s;
        }
    }

    public String[] getStringArrayExtra(String str) {
        try {
            return super.getStringArrayExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public ArrayList<String> getStringArrayListExtra(String str) {
        try {
            return super.getStringArrayListExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getStringExtra(String str) {
        try {
            return super.getStringExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public Intent putExtra(String str, byte b) {
        try {
            return super.putExtra(str, b);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, char c) {
        try {
            return super.putExtra(str, c);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, double d) {
        try {
            return super.putExtra(str, d);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, float f) {
        try {
            return super.putExtra(str, f);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, int i) {
        try {
            return super.putExtra(str, i);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, long j) {
        try {
            return super.putExtra(str, j);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, Bundle bundle) {
        try {
            return super.putExtra(str, bundle);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, Parcelable parcelable) {
        try {
            return super.putExtra(str, parcelable);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, Serializable serializable) {
        try {
            return super.putExtra(str, serializable);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, CharSequence charSequence) {
        try {
            return super.putExtra(str, charSequence);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, String str2) {
        try {
            return super.putExtra(str, str2);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, short s) {
        try {
            return super.putExtra(str, s);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, boolean z) {
        try {
            return super.putExtra(str, z);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, byte[] bArr) {
        try {
            return super.putExtra(str, bArr);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, char[] cArr) {
        try {
            return super.putExtra(str, cArr);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, double[] dArr) {
        try {
            return super.putExtra(str, dArr);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, float[] fArr) {
        try {
            return super.putExtra(str, fArr);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, int[] iArr) {
        try {
            return super.putExtra(str, iArr);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, long[] jArr) {
        try {
            return super.putExtra(str, jArr);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, Parcelable[] parcelableArr) {
        try {
            return super.putExtra(str, parcelableArr);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, String[] strArr) {
        try {
            return super.putExtra(str, strArr);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, short[] sArr) {
        try {
            return super.putExtra(str, sArr);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtra(String str, boolean[] zArr) {
        try {
            return super.putExtra(str, zArr);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putExtras(Bundle bundle) {
        try {
            return super.putExtras(bundle);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putIntegerArrayListExtra(String str, ArrayList<Integer> arrayList) {
        try {
            return super.putIntegerArrayListExtra(str, arrayList);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putParcelableArrayListExtra(String str, ArrayList<? extends Parcelable> arrayList) {
        try {
            return super.putParcelableArrayListExtra(str, arrayList);
        } catch (Throwable unused) {
            return this;
        }
    }

    public Intent putStringArrayListExtra(String str, ArrayList<String> arrayList) {
        try {
            return super.putStringArrayListExtra(str, arrayList);
        } catch (Throwable unused) {
            return this;
        }
    }
}
