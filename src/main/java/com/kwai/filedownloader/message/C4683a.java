package com.kwai.filedownloader.message;

import com.kwai.filedownloader.p358f.C4664f;

/* renamed from: com.kwai.filedownloader.message.a */
public interface C4683a {

    /* renamed from: com.kwai.filedownloader.message.a$a */
    public static class C4684a extends MessageSnapshot implements C4683a {
        /* renamed from: b */
        private final MessageSnapshot f15215b;

        public C4684a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.mo25278m());
            if (messageSnapshot.mo25286b() == -3) {
                this.f15215b = messageSnapshot;
            } else {
                throw new IllegalArgumentException(C4664f.m19135a("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.mo25278m()), Byte.valueOf(messageSnapshot.mo25286b())));
            }
        }

        /* renamed from: b */
        public byte mo25286b() {
            return 4;
        }

        /* renamed from: f_ */
        public MessageSnapshot mo25287f_() {
            return this.f15215b;
        }
    }

    /* renamed from: f_ */
    MessageSnapshot mo25287f_();
}
