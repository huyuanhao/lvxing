package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.oned.UPCEReader;

public final class ProductResultParser extends ResultParser {
    public ProductParsedResult parse(Result result) {
        BarcodeFormat barcodeFormat = result.getBarcodeFormat();
        if (barcodeFormat != BarcodeFormat.UPC_A && barcodeFormat != BarcodeFormat.UPC_E && barcodeFormat != BarcodeFormat.EAN_8 && barcodeFormat != BarcodeFormat.EAN_13) {
            return null;
        }
        String massagedText = getMassagedText(result);
        if (!isStringOfDigits(massagedText, massagedText.length())) {
            return null;
        }
        String convertUPCEtoUPCA = (barcodeFormat == BarcodeFormat.UPC_E && massagedText.length() == 8) ? UPCEReader.convertUPCEtoUPCA(massagedText) : massagedText;
        return new ProductParsedResult(massagedText, convertUPCEtoUPCA);
    }
}
