package com.elvishew.xlog.formatter.p228b.p232d;

import com.elvishew.xlog.formatter.FormatException;
import com.elvishew.xlog.p224c.SystemCompat;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/* renamed from: com.elvishew.xlog.formatter.b.d.a */
public class DefaultXmlFormatter implements XmlFormatter {
    /* renamed from: a */
    public String mo17099a(String str) {
        String str2 = ">";
        if (str == null || str.trim().length() == 0) {
            throw new FormatException("XML empty.");
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", String.valueOf(4));
            newTransformer.transform(streamSource, streamResult);
            String obj = streamResult.getWriter().toString();
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(SystemCompat.f9456a);
            str = obj.replaceFirst(str2, sb.toString());
            return str;
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Parse XML error. XML string:");
            sb2.append(str);
            throw new FormatException(sb2.toString(), e);
        }
    }
}
