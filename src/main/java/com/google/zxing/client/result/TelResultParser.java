package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class TelResultParser extends ResultParser {
    public TelParsedResult parse(Result result) {
        String str;
        String massagedText = getMassagedText(result);
        String str2 = "tel:";
        String str3 = "TEL:";
        if (!massagedText.startsWith(str2) && !massagedText.startsWith(str3)) {
            return null;
        }
        if (massagedText.startsWith(str3)) {
            StringBuilder sb = new StringBuilder(str2);
            sb.append(massagedText.substring(4));
            str = sb.toString();
        } else {
            str = massagedText;
        }
        int indexOf = massagedText.indexOf(63, 4);
        return new TelParsedResult(indexOf < 0 ? massagedText.substring(4) : massagedText.substring(4, indexOf), str, null);
    }
}
