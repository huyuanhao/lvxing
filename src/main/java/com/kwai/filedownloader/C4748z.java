package com.kwai.filedownloader;

import com.kwai.filedownloader.C4583a.C4585b;
import com.kwai.filedownloader.message.C4698e.C4700b;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.p358f.C4660d;
import java.util.List;

/* renamed from: com.kwai.filedownloader.z */
public class C4748z implements C4700b {
    /* renamed from: a */
    private boolean m19509a(List<C4585b> list, MessageSnapshot messageSnapshot) {
        if (list.size() > 1 && messageSnapshot.mo25286b() == -3) {
            for (C4585b G : list) {
                if (G.mo24936G().mo25034c(messageSnapshot)) {
                    return true;
                }
            }
        }
        for (C4585b G2 : list) {
            if (G2.mo24936G().mo25033b(messageSnapshot)) {
                return true;
            }
        }
        if (-4 == messageSnapshot.mo25286b()) {
            for (C4585b G3 : list) {
                if (G3.mo24936G().mo25036d(messageSnapshot)) {
                    return true;
                }
            }
        }
        if (list.size() == 1) {
            return ((C4585b) list.get(0)).mo24936G().mo25032a(messageSnapshot);
        }
        return false;
    }

    /* renamed from: a */
    public void mo25290a(MessageSnapshot messageSnapshot) {
        synchronized (Integer.toString(messageSnapshot.mo25278m()).intern()) {
            List<C4585b> b = C4666h.m19171a().mo25230b(messageSnapshot.mo25278m());
            if (b.size() > 0) {
                C4583a F = ((C4585b) b.get(0)).mo24935F();
                if (C4660d.f15179a) {
                    C4660d.m19123c(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(messageSnapshot.mo25278m()), Byte.valueOf(F.mo24929v()), Byte.valueOf(messageSnapshot.mo25286b()), Integer.valueOf(b.size()));
                }
                if (!m19509a(b, messageSnapshot)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("The event isn't consumed, id:");
                    sb.append(messageSnapshot.mo25278m());
                    sb.append(" status:");
                    sb.append(messageSnapshot.mo25286b());
                    sb.append(" task-count:");
                    sb.append(b.size());
                    StringBuilder sb2 = new StringBuilder(sb.toString());
                    for (C4585b bVar : b) {
                        sb2.append(" | ");
                        sb2.append(bVar.mo24935F().mo24929v());
                    }
                    C4660d.m19122b(this, sb2.toString(), new Object[0]);
                }
            } else {
                C4660d.m19122b(this, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(messageSnapshot.mo25286b()));
            }
        }
    }
}
