package com.qiyukf.nimlib.p488k.p489a;

import com.qiyukf.basesdk.p412c.p413a.C5363b;
import com.qiyukf.unicorn.C5961R;
import com.tencent.android.tpush.SettingsContentProvider;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.qiyukf.nimlib.k.a.b */
public final class C5938b {
    /* renamed from: a */
    private static final Map<String, Integer> f18756a;

    static {
        HashMap hashMap = new HashMap();
        f18756a = hashMap;
        hashMap.put("xls", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_xls));
        f18756a.put("xlsx", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_xls));
        f18756a.put("csv", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_xls));
        f18756a.put("ppt", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_ppt));
        f18756a.put("pptx", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_ppt));
        f18756a.put("doc", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_doc));
        f18756a.put("docx", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_doc));
        f18756a.put("pdf", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_pdf));
        f18756a.put(SettingsContentProvider.KEY, Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_key));
        f18756a.put("txt", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_txt));
        f18756a.put("htm", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_txt));
        f18756a.put("html", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_txt));
        f18756a.put("zip", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_zip));
        f18756a.put("rar", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_zip));
        f18756a.put("7z", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_zip));
        f18756a.put("bmp", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_jpg));
        f18756a.put("jpg", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_jpg));
        f18756a.put("jpeg", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_jpg));
        f18756a.put("png", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_jpg));
        f18756a.put("gif", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_jpg));
        f18756a.put("exif", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_jpg));
        f18756a.put("mp3", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_mp3));
        f18756a.put("wma", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_mp3));
        f18756a.put("ape", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_mp3));
        f18756a.put("flac", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_mp3));
        f18756a.put("wav", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_mp3));
        f18756a.put("aac", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_mp3));
        f18756a.put("ogg", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_mp3));
        f18756a.put("avi", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_mp4));
        f18756a.put("mov", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_mp4));
        f18756a.put("mkv", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_mp4));
        f18756a.put("rmvb", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_mp4));
        f18756a.put("wmv", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_mp4));
        f18756a.put("3gp", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_mp4));
        f18756a.put("flv", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_mp4));
        f18756a.put("mp4", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_mp4));
        f18756a.put("mpg", Integer.valueOf(C5961R.C5962drawable.ysf_message_file_icon_mp4));
    }

    /* renamed from: a */
    public static int m23803a(String str, boolean z) {
        Integer num = (Integer) f18756a.get(C5363b.m22023a(str).toLowerCase());
        return num == null ? z ? C5961R.C5962drawable.ysf_message_file_icon_unknown_preview : C5961R.C5962drawable.ysf_message_file_icon_unknown : num.intValue();
    }
}
