package com.qiyukf.nimlib.sdk.msg;

import com.qiyukf.nimlib.sdk.AbortableFuture;
import com.qiyukf.nimlib.sdk.InvocationFuture;
import com.qiyukf.nimlib.sdk.msg.attachment.MsgAttachmentParser;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.nimlib.sdk.msg.model.QueryDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.model.RecentContact;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import java.util.List;

public interface MsgService {
    public static final String MSG_CHATTING_ACCOUNT_ALL = "all";
    public static final String MSG_CHATTING_ACCOUNT_NONE = null;

    void clearChattingHistory(String str, SessionTypeEnum sessionTypeEnum);

    void clearMsgDatabase(boolean z);

    void clearUnreadCount(String str, SessionTypeEnum sessionTypeEnum);

    void deleteChattingHistory(IMMessage iMMessage);

    void deleteRecentContact(RecentContact recentContact);

    void deleteRecentContact2(String str, SessionTypeEnum sessionTypeEnum);

    AbortableFuture<Void> downloadAttachment(IMMessage iMMessage, boolean z);

    void migrateMessages(String str, String str2, boolean z);

    InvocationFuture<List<IMMessage>> pullMessageHistory(IMMessage iMMessage, int i, boolean z);

    InvocationFuture<List<IMMessage>> pullMessageHistoryEx(IMMessage iMMessage, long j, int i, QueryDirectionEnum queryDirectionEnum, boolean z);

    IMMessage queryLastMessage(String str, SessionTypeEnum sessionTypeEnum);

    InvocationFuture<List<IMMessage>> queryMessageList(String str, SessionTypeEnum sessionTypeEnum, long j, int i);

    InvocationFuture<List<IMMessage>> queryMessageListEx(IMMessage iMMessage, QueryDirectionEnum queryDirectionEnum, int i, boolean z);

    InvocationFuture<List<RecentContact>> queryRecentContacts();

    List<RecentContact> queryRecentContactsBlock();

    void registerCustomAttachmentParser(MsgTypeEnum msgTypeEnum, MsgAttachmentParser msgAttachmentParser);

    InvocationFuture<Void> saveMessageToLocal(IMMessage iMMessage, boolean z);

    InvocationFuture<List<IMMessage>> searchMessageHistory(String str, List<String> list, IMMessage iMMessage, int i);

    InvocationFuture<Void> sendCustomNotification(CustomNotification customNotification);

    AbortableFuture<FileAttachment> sendFile(FileAttachment fileAttachment);

    InvocationFuture<Void> sendImportantNotification(CustomNotification customNotification);

    InvocationFuture<Void> sendMessage(IMMessage iMMessage, boolean z, boolean z2);

    void setChattingAccount(String str, SessionTypeEnum sessionTypeEnum);

    AbortableFuture<String> transVoiceToText(String str, String str2, long j);

    void updateIMMessageStatus(IMMessage iMMessage, boolean z);

    void updateMessage(IMMessage iMMessage, boolean z);

    InvocationFuture<Void> updateRecent(RecentContact recentContact);
}
