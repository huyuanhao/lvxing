package com.tencent.android.tpush.horse.data;

import android.text.format.Time;
import com.tencent.android.tpush.service.channel.exception.NullReturnException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class OptStrategyList implements Serializable {
    private static final long serialVersionUID = 4532907276158395575L;
    private StrategyItem httpItem;
    private StrategyItem httpRedirectItem;
    private StrategyItem tcpItem;
    private StrategyItem tcpRedirectItem;
    private long timestamp;

    public StrategyItem getTcpRedirectItem() {
        return this.tcpRedirectItem;
    }

    public void setTcpRedirectItem(StrategyItem strategyItem) {
        this.tcpRedirectItem = strategyItem;
    }

    public StrategyItem getTcpItem() {
        return this.tcpItem;
    }

    public void setTcpItem(StrategyItem strategyItem) {
        this.tcpItem = strategyItem;
    }

    public StrategyItem getHttpRedirectItem() {
        return this.httpRedirectItem;
    }

    public void setHttpRedirectItem(StrategyItem strategyItem) {
        this.httpRedirectItem = strategyItem;
    }

    public StrategyItem getHttpItem() {
        return this.httpItem;
    }

    public void setHttpItem(StrategyItem strategyItem) {
        this.httpItem = strategyItem;
    }

    public StrategyItem getOptStrategyItem() {
        StrategyItem strategyItem = this.tcpRedirectItem;
        if (strategyItem != null) {
            return strategyItem;
        }
        StrategyItem strategyItem2 = this.tcpItem;
        if (strategyItem2 != null) {
            return strategyItem2;
        }
        StrategyItem strategyItem3 = this.httpRedirectItem;
        if (strategyItem3 != null) {
            return strategyItem3;
        }
        StrategyItem strategyItem4 = this.httpItem;
        if (strategyItem4 != null) {
            return strategyItem4;
        }
        throw new NullReturnException("getOptStrategyItem return null,because the optstragegylist is empty");
    }

    public List<StrategyItem> getAllStrategyItems() {
        ArrayList arrayList = new ArrayList();
        StrategyItem strategyItem = this.tcpRedirectItem;
        if (strategyItem != null) {
            arrayList.add(strategyItem);
        }
        StrategyItem strategyItem2 = this.tcpItem;
        if (strategyItem2 != null) {
            arrayList.add(strategyItem2);
        }
        StrategyItem strategyItem3 = this.httpRedirectItem;
        if (strategyItem3 != null) {
            arrayList.add(strategyItem3);
        }
        StrategyItem strategyItem4 = this.httpItem;
        if (strategyItem4 != null) {
            arrayList.add(strategyItem4);
        }
        return arrayList;
    }

    public List<StrategyItem> getOptStrategyItems(short s) {
        ArrayList arrayList = new ArrayList();
        if (s == 1) {
            StrategyItem strategyItem = this.httpRedirectItem;
            if (strategyItem != null) {
                arrayList.add(strategyItem);
            }
            StrategyItem strategyItem2 = this.httpItem;
            if (strategyItem2 != null) {
                arrayList.add(strategyItem2);
            }
        } else {
            StrategyItem strategyItem3 = this.tcpRedirectItem;
            if (strategyItem3 != null) {
                arrayList.add(strategyItem3);
            }
            StrategyItem strategyItem4 = this.tcpItem;
            if (strategyItem4 != null) {
                arrayList.add(strategyItem4);
            }
        }
        return arrayList;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n------list start-----\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[TcpRedirectStrategyItem]:");
        StrategyItem strategyItem = this.tcpRedirectItem;
        sb2.append(strategyItem == null ? " tcpRedirect item is null" : strategyItem.toString());
        String str = "\n";
        sb2.append(str);
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("[TCPStrategyItem]:");
        StrategyItem strategyItem2 = this.tcpItem;
        sb3.append(strategyItem2 == null ? " tcp item is null" : strategyItem2.toString());
        sb3.append(str);
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("[HttpRedirectStrategyItem]:");
        StrategyItem strategyItem3 = this.httpRedirectItem;
        sb4.append(strategyItem3 == null ? " httpRedirect item is null" : strategyItem3.toString());
        sb4.append(str);
        sb.append(sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[HttpStrategyItem]:");
        StrategyItem strategyItem4 = this.httpItem;
        sb5.append(strategyItem4 == null ? " http item is null" : strategyItem4.toString());
        sb5.append(str);
        sb.append(sb5.toString());
        Time time = new Time();
        time.set(this.timestamp);
        StringBuilder sb6 = new StringBuilder();
        sb6.append(">>>saveTime=");
        sb6.append(time.format2445());
        sb6.append(">>>\n");
        sb.append(sb6.toString());
        sb.append("------list end-----\n");
        return sb.toString();
    }
}
