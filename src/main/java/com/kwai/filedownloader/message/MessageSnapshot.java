package com.kwai.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.kwai.filedownloader.message.C4687d.C4689b;
import com.kwai.filedownloader.message.C4687d.C4690c;
import com.kwai.filedownloader.message.C4687d.C4691d;
import com.kwai.filedownloader.message.C4687d.C4693f;
import com.kwai.filedownloader.message.C4687d.C4694g;
import com.kwai.filedownloader.message.C4687d.C4695h;
import com.kwai.filedownloader.message.C4687d.C4697j;
import com.kwai.filedownloader.message.C4705h.C4707b;
import com.kwai.filedownloader.message.C4705h.C4708c;
import com.kwai.filedownloader.message.C4705h.C4709d;
import com.kwai.filedownloader.message.C4705h.C4711f;
import com.kwai.filedownloader.message.C4705h.C4712g;
import com.kwai.filedownloader.message.C4705h.C4713h;
import com.kwai.filedownloader.message.C4705h.C4715j;
import com.kwai.filedownloader.p358f.C4664f;

public abstract class MessageSnapshot implements Parcelable, C4686c {
    public static final Creator<MessageSnapshot> CREATOR = new Creator<MessageSnapshot>() {
        /* renamed from: a */
        public MessageSnapshot createFromParcel(Parcel parcel) {
            boolean z = parcel.readByte() == 1;
            byte readByte = parcel.readByte();
            MessageSnapshot messageSnapshot = readByte != -4 ? readByte != -3 ? readByte != -1 ? readByte != 1 ? readByte != 2 ? readByte != 3 ? readByte != 5 ? readByte != 6 ? null : new C4682b(parcel) : z ? new C4695h(parcel) : new C4713h(parcel) : z ? new C4694g(parcel) : new C4712g(parcel) : z ? new C4690c(parcel) : new C4708c(parcel) : z ? new C4693f(parcel) : new C4711f(parcel) : z ? new C4691d(parcel) : new C4709d(parcel) : z ? new C4689b(parcel) : new C4707b(parcel) : z ? new C4697j(parcel) : new C4715j(parcel);
            if (messageSnapshot != null) {
                messageSnapshot.f15213a = z;
                return messageSnapshot;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Can't restore the snapshot because unknown status: ");
            sb.append(readByte);
            throw new IllegalStateException(sb.toString());
        }

        /* renamed from: a */
        public MessageSnapshot[] newArray(int i) {
            return new MessageSnapshot[i];
        }
    };
    /* renamed from: a */
    protected boolean f15213a;
    /* renamed from: b */
    private final int f15214b;

    /* renamed from: com.kwai.filedownloader.message.MessageSnapshot$NoFieldException */
    public static class NoFieldException extends IllegalStateException {
        NoFieldException(String str, MessageSnapshot messageSnapshot) {
            super(C4664f.m19135a("There isn't a field for '%s' in this message %d %d %s", str, Integer.valueOf(messageSnapshot.mo25278m()), Byte.valueOf(messageSnapshot.mo25286b()), messageSnapshot.getClass().getName()));
        }
    }

    /* renamed from: com.kwai.filedownloader.message.MessageSnapshot$a */
    public interface C4681a {
        /* renamed from: l */
        MessageSnapshot mo25285l();
    }

    /* renamed from: com.kwai.filedownloader.message.MessageSnapshot$b */
    public static class C4682b extends MessageSnapshot {
        C4682b(int i) {
            super(i);
        }

        C4682b(Parcel parcel) {
            super(parcel);
        }

        /* renamed from: b */
        public byte mo25286b() {
            return 6;
        }
    }

    MessageSnapshot(int i) {
        this.f15214b = i;
    }

    MessageSnapshot(Parcel parcel) {
        this.f15214b = parcel.readInt();
    }

    /* renamed from: a */
    public int mo25267a() {
        throw new NoFieldException("getSmallSofarBytes", this);
    }

    /* renamed from: c */
    public int mo25268c() {
        throw new NoFieldException("getSmallTotalBytes", this);
    }

    /* renamed from: d */
    public long mo25269d() {
        throw new NoFieldException("getLargeTotalBytes", this);
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public boolean mo25271e() {
        throw new NoFieldException("isReusedDownloadedFile", this);
    }

    /* renamed from: f */
    public String mo25272f() {
        throw new NoFieldException("getFileName", this);
    }

    /* renamed from: g */
    public boolean mo25273g() {
        throw new NoFieldException("isResuming", this);
    }

    /* renamed from: h */
    public String mo25274h() {
        throw new NoFieldException("getEtag", this);
    }

    /* renamed from: i */
    public long mo25275i() {
        throw new NoFieldException("getLargeSofarBytes", this);
    }

    /* renamed from: j */
    public Throwable mo25276j() {
        throw new NoFieldException("getThrowable", this);
    }

    /* renamed from: k */
    public int mo25277k() {
        throw new NoFieldException("getRetryingTimes", this);
    }

    /* renamed from: m */
    public int mo25278m() {
        return this.f15214b;
    }

    /* renamed from: n */
    public boolean mo25279n() {
        return this.f15213a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f15213a ? (byte) 1 : 0);
        parcel.writeByte(mo25286b());
        parcel.writeInt(this.f15214b);
    }
}
