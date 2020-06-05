package tmsdk.wup.jce.wup;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UniAttribute extends C8711c {
    protected HashMap<String, byte[]> _newData = null;
    /* renamed from: oT */
    private HashMap<String, Object> f29579oT = new HashMap<>();
    /* renamed from: oU */
    JceInputStream f29580oU = new JceInputStream();

    /* renamed from: a */
    private Object m37730a(byte[] bArr, Object obj) {
        this.f29580oU.warp(bArr);
        this.f29580oU.setServerEncoding(this.encodeName);
        return this.f29580oU.read(obj, 0, true);
    }

    /* renamed from: a */
    private void m37731a(String str, Object obj) {
        this.f29579oT.put(str, obj);
    }

    public void clearCacheData() {
        this.f29579oT.clear();
    }

    public boolean containsKey(String str) {
        HashMap<String, byte[]> hashMap = this._newData;
        return hashMap != null ? hashMap.containsKey(str) : this._data.containsKey(str);
    }

    public void decode(byte[] bArr) {
        try {
            super.decode(bArr);
        } catch (Exception unused) {
            this.f29580oU.warp(bArr);
            this.f29580oU.setServerEncoding(this.encodeName);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this._newData = this.f29580oU.readMap(hashMap, 0, false);
        }
    }

    public void decodeVersion2(byte[] bArr) {
        super.decode(bArr);
    }

    public void decodeVersion3(byte[] bArr) {
        this.f29580oU.warp(bArr);
        this.f29580oU.setServerEncoding(this.encodeName);
        HashMap hashMap = new HashMap(1);
        hashMap.put("", new byte[0]);
        this._newData = this.f29580oU.readMap(hashMap, 0, false);
    }

    public byte[] encode() {
        if (this._newData == null) {
            return super.encode();
        }
        JceOutputStream jceOutputStream = new JceOutputStream(0);
        jceOutputStream.setServerEncoding(this.encodeName);
        jceOutputStream.write((Map<K, V>) this._newData, 0);
        return JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
    }

    public <T> T get(String str) {
        if (this._newData == null) {
            return super.get(str);
        }
        throw new RuntimeException("data is encoded by new version, please use getByClass(String name, T proxy)");
    }

    public <T> T get(String str, Object obj) {
        if (this._newData == null) {
            return super.get(str, obj);
        }
        throw new RuntimeException("data is encoded by new version, please use get(String name, T proxy, Object defaultValue)");
    }

    public <T> T get(String str, T t, Object obj) {
        return !this._newData.containsKey(str) ? obj : getByClass(str, t);
    }

    public <T> T getByClass(String str, T t) {
        HashMap<String, byte[]> hashMap = this._newData;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            if (!this.f29579oT.containsKey(str)) {
                try {
                    T a = m37730a((byte[]) this._newData.get(str), (Object) t);
                    if (a != null) {
                        m37731a(str, (Object) a);
                    }
                    return a;
                } catch (Exception e) {
                    throw new C8710b(e);
                }
            }
        } else if (!this._data.containsKey(str)) {
            return null;
        } else {
            if (!this.f29579oT.containsKey(str)) {
                byte[] bArr = new byte[0];
                Iterator it = ((HashMap) this._data.get(str)).entrySet().iterator();
                if (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    String str2 = (String) entry.getKey();
                    bArr = (byte[]) entry.getValue();
                }
                try {
                    this.f29580oU.warp(bArr);
                    this.f29580oU.setServerEncoding(this.encodeName);
                    T read = this.f29580oU.read(t, 0, true);
                    m37731a(str, (Object) read);
                    return read;
                } catch (Exception e2) {
                    throw new C8710b(e2);
                }
            }
        }
        return this.f29579oT.get(str);
    }

    public <T> T getByClass(String str, T t, T t2) {
        HashMap<String, byte[]> hashMap = this._newData;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return t2;
            }
            if (!this.f29579oT.containsKey(str)) {
                try {
                    T a = m37730a((byte[]) this._newData.get(str), (Object) t);
                    if (a != null) {
                        m37731a(str, (Object) a);
                    }
                    return a;
                } catch (Exception e) {
                    throw new C8710b(e);
                }
            }
        } else if (!this._data.containsKey(str)) {
            return t2;
        } else {
            if (!this.f29579oT.containsKey(str)) {
                byte[] bArr = new byte[0];
                Iterator it = ((HashMap) this._data.get(str)).entrySet().iterator();
                if (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    String str2 = (String) entry.getKey();
                    bArr = (byte[]) entry.getValue();
                }
                try {
                    this.f29580oU.warp(bArr);
                    this.f29580oU.setServerEncoding(this.encodeName);
                    T read = this.f29580oU.read(t, 0, true);
                    m37731a(str, (Object) read);
                    return read;
                } catch (Exception e2) {
                    throw new C8710b(e2);
                }
            }
        }
        return this.f29579oT.get(str);
    }

    public /* bridge */ /* synthetic */ String getEncodeName() {
        return super.getEncodeName();
    }

    public <T> T getJceStruct(String str) {
        if (this._newData == null) {
            return super.getJceStruct(str);
        }
        throw new RuntimeException("data is encoded by new version, please use getJceStruct(String name,T proxy)");
    }

    public <T> T getJceStruct(String str, T t) {
        if (!this._newData.containsKey(str)) {
            return null;
        }
        if (this.f29579oT.containsKey(str)) {
            return this.f29579oT.get(str);
        }
        try {
            T a = m37730a((byte[]) this._newData.get(str), (Object) t);
            if (a != null) {
                m37731a(str, (Object) a);
            }
            return a;
        } catch (Exception e) {
            throw new C8710b(e);
        }
    }

    public Set<String> getKeySet() {
        HashMap<String, byte[]> hashMap = this._newData;
        if (hashMap == null) {
            hashMap = this._data;
        }
        return Collections.unmodifiableSet(hashMap.keySet());
    }

    public boolean isEmpty() {
        HashMap<String, byte[]> hashMap = this._newData;
        return hashMap != null ? hashMap.isEmpty() : this._data.isEmpty();
    }

    public <T> void put(String str, T t) {
        if (this._newData == null) {
            super.put(str, t);
        } else if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (!(t instanceof Set)) {
            JceOutputStream jceOutputStream = new JceOutputStream();
            jceOutputStream.setServerEncoding(this.encodeName);
            jceOutputStream.write((Object) t, 0);
            this._newData.put(str, JceUtil.getJceBufArray(jceOutputStream.getByteBuffer()));
        } else {
            throw new IllegalArgumentException("can not support Set");
        }
    }

    public <T> T remove(String str) {
        HashMap<String, byte[]> hashMap = this._newData;
        if (hashMap == null) {
            return super.remove(str);
        }
        if (!hashMap.containsKey(str)) {
            return null;
        }
        this._newData.remove(str);
        return null;
    }

    public <T> T remove(String str, T t) {
        if (!this._newData.containsKey(str)) {
            return null;
        }
        if (t != null) {
            return m37730a((byte[]) this._newData.remove(str), (Object) t);
        }
        this._newData.remove(str);
        return null;
    }

    public /* bridge */ /* synthetic */ void setEncodeName(String str) {
        super.setEncodeName(str);
    }

    public int size() {
        HashMap<String, byte[]> hashMap = this._newData;
        return hashMap != null ? hashMap.size() : this._data.size();
    }

    public void useVersion3() {
        this._newData = new HashMap<>();
    }
}
