package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;
import com.tencent.qqpim.discovery.internal.protocol.C7516p;

final class AI01320xDecoder extends AI013x0xDecoder {
    /* access modifiers changed from: protected */
    public int checkWeight(int i) {
        return i < 10000 ? i : i - C7516p.f25219Cf;
    }

    AI01320xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    /* access modifiers changed from: protected */
    public void addWeightCode(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }
}
