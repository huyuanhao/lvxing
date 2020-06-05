package com.qiyukf.nimlib.sdk.msg;

import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.msg.model.AttachmentProgress;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.nimlib.sdk.msg.model.RecentContact;
import java.util.List;

public interface MsgServiceObserve {
    void observeAttachmentProgress(Observer<AttachmentProgress> observer, boolean z);

    void observeCustomNotification(Observer<CustomNotification> observer, boolean z);

    void observeMsgStatus(Observer<IMMessage> observer, boolean z);

    void observeReceiveMessage(Observer<List<IMMessage>> observer, boolean z);

    void observeRecentContact(Observer<List<RecentContact>> observer, boolean z);

    void observeRecentContactDeleted(Observer<RecentContact> observer, boolean z);
}
