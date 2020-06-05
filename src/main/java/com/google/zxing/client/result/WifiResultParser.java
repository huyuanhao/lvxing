package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class WifiResultParser extends ResultParser {
    public WifiParsedResult parse(Result result) {
        String massagedText = getMassagedText(result);
        if (!massagedText.startsWith("WIFI:")) {
            return null;
        }
        String substring = massagedText.substring(5);
        String matchSinglePrefixedField = matchSinglePrefixedField("S:", substring, ';', false);
        if (matchSinglePrefixedField == null || matchSinglePrefixedField.isEmpty()) {
            return null;
        }
        String matchSinglePrefixedField2 = matchSinglePrefixedField("P:", substring, ';', false);
        String matchSinglePrefixedField3 = matchSinglePrefixedField("T:", substring, ';', false);
        if (matchSinglePrefixedField3 == null) {
            matchSinglePrefixedField3 = "nopass";
        }
        String str = matchSinglePrefixedField3;
        String str2 = "H:";
        WifiParsedResult wifiParsedResult = new WifiParsedResult(str, matchSinglePrefixedField, matchSinglePrefixedField2, Boolean.parseBoolean(matchSinglePrefixedField(str2, substring, ';', false)), matchSinglePrefixedField("I:", substring, ';', false), matchSinglePrefixedField("A:", substring, ';', false), matchSinglePrefixedField("E:", substring, ';', false), matchSinglePrefixedField(str2, substring, ';', false));
        return wifiParsedResult;
    }
}
