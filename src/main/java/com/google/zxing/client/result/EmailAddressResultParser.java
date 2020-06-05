package com.google.zxing.client.result;

import com.google.zxing.Result;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.Map;
import java.util.regex.Pattern;

public final class EmailAddressResultParser extends ResultParser {
    private static final Pattern COMMA = Pattern.compile(StorageInterface.KEY_SPLITER);

    public EmailAddressParsedResult parse(Result result) {
        String str;
        String str2;
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String massagedText = getMassagedText(result);
        String[] strArr4 = null;
        if (massagedText.startsWith("mailto:") || massagedText.startsWith("MAILTO:")) {
            String substring = massagedText.substring(7);
            int indexOf = substring.indexOf(63);
            if (indexOf >= 0) {
                substring = substring.substring(0, indexOf);
            }
            try {
                String urlDecode = urlDecode(substring);
                String[] split = !urlDecode.isEmpty() ? COMMA.split(urlDecode) : null;
                Map parseNameValuePairs = parseNameValuePairs(massagedText);
                if (parseNameValuePairs != null) {
                    if (split == null) {
                        String str3 = (String) parseNameValuePairs.get("to");
                        if (str3 != null) {
                            split = COMMA.split(str3);
                        }
                    }
                    String str4 = (String) parseNameValuePairs.get("cc");
                    String[] split2 = str4 != null ? COMMA.split(str4) : null;
                    String str5 = (String) parseNameValuePairs.get("bcc");
                    if (str5 != null) {
                        strArr4 = COMMA.split(str5);
                    }
                    str = (String) parseNameValuePairs.get("body");
                    strArr3 = split;
                    strArr = strArr4;
                    strArr2 = split2;
                    str2 = (String) parseNameValuePairs.get("subject");
                } else {
                    strArr3 = split;
                    strArr2 = null;
                    strArr = null;
                    str2 = null;
                    str = null;
                }
                EmailAddressParsedResult emailAddressParsedResult = new EmailAddressParsedResult(strArr3, strArr2, strArr, str2, str);
                return emailAddressParsedResult;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        } else if (!EmailDoCoMoResultParser.isBasicallyValidEmailAddress(massagedText)) {
            return null;
        } else {
            return new EmailAddressParsedResult(massagedText);
        }
    }
}
