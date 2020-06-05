package com.kwai.filedownloader;

import com.kwai.filedownloader.C4583a.C4585b;
import com.kwai.filedownloader.C4583a.C4587d;
import com.kwai.filedownloader.C4743w.C4744a;
import com.kwai.filedownloader.message.C4683a;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.p356d.C4623d;
import com.kwai.filedownloader.p358f.C4660d;
import com.kwai.filedownloader.p358f.C4664f;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.kwai.filedownloader.k */
class C4674k implements C4728s {
    /* renamed from: a */
    private C4585b f15206a;
    /* renamed from: b */
    private C4587d f15207b;
    /* renamed from: c */
    private Queue<MessageSnapshot> f15208c;
    /* renamed from: d */
    private boolean f15209d = false;

    C4674k(C4585b bVar, C4587d dVar) {
        m19204b(bVar, dVar);
    }

    /* renamed from: a */
    private void m19203a(int i) {
        if (C4623d.m18946a(i)) {
            if (!this.f15208c.isEmpty()) {
                MessageSnapshot messageSnapshot = (MessageSnapshot) this.f15208c.peek();
                C4660d.m19124d(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(messageSnapshot.mo25278m()), Integer.valueOf(this.f15208c.size()), Byte.valueOf(messageSnapshot.mo25286b()));
            }
            this.f15206a = null;
        }
    }

    /* renamed from: b */
    private void m19204b(C4585b bVar, C4587d dVar) {
        this.f15206a = bVar;
        this.f15207b = dVar;
        this.f15208c = new LinkedBlockingQueue();
    }

    /* renamed from: k */
    private void m19205k(MessageSnapshot messageSnapshot) {
        C4585b bVar = this.f15206a;
        if (bVar == null) {
            if (C4660d.f15179a) {
                C4660d.m19123c(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.mo25278m()), Byte.valueOf(messageSnapshot.mo25286b()));
            }
            return;
        }
        if (this.f15209d || bVar.mo24935F().mo24923p() == null) {
            if ((C4675l.m19223b() || this.f15206a.mo24944O()) && messageSnapshot.mo25286b() == 4) {
                this.f15207b.mo24948c();
            }
            m19203a((int) messageSnapshot.mo25286b());
        } else {
            this.f15208c.offer(messageSnapshot);
            C4670j.m19193a().mo25236a((C4728s) this);
        }
    }

    /* renamed from: a */
    public void mo25240a(C4585b bVar, C4587d dVar) {
        if (this.f15206a == null) {
            m19204b(bVar, dVar);
        } else {
            throw new IllegalStateException(C4664f.m19135a("the messenger is working, can't re-appointment for %s", bVar));
        }
    }

    /* renamed from: a */
    public void mo25241a(MessageSnapshot messageSnapshot) {
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "notify pending %s", this.f15206a);
        }
        this.f15207b.mo24949e_();
        m19205k(messageSnapshot);
    }

    /* renamed from: a */
    public boolean mo25242a() {
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "notify begin %s", this.f15206a);
        }
        if (this.f15206a == null) {
            C4660d.m19124d(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.f15208c.size()));
            return false;
        }
        this.f15207b.mo24947a();
        return true;
    }

    /* renamed from: b */
    public void mo25243b() {
        if (!this.f15209d) {
            MessageSnapshot messageSnapshot = (MessageSnapshot) this.f15208c.poll();
            byte b = messageSnapshot.mo25286b();
            C4585b bVar = this.f15206a;
            if (bVar != null) {
                C4583a F = bVar.mo24935F();
                C4669i p = F.mo24923p();
                C4744a G = bVar.mo24936G();
                m19203a((int) b);
                if (p != null && !p.mo25235a()) {
                    if (b == 4) {
                        try {
                            p.mo22682b(F);
                            mo25255j(((C4683a) messageSnapshot).mo25287f_());
                        } catch (Throwable th) {
                            mo25253h(G.mo25030a(th));
                        }
                    } else {
                        C4665g gVar = null;
                        if (p instanceof C4665g) {
                            gVar = (C4665g) p;
                        }
                        if (b == -4) {
                            p.mo22686d(F);
                        } else if (b == -3) {
                            p.mo22684c(F);
                        } else if (b != -2) {
                            if (b == -1) {
                                p.mo22681a(F, messageSnapshot.mo25276j());
                            } else if (b != 1) {
                                if (b == 2) {
                                    String h = messageSnapshot.mo25274h();
                                    boolean g = messageSnapshot.mo25273g();
                                    if (gVar != null) {
                                        gVar.mo25221a(F, h, g, F.mo24925r(), messageSnapshot.mo25269d());
                                    } else {
                                        p.mo22680a(F, h, g, F.mo24924q(), messageSnapshot.mo25268c());
                                    }
                                } else if (b != 3) {
                                    if (b != 5) {
                                        if (b == 6) {
                                            p.mo22678a(F);
                                        }
                                    } else if (gVar != null) {
                                        gVar.mo25222a(F, messageSnapshot.mo25276j(), messageSnapshot.mo25277k(), messageSnapshot.mo25275i());
                                    } else {
                                        p.mo25234a(F, messageSnapshot.mo25276j(), messageSnapshot.mo25277k(), messageSnapshot.mo25267a());
                                    }
                                } else if (gVar != null) {
                                    gVar.mo25223b(F, messageSnapshot.mo25275i(), F.mo24927t());
                                } else {
                                    p.mo22683b(F, messageSnapshot.mo25267a(), F.mo24926s());
                                }
                            } else if (gVar != null) {
                                gVar.mo25220a(F, messageSnapshot.mo25275i(), messageSnapshot.mo25269d());
                            } else {
                                p.mo22679a(F, messageSnapshot.mo25267a(), messageSnapshot.mo25268c());
                            }
                        } else if (gVar != null) {
                            gVar.mo25224c(F, messageSnapshot.mo25275i(), messageSnapshot.mo25269d());
                        } else {
                            p.mo22685c(F, messageSnapshot.mo25267a(), messageSnapshot.mo25268c());
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public void mo25244b(MessageSnapshot messageSnapshot) {
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "notify started %s", this.f15206a);
        }
        this.f15207b.mo24949e_();
        m19205k(messageSnapshot);
    }

    /* renamed from: c */
    public void mo25245c(MessageSnapshot messageSnapshot) {
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "notify connected %s", this.f15206a);
        }
        this.f15207b.mo24949e_();
        m19205k(messageSnapshot);
    }

    /* renamed from: c */
    public boolean mo25246c() {
        return this.f15206a.mo24935F().mo24896C();
    }

    /* renamed from: d */
    public void mo25247d(MessageSnapshot messageSnapshot) {
        C4583a F = this.f15206a.mo24935F();
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "notify progress %s %d %d", F, Long.valueOf(F.mo24925r()), Long.valueOf(F.mo24927t()));
        }
        if (F.mo24917j() <= 0) {
            if (C4660d.f15179a) {
                C4660d.m19123c(this, "notify progress but client not request notify %s", this.f15206a);
            }
            return;
        }
        this.f15207b.mo24949e_();
        m19205k(messageSnapshot);
    }

    /* renamed from: d */
    public boolean mo25248d() {
        return ((MessageSnapshot) this.f15208c.peek()).mo25286b() == 4;
    }

    /* renamed from: e */
    public void mo25249e() {
        this.f15209d = true;
    }

    /* renamed from: e */
    public void mo25250e(MessageSnapshot messageSnapshot) {
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "notify block completed %s %s", this.f15206a, Thread.currentThread().getName());
        }
        this.f15207b.mo24949e_();
        m19205k(messageSnapshot);
    }

    /* renamed from: f */
    public void mo25251f(MessageSnapshot messageSnapshot) {
        if (C4660d.f15179a) {
            C4583a F = this.f15206a.mo24935F();
            C4660d.m19123c(this, "notify retry %s %d %d %s", this.f15206a, Integer.valueOf(F.mo24894A()), Integer.valueOf(F.mo24895B()), F.mo24932y());
        }
        this.f15207b.mo24949e_();
        m19205k(messageSnapshot);
    }

    /* renamed from: g */
    public void mo25252g(MessageSnapshot messageSnapshot) {
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "notify warn %s", this.f15206a);
        }
        this.f15207b.mo24948c();
        m19205k(messageSnapshot);
    }

    /* renamed from: h */
    public void mo25253h(MessageSnapshot messageSnapshot) {
        if (C4660d.f15179a) {
            C4585b bVar = this.f15206a;
            C4660d.m19123c(this, "notify error %s %s", bVar, bVar.mo24935F().mo24932y());
        }
        this.f15207b.mo24948c();
        m19205k(messageSnapshot);
    }

    /* renamed from: i */
    public void mo25254i(MessageSnapshot messageSnapshot) {
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "notify paused %s", this.f15206a);
        }
        this.f15207b.mo24948c();
        m19205k(messageSnapshot);
    }

    /* renamed from: j */
    public void mo25255j(MessageSnapshot messageSnapshot) {
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "notify completed %s", this.f15206a);
        }
        this.f15207b.mo24948c();
        m19205k(messageSnapshot);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        C4585b bVar = this.f15206a;
        objArr[0] = Integer.valueOf(bVar == null ? -1 : bVar.mo24935F().mo24915h());
        objArr[1] = super.toString();
        return C4664f.m19135a("%d:%s", objArr);
    }
}
