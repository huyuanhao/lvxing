package tmsdk.wup.jce.wup;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: tmsdk.wup.jce.wup.c */
class C8711c {
    protected HashMap<String, HashMap<String, byte[]>> _data = new HashMap<>();
    protected HashMap<String, Object> cachedClassName = new HashMap<>();
    protected String encodeName = "GBK";
    /* renamed from: oT */
    private HashMap<String, Object> f29581oT = new HashMap<>();
    /* renamed from: oU */
    JceInputStream f29582oU = new JceInputStream();

    C8711c() {
    }

    /* renamed from: E */
    private Object m37733E(String str) {
        if (this.cachedClassName.containsKey(str)) {
            return this.cachedClassName.get(str);
        }
        Object createClassByUni = C8709a.createClassByUni(str);
        this.cachedClassName.put(str, createClassByUni);
        return createClassByUni;
    }

    /* renamed from: a */
    private void m37734a(String str, Object obj) {
        this.f29581oT.put(str, obj);
    }

    /* renamed from: a */
    private void m37735a(ArrayList<String> arrayList, Object obj) {
        Object obj2;
        String str = "java.util.List";
        String str2 = "?";
        if (obj.getClass().isArray()) {
            if (!obj.getClass().getComponentType().toString().equals("byte")) {
                throw new IllegalArgumentException("only byte[] is supported");
            } else if (Array.getLength(obj) > 0) {
                arrayList.add(str);
                obj2 = Array.get(obj, 0);
            } else {
                arrayList.add("Array");
                arrayList.add(str2);
                return;
            }
        } else if (obj instanceof Array) {
            throw new IllegalArgumentException("can not support Array, please use List");
        } else if (obj instanceof List) {
            arrayList.add(str);
            List list = (List) obj;
            if (list.size() > 0) {
                obj2 = list.get(0);
            }
            arrayList.add(str2);
            return;
        } else if (obj instanceof Map) {
            arrayList.add("java.util.Map");
            Map map = (Map) obj;
            if (map.size() > 0) {
                Object next = map.keySet().iterator().next();
                obj2 = map.get(next);
                arrayList.add(next.getClass().getName());
            } else {
                arrayList.add(str2);
                arrayList.add(str2);
                return;
            }
        } else {
            arrayList.add(obj.getClass().getName());
            return;
        }
        m37735a(arrayList, obj2);
    }

    public void clearCacheData() {
        this.f29581oT.clear();
    }

    public boolean containsKey(String str) {
        return this._data.containsKey(str);
    }

    public void decode(byte[] bArr) {
        this.f29582oU.warp(bArr);
        this.f29582oU.setServerEncoding(this.encodeName);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        String str = "";
        hashMap2.put(str, new byte[0]);
        hashMap.put(str, hashMap2);
        this._data = this.f29582oU.readMap(hashMap, 0, false);
    }

    public byte[] encode() {
        JceOutputStream jceOutputStream = new JceOutputStream(0);
        jceOutputStream.setServerEncoding(this.encodeName);
        jceOutputStream.write((Map<K, V>) this._data, 0);
        return JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
    }

    public <T> T get(String str) {
        String str2 = null;
        if (!this._data.containsKey(str)) {
            return null;
        }
        if (this.f29581oT.containsKey(str)) {
            return this.f29581oT.get(str);
        }
        byte[] bArr = new byte[0];
        Iterator it = ((HashMap) this._data.get(str)).entrySet().iterator();
        if (it.hasNext()) {
            Entry entry = (Entry) it.next();
            str2 = (String) entry.getKey();
            bArr = (byte[]) entry.getValue();
        }
        try {
            Object E = m37733E(str2);
            this.f29582oU.warp(bArr);
            this.f29582oU.setServerEncoding(this.encodeName);
            T read = this.f29582oU.read(E, 0, true);
            m37734a(str, (Object) read);
            return read;
        } catch (Exception e) {
            e.printStackTrace();
            throw new C8710b(e);
        }
    }

    public <T> T get(String str, Object obj) {
        String str2;
        if (!this._data.containsKey(str)) {
            return obj;
        }
        if (this.f29581oT.containsKey(str)) {
            return this.f29581oT.get(str);
        }
        byte[] bArr = new byte[0];
        Iterator it = ((HashMap) this._data.get(str)).entrySet().iterator();
        if (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String str3 = (String) entry.getKey();
            bArr = (byte[]) entry.getValue();
            str2 = str3;
        } else {
            str2 = "";
        }
        try {
            Object E = m37733E(str2);
            this.f29582oU.warp(bArr);
            this.f29582oU.setServerEncoding(this.encodeName);
            T read = this.f29582oU.read(E, 0, true);
            m37734a(str, (Object) read);
            return read;
        } catch (Exception e) {
            e.printStackTrace();
            m37734a(str, obj);
            return obj;
        }
    }

    public String getEncodeName() {
        return this.encodeName;
    }

    public <T> T getJceStruct(String str) {
        String str2 = null;
        if (!this._data.containsKey(str)) {
            return null;
        }
        if (this.f29581oT.containsKey(str)) {
            return this.f29581oT.get(str);
        }
        byte[] bArr = new byte[0];
        Iterator it = ((HashMap) this._data.get(str)).entrySet().iterator();
        if (it.hasNext()) {
            Entry entry = (Entry) it.next();
            str2 = (String) entry.getKey();
            bArr = (byte[]) entry.getValue();
        }
        try {
            Object E = m37733E(str2);
            this.f29582oU.warp(bArr);
            this.f29582oU.setServerEncoding(this.encodeName);
            T directRead = this.f29582oU.directRead((JceStruct) E, 0, true);
            m37734a(str, (Object) directRead);
            return directRead;
        } catch (Exception e) {
            e.printStackTrace();
            throw new C8710b(e);
        }
    }

    public Set<String> getKeySet() {
        return Collections.unmodifiableSet(this._data.keySet());
    }

    public boolean isEmpty() {
        return this._data.isEmpty();
    }

    public <T> void put(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (!(t instanceof Set)) {
            JceOutputStream jceOutputStream = new JceOutputStream();
            jceOutputStream.setServerEncoding(this.encodeName);
            jceOutputStream.write((Object) t, 0);
            byte[] jceBufArray = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
            HashMap hashMap = new HashMap(1);
            ArrayList arrayList = new ArrayList(1);
            m37735a(arrayList, (Object) t);
            hashMap.put(C8709a.transTypeList(arrayList), jceBufArray);
            this.f29581oT.remove(str);
            this._data.put(str, hashMap);
        } else {
            throw new IllegalArgumentException("can not support Set");
        }
    }

    public <T> T remove(String str) {
        String str2;
        if (!this._data.containsKey(str)) {
            return null;
        }
        byte[] bArr = new byte[0];
        Iterator it = ((HashMap) this._data.remove(str)).entrySet().iterator();
        if (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String str3 = (String) entry.getKey();
            bArr = (byte[]) entry.getValue();
            str2 = str3;
        } else {
            str2 = "";
        }
        try {
            Object createClassByUni = C8709a.createClassByUni(str2);
            this.f29582oU.warp(bArr);
            this.f29582oU.setServerEncoding(this.encodeName);
            return this.f29582oU.read(createClassByUni, 0, true);
        } catch (Exception e) {
            e.printStackTrace();
            throw new C8710b(e);
        }
    }

    public void setEncodeName(String str) {
        this.encodeName = str;
    }

    public int size() {
        return this._data.size();
    }
}
