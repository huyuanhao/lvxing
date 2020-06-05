package p681me.jessyan.retrofiturlmanager;

import android.text.TextUtils;

/* renamed from: me.jessyan.retrofiturlmanager.InvalidUrlException */
public class InvalidUrlException extends RuntimeException {
    public InvalidUrlException(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("You've configured an invalid url : ");
        if (TextUtils.isEmpty(str)) {
            str = "EMPTY_OR_NULL_URL";
        }
        sb.append(str);
        super(sb.toString());
    }
}
