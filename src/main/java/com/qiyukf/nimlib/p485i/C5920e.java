package com.qiyukf.nimlib.p485i;

import android.util.SparseArray;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nimlib.sdk.msg.attachment.LocationAttachment;
import com.qiyukf.nimlib.sdk.msg.attachment.MsgAttachmentParser;
import com.qiyukf.nimlib.sdk.msg.attachment.VideoAttachment;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.AudioAttachment;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import com.qiyukf.unicorn.api.msg.attachment.ImageAttachment;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;

/* renamed from: com.qiyukf.nimlib.i.e */
public final class C5920e {
    /* renamed from: a */
    private SparseArray<MsgAttachmentParser> f18715a = new SparseArray<>();

    /* renamed from: com.qiyukf.nimlib.i.e$a */
    private static class C5921a implements MsgAttachmentParser {
        /* renamed from: a */
        private int f18716a;

        C5921a(int i) {
            this.f18716a = i;
        }

        public final MsgAttachment parse(String str) {
            int i = this.f18716a;
            if (i == 1) {
                return new ImageAttachment(str);
            }
            if (i == 2) {
                return new AudioAttachment(str);
            }
            if (i == 3) {
                return new VideoAttachment(str);
            }
            if (i == 4) {
                return new LocationAttachment(str);
            }
            if (i != 6) {
                return null;
            }
            return new FileAttachment(str);
        }
    }

    public C5920e() {
        m23737a(MsgTypeEnum.image.getValue());
        m23737a(MsgTypeEnum.audio.getValue());
        m23737a(MsgTypeEnum.video.getValue());
        m23737a(MsgTypeEnum.location.getValue());
        m23737a(MsgTypeEnum.file.getValue());
    }

    /* renamed from: a */
    private void m23737a(int i) {
        mo28334a(i, (MsgAttachmentParser) new C5921a(i));
    }

    /* renamed from: a */
    public final MsgAttachment mo28333a(int i, String str) {
        MsgAttachmentParser msgAttachmentParser;
        synchronized (this.f18715a) {
            msgAttachmentParser = (MsgAttachmentParser) this.f18715a.get(i);
        }
        if (msgAttachmentParser != null) {
            try {
                return msgAttachmentParser.parse(str);
            } catch (Exception e) {
                C5264a.m21621b("MsgAttachmentCreator", "create is error", e);
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void mo28334a(int i, MsgAttachmentParser msgAttachmentParser) {
        synchronized (this.f18715a) {
            this.f18715a.put(i, msgAttachmentParser);
        }
    }
}
