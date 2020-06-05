package com.bytedance.tea.crash.p221g;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.tea.crash.p216c.UploadRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FileUtils */
/* renamed from: com.bytedance.tea.crash.g.d */
public class C2593d {
    /* renamed from: a */
    public static void m12527a(File file, String str, boolean z) throws IOException {
        FileOutputStream fileOutputStream;
        if (!TextUtils.isEmpty(str)) {
            file.getParentFile().mkdirs();
            try {
                fileOutputStream = new FileOutputStream(file, z);
                try {
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.flush();
                    IoUtil.m12535a(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    IoUtil.m12535a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                IoUtil.m12535a(fileOutputStream);
                throw th;
            }
        }
    }

    /* renamed from: a */
    public static boolean m12530a(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.delete()) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m12528a(File file) {
        return file.exists() && file.delete();
    }

    /* renamed from: a */
    public static boolean m12529a(File file, boolean z) {
        boolean z2;
        if (!z || file.isFile()) {
            return m12528a(file);
        }
        boolean z3 = true;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            int i = 0;
            boolean z4 = true;
            while (listFiles != null && i < listFiles.length) {
                if (listFiles[i].isFile()) {
                    z2 = m12528a(listFiles[i]);
                } else {
                    z2 = m12529a(listFiles[i], true);
                }
                z4 &= z2;
                i++;
            }
            z3 = z4 & m12528a(file);
        }
        return z3;
    }

    /* renamed from: a */
    public static String m12525a(String str, String str2) throws IOException {
        BufferedReader bufferedReader = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        if (str2 != null) {
                            sb.append(str2);
                        }
                    } else {
                        IoUtil.m12535a(bufferedReader2);
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    IoUtil.m12535a(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            IoUtil.m12535a(bufferedReader);
            throw th;
        }
    }

    /* renamed from: b */
    public static String m12531b(String str) throws IOException {
        return m12525a(str, (String) null);
    }

    /* renamed from: c */
    public static UploadRequest m12532c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(m12531b(str));
            UploadRequest cVar = new UploadRequest();
            cVar.mo17007a(jSONObject.optString("url"));
            cVar.mo17008a(jSONObject.optJSONObject("body"));
            cVar.mo17011b(jSONObject.optString("dump_file"));
            cVar.mo17009a(jSONObject.optBoolean("encrypt", false));
            return cVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m12524a(File file, String str, String str2, JSONObject jSONObject, boolean z) {
        return m12523a(file, str, str2, jSONObject, null, z);
    }

    /* renamed from: a */
    public static String m12523a(File file, String str, String str2, JSONObject jSONObject, String str3, boolean z) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", str2);
            jSONObject2.put("body", jSONObject);
            String str4 = "dump_file";
            if (str3 == null) {
                str3 = "";
            }
            jSONObject2.put(str4, str3);
            jSONObject2.put("encrypt", z);
            m12527a(file2, jSONObject2.toString(), false);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return file2.getAbsolutePath();
    }

    /* renamed from: a */
    public static void m12526a(Context context, String str, String str2) {
        String str3 = " ";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            sb.append(str3);
            String str4 = "null";
            if (str == null) {
                str = str4;
            }
            sb.append(str);
            sb.append(str3);
            if (str2 == null) {
                str2 = str4;
            }
            sb.append(str2);
            sb.append("\n");
            m12527a(LogPath.m12541b(context), sb.toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    public static String[] m12533d(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)), 1000);
            try {
                String readLine = bufferedReader.readLine();
                int indexOf = readLine.indexOf(")");
                if (indexOf > 0) {
                    readLine = readLine.substring(indexOf + 2);
                }
                String[] split = readLine.split(" ");
                IoUtil.m12535a(bufferedReader);
                return split;
            } catch (Exception e) {
                e = e;
                try {
                    e.printStackTrace();
                    IoUtil.m12535a(bufferedReader);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    IoUtil.m12535a(bufferedReader);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
            e.printStackTrace();
            IoUtil.m12535a(bufferedReader);
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            IoUtil.m12535a(bufferedReader);
            throw th;
        }
    }
}
