package mtopsdk.network.domain;

import java.io.Serializable;
import mtopsdk.common.util.C8330d;

public class NetworkStats implements Serializable, Cloneable {
    private static final long serialVersionUID = -3538602124202475612L;
    public String connectionType;
    public long dataSpeed;
    public long firstDataTime;
    public String host;
    public String ip_port;
    public boolean isRequestSuccess = false;
    public boolean isSSL;
    public String netStatSum;
    public long oneWayTime_ANet;
    public long processTime;
    public long recDataTime;
    public long recvSize;
    public int resultCode = 0;
    public int retryTimes;
    public long sendSize;
    public long sendWaitTime;
    public long serverRT;

    public NetworkStats() {
        String str = "";
        this.connectionType = str;
        this.host = str;
        this.ip_port = str;
        this.isSSL = false;
        this.oneWayTime_ANet = 0;
        this.sendWaitTime = 0;
        this.firstDataTime = 0;
        this.recDataTime = 0;
        this.processTime = 0;
        this.serverRT = 0;
        this.sendSize = 0;
        this.recvSize = 0;
        this.dataSpeed = 0;
    }

    public String sumNetStat() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("oneWayTime_ANet=");
        sb.append(this.oneWayTime_ANet);
        sb.append(",resultCode=");
        sb.append(this.resultCode);
        sb.append(",isRequestSuccess=");
        sb.append(this.isRequestSuccess);
        sb.append(",host=");
        sb.append(this.host);
        sb.append(",ip_port=");
        sb.append(this.ip_port);
        sb.append(",isSSL=");
        sb.append(this.isSSL);
        sb.append(",connType=");
        sb.append(this.connectionType);
        sb.append(",processTime=");
        sb.append(this.processTime);
        sb.append(",firstDataTime=");
        sb.append(this.firstDataTime);
        sb.append(",recDataTime=");
        sb.append(this.recDataTime);
        sb.append(",sendWaitTime=");
        sb.append(this.sendWaitTime);
        sb.append(",serverRT=");
        sb.append(this.serverRT);
        sb.append(",sendSize=");
        sb.append(this.sendSize);
        sb.append(",recvSize=");
        sb.append(this.recvSize);
        sb.append(",dataSpeed=");
        sb.append(this.dataSpeed);
        sb.append(",retryTimes=");
        sb.append(this.retryTimes);
        return sb.toString();
    }

    public String toString() {
        if (C8330d.m35525b(this.netStatSum)) {
            this.netStatSum = sumNetStat();
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("NetworkStats [");
        sb.append(this.netStatSum);
        sb.append("]");
        return sb.toString();
    }
}
