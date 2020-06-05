package com.p570ta.utdid2.p574c.p575a;

import android.util.Xml;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.ta.utdid2.c.a.e */
class XmlUtils {
    /* renamed from: a */
    public static final void m29086a(Map map, OutputStream outputStream) throws XmlPullParserException, IOException {
        FastXmlSerializer aVar = new FastXmlSerializer();
        aVar.setOutput(outputStream, "utf-8");
        aVar.startDocument(null, Boolean.valueOf(true));
        aVar.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        m29087a(map, (String) null, (XmlSerializer) aVar);
        aVar.endDocument();
    }

    /* renamed from: a */
    public static final void m29087a(Map map, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (map == null) {
            String str2 = "null";
            xmlSerializer.startTag(null, str2);
            xmlSerializer.endTag(null, str2);
            return;
        }
        String str3 = "map";
        xmlSerializer.startTag(null, str3);
        if (str != null) {
            xmlSerializer.attribute(null, ArgKey.KEY_NAME, str);
        }
        for (Entry entry : map.entrySet()) {
            m29084a(entry.getValue(), (String) entry.getKey(), xmlSerializer);
        }
        xmlSerializer.endTag(null, str3);
    }

    /* renamed from: a */
    public static final void m29085a(List list, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (list == null) {
            String str2 = "null";
            xmlSerializer.startTag(null, str2);
            xmlSerializer.endTag(null, str2);
            return;
        }
        String str3 = "list";
        xmlSerializer.startTag(null, str3);
        if (str != null) {
            xmlSerializer.attribute(null, ArgKey.KEY_NAME, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            m29084a(list.get(i), (String) null, xmlSerializer);
        }
        xmlSerializer.endTag(null, str3);
    }

    /* renamed from: a */
    public static final void m29088a(byte[] bArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (bArr == null) {
            String str2 = "null";
            xmlSerializer.startTag(null, str2);
            xmlSerializer.endTag(null, str2);
            return;
        }
        String str3 = "byte-array";
        xmlSerializer.startTag(null, str3);
        if (str != null) {
            xmlSerializer.attribute(null, ArgKey.KEY_NAME, str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(r8));
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = b >> 4;
            sb.append(i >= 10 ? (i + 97) - 10 : i + 48);
            byte b2 = b & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            sb.append(b2 >= 10 ? (b2 + 97) - 10 : b2 + 48);
        }
        xmlSerializer.text(sb.toString());
        xmlSerializer.endTag(null, str3);
    }

    /* renamed from: a */
    public static final void m29089a(int[] iArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (iArr == null) {
            String str2 = "null";
            xmlSerializer.startTag(null, str2);
            xmlSerializer.endTag(null, str2);
            return;
        }
        String str3 = "int-array";
        xmlSerializer.startTag(null, str3);
        if (str != null) {
            xmlSerializer.attribute(null, ArgKey.KEY_NAME, str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(r7));
        for (int num : iArr) {
            String str4 = "item";
            xmlSerializer.startTag(null, str4);
            xmlSerializer.attribute(null, ArgKey.KEY_VALUE, Integer.toString(num));
            xmlSerializer.endTag(null, str4);
        }
        xmlSerializer.endTag(null, str3);
    }

    /* renamed from: a */
    public static final void m29084a(Object obj, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        String str2;
        String str3 = ArgKey.KEY_NAME;
        if (obj == null) {
            String str4 = "null";
            xmlSerializer.startTag(null, str4);
            if (str != null) {
                xmlSerializer.attribute(null, str3, str);
            }
            xmlSerializer.endTag(null, str4);
            return;
        }
        boolean z = obj instanceof String;
        String str5 = SettingsContentProvider.STRING_TYPE;
        if (z) {
            xmlSerializer.startTag(null, str5);
            if (str != null) {
                xmlSerializer.attribute(null, str3, str);
            }
            xmlSerializer.text(obj.toString());
            xmlSerializer.endTag(null, str5);
            return;
        }
        if (obj instanceof Integer) {
            str2 = "int";
        } else if (obj instanceof Long) {
            str2 = SettingsContentProvider.LONG_TYPE;
        } else if (obj instanceof Float) {
            str2 = SettingsContentProvider.FLOAT_TYPE;
        } else if (obj instanceof Double) {
            str2 = "double";
        } else if (obj instanceof Boolean) {
            str2 = SettingsContentProvider.BOOLEAN_TYPE;
        } else if (obj instanceof byte[]) {
            m29088a((byte[]) obj, str, xmlSerializer);
            return;
        } else if (obj instanceof int[]) {
            m29089a((int[]) obj, str, xmlSerializer);
            return;
        } else if (obj instanceof Map) {
            m29087a((Map) obj, str, xmlSerializer);
            return;
        } else if (obj instanceof List) {
            m29085a((List) obj, str, xmlSerializer);
            return;
        } else if (obj instanceof CharSequence) {
            xmlSerializer.startTag(null, str5);
            if (str != null) {
                xmlSerializer.attribute(null, str3, str);
            }
            xmlSerializer.text(obj.toString());
            xmlSerializer.endTag(null, str5);
            return;
        } else {
            StringBuilder sb = new StringBuilder("writeValueXml: unable to write value ");
            sb.append(obj);
            throw new RuntimeException(sb.toString());
        }
        xmlSerializer.startTag(null, str2);
        if (str != null) {
            xmlSerializer.attribute(null, str3, str);
        }
        xmlSerializer.attribute(null, ArgKey.KEY_VALUE, obj.toString());
        xmlSerializer.endTag(null, str2);
    }

    /* renamed from: a */
    public static final HashMap m29082a(InputStream inputStream) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, null);
        return (HashMap) m29080a(newPullParser, new String[1]);
    }

    /* renamed from: a */
    public static final HashMap m29083a(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        HashMap hashMap = new HashMap();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                Object b = m29091b(xmlPullParser, strArr);
                if (strArr[0] != null) {
                    hashMap.put(strArr[0], b);
                } else {
                    StringBuilder sb = new StringBuilder("Map value without name attribute: ");
                    sb.append(xmlPullParser.getName());
                    throw new XmlPullParserException(sb.toString());
                }
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return hashMap;
                }
                StringBuilder sb2 = new StringBuilder("Expected ");
                sb2.append(str);
                sb2.append(" end tag at: ");
                sb2.append(xmlPullParser.getName());
                throw new XmlPullParserException(sb2.toString());
            }
            eventType = xmlPullParser.next();
            if (eventType == 1) {
                StringBuilder sb3 = new StringBuilder("Document ended before ");
                sb3.append(str);
                sb3.append(" end tag");
                throw new XmlPullParserException(sb3.toString());
            }
        }
    }

    /* renamed from: a */
    public static final ArrayList m29081a(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                arrayList.add(m29091b(xmlPullParser, strArr));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return arrayList;
                }
                StringBuilder sb = new StringBuilder("Expected ");
                sb.append(str);
                sb.append(" end tag at: ");
                sb.append(xmlPullParser.getName());
                throw new XmlPullParserException(sb.toString());
            }
            eventType = xmlPullParser.next();
            if (eventType == 1) {
                StringBuilder sb2 = new StringBuilder("Document ended before ");
                sb2.append(str);
                sb2.append(" end tag");
                throw new XmlPullParserException(sb2.toString());
            }
        }
    }

    /* renamed from: a */
    public static final int[] m29090a(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        try {
            int[] iArr = new int[Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"))];
            int i = 0;
            int eventType = xmlPullParser.getEventType();
            while (true) {
                String str2 = "item";
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals(str2)) {
                        try {
                            iArr[i] = Integer.parseInt(xmlPullParser.getAttributeValue(null, ArgKey.KEY_VALUE));
                        } catch (NullPointerException unused) {
                            throw new XmlPullParserException("Need value attribute in item");
                        } catch (NumberFormatException unused2) {
                            throw new XmlPullParserException("Not a number in value attribute in item");
                        }
                    } else {
                        StringBuilder sb = new StringBuilder("Expected item tag at: ");
                        sb.append(xmlPullParser.getName());
                        throw new XmlPullParserException(sb.toString());
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return iArr;
                    }
                    if (xmlPullParser.getName().equals(str2)) {
                        i++;
                    } else {
                        StringBuilder sb2 = new StringBuilder("Expected ");
                        sb2.append(str);
                        sb2.append(" end tag at: ");
                        sb2.append(xmlPullParser.getName());
                        throw new XmlPullParserException(sb2.toString());
                    }
                }
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    StringBuilder sb3 = new StringBuilder("Document ended before ");
                    sb3.append(str);
                    sb3.append(" end tag");
                    throw new XmlPullParserException(sb3.toString());
                }
            }
        } catch (NullPointerException unused3) {
            throw new XmlPullParserException("Need num attribute in byte-array");
        } catch (NumberFormatException unused4) {
            throw new XmlPullParserException("Not a number in num attribute in byte-array");
        }
    }

    /* renamed from: a */
    public static final Object m29080a(XmlPullParser xmlPullParser, String[] strArr) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 2) {
            if (eventType == 3) {
                StringBuilder sb = new StringBuilder("Unexpected end tag at: ");
                sb.append(xmlPullParser.getName());
                throw new XmlPullParserException(sb.toString());
            } else if (eventType != 4) {
                try {
                    eventType = xmlPullParser.next();
                    if (eventType == 1) {
                        throw new XmlPullParserException("Unexpected end of document");
                    }
                } catch (Exception unused) {
                    StringBuilder sb2 = new StringBuilder("Unexpected call next(): ");
                    sb2.append(xmlPullParser.getName());
                    throw new XmlPullParserException(sb2.toString());
                }
            } else {
                StringBuilder sb3 = new StringBuilder("Unexpected text: ");
                sb3.append(xmlPullParser.getText());
                throw new XmlPullParserException(sb3.toString());
            }
        }
        return m29091b(xmlPullParser, strArr);
    }

    /* renamed from: b */
    private static final Object m29091b(XmlPullParser xmlPullParser, String[] strArr) throws XmlPullParserException, IOException {
        Object d;
        Object obj = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, ArgKey.KEY_NAME);
        String name = xmlPullParser.getName();
        if (!name.equals("null")) {
            String str = SettingsContentProvider.STRING_TYPE;
            if (name.equals(str)) {
                String str2 = "";
                while (true) {
                    int next = xmlPullParser.next();
                    if (next == 1) {
                        throw new XmlPullParserException("Unexpected end of document in <string>");
                    } else if (next == 3) {
                        if (xmlPullParser.getName().equals(str)) {
                            strArr[0] = attributeValue;
                            return str2;
                        }
                        StringBuilder sb = new StringBuilder("Unexpected end tag in <string>: ");
                        sb.append(xmlPullParser.getName());
                        throw new XmlPullParserException(sb.toString());
                    } else if (next == 4) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str2));
                        sb2.append(xmlPullParser.getText());
                        str2 = sb2.toString();
                    } else if (next == 2) {
                        StringBuilder sb3 = new StringBuilder("Unexpected start tag in <string>: ");
                        sb3.append(xmlPullParser.getName());
                        throw new XmlPullParserException(sb3.toString());
                    }
                }
            } else {
                boolean equals = name.equals("int");
                String str3 = ArgKey.KEY_VALUE;
                if (equals) {
                    obj = Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, str3)));
                } else if (name.equals(SettingsContentProvider.LONG_TYPE)) {
                    obj = Long.valueOf(xmlPullParser.getAttributeValue(null, str3));
                } else {
                    if (name.equals(SettingsContentProvider.FLOAT_TYPE)) {
                        d = new Float(xmlPullParser.getAttributeValue(null, str3));
                    } else if (name.equals("double")) {
                        d = new Double(xmlPullParser.getAttributeValue(null, str3));
                    } else if (name.equals(SettingsContentProvider.BOOLEAN_TYPE)) {
                        obj = Boolean.valueOf(xmlPullParser.getAttributeValue(null, str3));
                    } else {
                        String str4 = "int-array";
                        if (name.equals(str4)) {
                            xmlPullParser.next();
                            int[] a = m29081a(xmlPullParser, str4, strArr);
                            strArr[0] = attributeValue;
                            return a;
                        }
                        String str5 = "map";
                        if (name.equals(str5)) {
                            xmlPullParser.next();
                            HashMap a2 = m29081a(xmlPullParser, str5, strArr);
                            strArr[0] = attributeValue;
                            return a2;
                        }
                        String str6 = "list";
                        if (name.equals(str6)) {
                            xmlPullParser.next();
                            ArrayList a3 = m29081a(xmlPullParser, str6, strArr);
                            strArr[0] = attributeValue;
                            return a3;
                        }
                        StringBuilder sb4 = new StringBuilder("Unknown tag: ");
                        sb4.append(name);
                        throw new XmlPullParserException(sb4.toString());
                    }
                    obj = d;
                }
            }
        }
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 != 1) {
                String str7 = ">: ";
                if (next2 == 3) {
                    if (xmlPullParser.getName().equals(name)) {
                        strArr[0] = attributeValue;
                        return obj;
                    }
                    StringBuilder sb5 = new StringBuilder("Unexpected end tag in <");
                    sb5.append(name);
                    sb5.append(str7);
                    sb5.append(xmlPullParser.getName());
                    throw new XmlPullParserException(sb5.toString());
                } else if (next2 == 4) {
                    StringBuilder sb6 = new StringBuilder("Unexpected text in <");
                    sb6.append(name);
                    sb6.append(str7);
                    sb6.append(xmlPullParser.getName());
                    throw new XmlPullParserException(sb6.toString());
                } else if (next2 == 2) {
                    StringBuilder sb7 = new StringBuilder("Unexpected start tag in <");
                    sb7.append(name);
                    sb7.append(str7);
                    sb7.append(xmlPullParser.getName());
                    throw new XmlPullParserException(sb7.toString());
                }
            } else {
                StringBuilder sb8 = new StringBuilder("Unexpected end of document in <");
                sb8.append(name);
                sb8.append(">");
                throw new XmlPullParserException(sb8.toString());
            }
        }
    }
}
