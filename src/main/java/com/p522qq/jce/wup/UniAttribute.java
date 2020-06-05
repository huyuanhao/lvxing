package com.p522qq.jce.wup;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.qq.jce.wup.UniAttribute */
public class UniAttribute extends OldUniAttribute {
    JceInputStream _is = new JceInputStream();
    protected HashMap<String, byte[]> _newData = null;
    private HashMap<String, Object> cachedData = new HashMap<>();

    private Object decodeData(byte[] bArr, Object obj) {
        this._is.wrap(bArr);
        this._is.setServerEncoding(this.encodeName);
        return this._is.read(obj, 0, true);
    }

    private void saveDataCache(String str, Object obj) {
        this.cachedData.put(str, obj);
    }

    public void clearCacheData() {
        this.cachedData.clear();
    }

    public boolean containsKey(String str) {
        HashMap<String, byte[]> hashMap = this._newData;
        return hashMap != null ? hashMap.containsKey(str) : this._data.containsKey(str);
    }

    public void decode(byte[] bArr) {
        try {
            super.decode(bArr);
        } catch (Exception unused) {
            this._is.wrap(bArr);
            this._is.setServerEncoding(this.encodeName);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this._newData = this._is.readMap(hashMap, 0, false);
        }
    }

    public void decodeVersion2(byte[] bArr) {
        super.decode(bArr);
    }

    public void decodeVersion3(byte[] bArr) {
        this._is.wrap(bArr);
        this._is.setServerEncoding(this.encodeName);
        HashMap hashMap = new HashMap(1);
        hashMap.put("", new byte[0]);
        this._newData = this._is.readMap(hashMap, 0, false);
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

    public /* bridge */ /* synthetic */ Object get(String str) {
        return super.get(str);
    }

    public /* bridge */ /* synthetic */ Object get(String str, Object obj) {
        return super.get(str, obj);
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
            if (!this.cachedData.containsKey(str)) {
                try {
                    T decodeData = decodeData((byte[]) this._newData.get(str), t);
                    if (decodeData != null) {
                        saveDataCache(str, decodeData);
                    }
                    return decodeData;
                } catch (Exception e) {
                    throw new ObjectCreateException(e);
                }
            }
        } else if (!this._data.containsKey(str)) {
            return null;
        } else {
            if (!this.cachedData.containsKey(str)) {
                byte[] bArr = new byte[0];
                Iterator it = ((HashMap) this._data.get(str)).entrySet().iterator();
                if (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    String str2 = (String) entry.getKey();
                    bArr = (byte[]) entry.getValue();
                }
                try {
                    this._is.wrap(bArr);
                    this._is.setServerEncoding(this.encodeName);
                    T read = this._is.read(t, 0, true);
                    saveDataCache(str, read);
                    return read;
                } catch (Exception e2) {
                    throw new ObjectCreateException(e2);
                }
            }
        }
        return this.cachedData.get(str);
    }

    public <T> T getByClass(String str, T t, T t2) {
        HashMap<String, byte[]> hashMap = this._newData;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return t2;
            }
            if (!this.cachedData.containsKey(str)) {
                try {
                    T decodeData = decodeData((byte[]) this._newData.get(str), t);
                    if (decodeData != null) {
                        saveDataCache(str, decodeData);
                    }
                    return decodeData;
                } catch (Exception e) {
                    throw new ObjectCreateException(e);
                }
            }
        } else if (!this._data.containsKey(str)) {
            return t2;
        } else {
            if (!this.cachedData.containsKey(str)) {
                byte[] bArr = new byte[0];
                Iterator it = ((HashMap) this._data.get(str)).entrySet().iterator();
                if (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    String str2 = (String) entry.getKey();
                    bArr = (byte[]) entry.getValue();
                }
                try {
                    this._is.wrap(bArr);
                    this._is.setServerEncoding(this.encodeName);
                    T read = this._is.read(t, 0, true);
                    saveDataCache(str, read);
                    return read;
                } catch (Exception e2) {
                    throw new ObjectCreateException(e2);
                }
            }
        }
        return this.cachedData.get(str);
    }

    public /* bridge */ /* synthetic */ String getEncodeName() {
        return super.getEncodeName();
    }

    public /* bridge */ /* synthetic */ Object getJceStruct(String str) {
        return super.getJceStruct(str);
    }

    public <T> T getJceStruct(String str, T t) {
        if (!this._newData.containsKey(str)) {
            return null;
        }
        if (this.cachedData.containsKey(str)) {
            return this.cachedData.get(str);
        }
        try {
            T decodeData = decodeData((byte[]) this._newData.get(str), t);
            if (decodeData != null) {
                saveDataCache(str, decodeData);
            }
            return decodeData;
        } catch (Exception e) {
            throw new ObjectCreateException(e);
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
            return decodeData((byte[]) this._newData.remove(str), t);
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
