package com.tencent.android.tpush.service.channel.protocol;

import com.p522qq.taf.jce.JceDisplayer;
import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import com.p522qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class ApList extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ArrayList<Integer> cache_portList = new ArrayList<>();
    static Map<Byte, Long> cache_primary = new HashMap();
    static Map<Byte, Long> cache_secondary = new HashMap();
    static ArrayList<Long> cache_speedTestIpList = new ArrayList<>();
    public long backup = 0;
    public String domain = "";
    public ArrayList<Integer> portList = null;
    public Map<Byte, Long> primary = null;
    public Map<Byte, Long> secondary = null;
    public ArrayList<Long> speedTestIpList = null;

    public String className() {
        return "TPNS_CLIENT_PROTOCOL.ApList";
    }

    public String fullClassName() {
        return "com.tencent.android.tpush.service.channel.protocol.ApList";
    }

    public Map<Byte, Long> getPrimary() {
        return this.primary;
    }

    public void setPrimary(Map<Byte, Long> map) {
        this.primary = map;
    }

    public Map<Byte, Long> getSecondary() {
        return this.secondary;
    }

    public void setSecondary(Map<Byte, Long> map) {
        this.secondary = map;
    }

    public long getBackup() {
        return this.backup;
    }

    public void setBackup(long j) {
        this.backup = j;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public ArrayList<Integer> getPortList() {
        return this.portList;
    }

    public void setPortList(ArrayList<Integer> arrayList) {
        this.portList = arrayList;
    }

    public ArrayList<Long> getSpeedTestIpList() {
        return this.speedTestIpList;
    }

    public void setSpeedTestIpList(ArrayList<Long> arrayList) {
        this.speedTestIpList = arrayList;
    }

    public ApList() {
    }

    public ApList(Map<Byte, Long> map, Map<Byte, Long> map2, long j, String str, ArrayList<Integer> arrayList, ArrayList<Long> arrayList2) {
        this.primary = map;
        this.secondary = map2;
        this.backup = j;
        this.domain = str;
        this.portList = arrayList;
        this.speedTestIpList = arrayList2;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        ApList apList = (ApList) obj;
        if (JceUtil.equals((Object) this.primary, (Object) apList.primary) && JceUtil.equals((Object) this.secondary, (Object) apList.secondary) && JceUtil.equals(this.backup, apList.backup) && JceUtil.equals((Object) this.domain, (Object) apList.domain) && JceUtil.equals((Object) this.portList, (Object) apList.portList) && JceUtil.equals((Object) this.speedTestIpList, (Object) apList.speedTestIpList)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.primary, 0);
        jceOutputStream.write(this.secondary, 1);
        jceOutputStream.write(this.backup, 2);
        jceOutputStream.write(this.domain, 3);
        jceOutputStream.write((Collection<T>) this.portList, 4);
        jceOutputStream.write((Collection<T>) this.speedTestIpList, 5);
    }

    static {
        cache_primary.put(Byte.valueOf(0), Long.valueOf(0));
        cache_secondary.put(Byte.valueOf(0), Long.valueOf(0));
        cache_portList.add(Integer.valueOf(0));
        cache_speedTestIpList.add(Long.valueOf(0));
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.primary = (Map) jceInputStream.read(cache_primary, 0, true);
        this.secondary = (Map) jceInputStream.read(cache_secondary, 1, true);
        this.backup = jceInputStream.read(this.backup, 2, true);
        this.domain = jceInputStream.readString(3, true);
        this.portList = (ArrayList) jceInputStream.read(cache_portList, 4, true);
        this.speedTestIpList = (ArrayList) jceInputStream.read(cache_speedTestIpList, 5, true);
    }

    public void display(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.display(this.primary, "primary");
        jceDisplayer.display(this.secondary, "secondary");
        jceDisplayer.display(this.backup, "backup");
        jceDisplayer.display(this.domain, "domain");
        jceDisplayer.display((Collection<T>) this.portList, "portList");
        jceDisplayer.display((Collection<T>) this.speedTestIpList, "speedTestIpList");
    }

    public void displaySimple(StringBuilder sb, int i) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i);
        jceDisplayer.displaySimple(this.primary, true);
        jceDisplayer.displaySimple(this.secondary, true);
        jceDisplayer.displaySimple(this.backup, true);
        jceDisplayer.displaySimple(this.domain, true);
        jceDisplayer.displaySimple((Collection<T>) this.portList, true);
        jceDisplayer.displaySimple((Collection<T>) this.speedTestIpList, false);
    }
}
