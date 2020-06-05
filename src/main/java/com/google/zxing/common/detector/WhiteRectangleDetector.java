package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class WhiteRectangleDetector {
    private static final int CORR = 1;
    private static final int INIT_SIZE = 10;
    private final int downInit;
    private final int height;
    private final BitMatrix image;
    private final int leftInit;
    private final int rightInit;
    private final int upInit;
    private final int width;

    public WhiteRectangleDetector(BitMatrix bitMatrix) throws NotFoundException {
        this(bitMatrix, 10, bitMatrix.getWidth() / 2, bitMatrix.getHeight() / 2);
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i, int i2, int i3) throws NotFoundException {
        this.image = bitMatrix;
        this.height = bitMatrix.getHeight();
        this.width = bitMatrix.getWidth();
        int i4 = i / 2;
        this.leftInit = i2 - i4;
        this.rightInit = i2 + i4;
        this.upInit = i3 - i4;
        this.downInit = i3 + i4;
        if (this.upInit < 0 || this.leftInit < 0 || this.downInit >= this.height || this.rightInit >= this.width) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public ResultPoint[] detect() throws NotFoundException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = this.leftInit;
        int i6 = this.rightInit;
        int i7 = this.upInit;
        int i8 = this.downInit;
        boolean z = false;
        int i9 = 1;
        int i10 = i5;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (true) {
            if (!z2) {
                break;
            }
            boolean z8 = true;
            boolean z9 = false;
            while (true) {
                if ((z8 || !z3) && i6 < this.width) {
                    z8 = containsBlackPoint(i3, i2, i6, false);
                    if (z8) {
                        i6++;
                        z3 = true;
                        z9 = true;
                    } else if (!z3) {
                        i6++;
                    }
                }
            }
            if (i6 >= this.width) {
                break;
            }
            boolean z10 = true;
            while (true) {
                if ((z10 || !z4) && i2 < this.height) {
                    z10 = containsBlackPoint(i, i6, i2, true);
                    if (z10) {
                        i2++;
                        z4 = true;
                        z9 = true;
                    } else if (!z4) {
                        i2++;
                    }
                }
            }
            if (i2 >= this.height) {
                break;
            }
            boolean z11 = true;
            while (true) {
                if ((z11 || !z5) && i >= 0) {
                    z11 = containsBlackPoint(i3, i2, i, false);
                    if (z11) {
                        i--;
                        z5 = true;
                        z9 = true;
                    } else if (!z5) {
                        i--;
                    }
                }
            }
            if (i < 0) {
                break;
            }
            boolean z12 = true;
            while (true) {
                if ((z12 || !z7) && i3 >= 0) {
                    z12 = containsBlackPoint(i, i6, i3, true);
                    if (z12) {
                        i3--;
                        z7 = true;
                        z9 = true;
                    } else if (!z7) {
                        i3--;
                    }
                }
            }
            if (i3 < 0) {
                break;
            }
            if (z9) {
                z6 = true;
            }
            z2 = z9;
        }
        z = true;
        if (z || !z6) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i11 = i4 - i;
        ResultPoint resultPoint = null;
        ResultPoint resultPoint2 = null;
        int i12 = 1;
        while (resultPoint2 == null && i12 < i11) {
            resultPoint2 = getBlackPointOnSegment((float) i, (float) (i2 - i12), (float) (i + i12), (float) i2);
            i12++;
        }
        if (resultPoint2 != null) {
            ResultPoint resultPoint3 = null;
            int i13 = 1;
            while (resultPoint3 == null && i13 < i11) {
                resultPoint3 = getBlackPointOnSegment((float) i, (float) (i3 + i13), (float) (i + i13), (float) i3);
                i13++;
            }
            if (resultPoint3 != null) {
                ResultPoint resultPoint4 = null;
                int i14 = 1;
                while (resultPoint4 == null && i14 < i11) {
                    resultPoint4 = getBlackPointOnSegment((float) i4, (float) (i3 + i14), (float) (i4 - i14), (float) i3);
                    i14++;
                }
                if (resultPoint4 != null) {
                    while (resultPoint == null && i9 < i11) {
                        resultPoint = getBlackPointOnSegment((float) i4, (float) (i2 - i9), (float) (i4 - i9), (float) i2);
                        i9++;
                    }
                    if (resultPoint != null) {
                        return centerEdges(resultPoint, resultPoint2, resultPoint4, resultPoint3);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private ResultPoint getBlackPointOnSegment(float f, float f2, float f3, float f4) {
        int round = MathUtils.round(MathUtils.distance(f, f2, f3, f4));
        float f5 = (float) round;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i = 0; i < round; i++) {
            float f8 = (float) i;
            int round2 = MathUtils.round((f8 * f6) + f);
            int round3 = MathUtils.round((f8 * f7) + f2);
            if (this.image.get(round2, round3)) {
                return new ResultPoint((float) round2, (float) round3);
            }
        }
        return null;
    }

    private ResultPoint[] centerEdges(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        float x2 = resultPoint2.getX();
        float y2 = resultPoint2.getY();
        float x3 = resultPoint3.getX();
        float y3 = resultPoint3.getY();
        float x4 = resultPoint4.getX();
        float y4 = resultPoint4.getY();
        if (x < ((float) this.width) / 2.0f) {
            return new ResultPoint[]{new ResultPoint(x4 - 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 + 1.0f), new ResultPoint(x3 - 1.0f, y3 - 1.0f), new ResultPoint(x + 1.0f, y - 1.0f)};
        }
        return new ResultPoint[]{new ResultPoint(x4 + 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 - 1.0f), new ResultPoint(x3 - 1.0f, y3 + 1.0f), new ResultPoint(x - 1.0f, y - 1.0f)};
    }

    private boolean containsBlackPoint(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.image.get(i, i3)) {
                    return true;
                }
                i++;
            }
        } else {
            while (i <= i2) {
                if (this.image.get(i3, i)) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}
