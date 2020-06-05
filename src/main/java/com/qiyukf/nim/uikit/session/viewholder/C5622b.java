package com.qiyukf.nim.uikit.session.viewholder;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qiyukf.nim.uikit.C5433b;
import com.qiyukf.nim.uikit.common.p419a.C5439f;
import com.qiyukf.nim.uikit.common.p424ui.imageview.HeadImageView;
import com.qiyukf.nim.uikit.session.module.p427a.C5588c;
import com.qiyukf.nim.uikit.session.module.p427a.C5588c.C5590a;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import com.qiyukf.unicorn.p516j.C6220g;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.qiyukf.nim.uikit.session.viewholder.b */
public abstract class C5622b extends C5439f {
    protected View alertButton;
    private HeadImageView avatarLeft;
    private HeadImageView avatarRight;
    protected MsgContainerLayout contentContainer;
    private View ivTrashIcon;
    protected OnLongClickListener longClickListener;
    protected IMMessage message;
    protected TextView nameTextView;
    protected ProgressBar progressBar;
    protected TextView timeTextView;
    private TextView tvMessageItemReadStatus;
    private TextView tvTrashTips;

    /* renamed from: com.qiyukf.nim.uikit.session.viewholder.b$6 */
    static /* synthetic */ class C56286 {
        /* renamed from: a */
        static final /* synthetic */ int[] f18124a = new int[MsgStatusEnum.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
            com.qiyukf.unicorn.api.msg.MsgStatusEnum[] r0 = com.qiyukf.unicorn.api.msg.MsgStatusEnum.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f18124a = r0
            int[] r0 = f18124a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.qiyukf.unicorn.api.msg.MsgStatusEnum r1 = com.qiyukf.unicorn.api.msg.MsgStatusEnum.fail     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f18124a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.qiyukf.unicorn.api.msg.MsgStatusEnum r1 = com.qiyukf.unicorn.api.msg.MsgStatusEnum.sending     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f18124a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.qiyukf.unicorn.api.msg.MsgStatusEnum r1 = com.qiyukf.unicorn.api.msg.MsgStatusEnum.read     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f18124a     // Catch:{ NoSuchFieldError -> 0x0035 }
            com.qiyukf.unicorn.api.msg.MsgStatusEnum r1 = com.qiyukf.unicorn.api.msg.MsgStatusEnum.unread     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.session.viewholder.C5622b.C56286.m49809clinit():void");
        }
    }

    private void setContent() {
        LinearLayout linearLayout = (LinearLayout) this.view.findViewById(C5961R.C5963id.ysf_message_item_body);
        int childCount = isReceivedMessage() ? 0 : linearLayout.getChildCount() - 1;
        View childAt = linearLayout.getChildAt(childCount);
        MsgContainerLayout msgContainerLayout = this.contentContainer;
        if (childAt != msgContainerLayout) {
            linearLayout.removeView(msgContainerLayout);
            linearLayout.addView(this.contentContainer, childCount);
        }
        if (isMiddleItem()) {
            setGravity(linearLayout, 17);
        } else if (isReceivedMessage()) {
            setGravity(linearLayout, 3);
            this.contentContainer.setBackgroundResource(leftBackground());
        } else {
            setGravity(linearLayout, 5);
            this.contentContainer.setBackgroundResource(rightBackground());
        }
    }

    private void setHeadImageView() {
        HeadImageView headImageView = isReceivedMessage() ? this.avatarLeft : this.avatarRight;
        HeadImageView headImageView2 = isReceivedMessage() ? this.avatarRight : this.avatarLeft;
        if (!showAvatar()) {
            headImageView.setVisibility(8);
        } else {
            headImageView.setVisibility(0);
            String fromAccount = this.message.getFromAccount();
            this.message.getUuid();
            headImageView.mo27537a(fromAccount);
        }
        headImageView2.setVisibility(8);
    }

    private void setLongClickListener() {
        this.longClickListener = new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                if (C5622b.this.onItemLongClick() || C5622b.this.getAdapter().mo27734d() == null) {
                    return false;
                }
                C5590a d = C5622b.this.getAdapter().mo27734d();
                C5622b.this.view;
                d.mo27725b(C5622b.this.message);
                return true;
            }
        };
        this.contentContainer.setOnLongClickListener(this.longClickListener);
        if (C5433b.m22193c() != null) {
            C56275 r0 = new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    C5622b.this.context;
                    return true;
                }
            };
            this.avatarLeft.setOnLongClickListener(r0);
            this.avatarRight.setOnLongClickListener(r0);
        }
    }

    private void setNameTextView() {
        this.nameTextView.setVisibility(8);
    }

    private void setOnClickListener() {
        if (getAdapter().mo27734d() != null) {
            this.alertButton.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    C5622b.this.getAdapter().mo27734d().mo27722a(C5622b.this.message);
                }
            });
        }
        this.contentContainer.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                C5622b.this.onItemClick();
            }
        });
        if (C5433b.m22193c() != null) {
            C56253 r0 = new OnClickListener() {
                public final void onClick(View view) {
                    C5622b.this.context;
                }
            };
            this.avatarLeft.setOnClickListener(r0);
            this.avatarRight.setOnClickListener(r0);
        }
    }

    private void setTimeTextView() {
        String str;
        if (getAdapter().mo27733c(this.message)) {
            boolean z = false;
            this.timeTextView.setVisibility(0);
            Date date = new Date(this.message.getTime());
            Date date2 = new Date();
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            Date time = instance.getTime();
            Date date3 = new Date(time.getTime() - 86400000);
            Date date4 = new Date(date3.getTime() - 86400000);
            if (!date.before(time)) {
                str = "今天";
            } else if (!date.before(date3)) {
                str = "昨天";
            } else if (!date.before(date4)) {
                str = "前天";
            } else {
                Calendar instance2 = Calendar.getInstance();
                Calendar instance3 = Calendar.getInstance();
                instance2.setTime(date);
                instance3.setTime(date2);
                int i = instance2.get(1) - instance3.get(1);
                if (i != 0 ? !(!(1 == i && 11 == instance3.get(2)) ? -1 == i && 11 == instance2.get(2) && instance2.get(3) == instance3.get(3) : instance2.get(3) == instance3.get(3)) : instance2.get(3) == instance3.get(3)) {
                    z = true;
                }
                if (z) {
                    String[] strArr = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
                    Calendar instance4 = Calendar.getInstance();
                    instance4.setTime(date);
                    str = strArr[instance4.get(7) - 1];
                } else {
                    str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date);
                }
            }
            String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(date);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" ");
            sb.append(format);
            this.timeTextView.setText(sb.toString());
            return;
        }
        this.timeTextView.setVisibility(8);
    }

    private void setTrashTips() {
        String a = C6220g.m24654a(this.message);
        int i = 0;
        this.ivTrashIcon.setVisibility(TextUtils.isEmpty(a) ? 8 : 0);
        TextView textView = this.tvTrashTips;
        if (TextUtils.isEmpty(a)) {
            i = 8;
        }
        textView.setVisibility(i);
        this.tvTrashTips.setText(a);
        if (!TextUtils.isEmpty(a)) {
            this.tvMessageItemReadStatus.setVisibility(8);
        }
    }

    private void uiCustomize() {
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        if (uICustomization != null) {
            this.avatarLeft.mo27550a(uICustomization.avatarShape);
            this.avatarRight.mo27550a(uICustomization.avatarShape);
            if (uICustomization.hideLeftAvatar) {
                this.avatarLeft.setVisibility(8);
            }
            if (uICustomization.hideRightAvatar) {
                this.avatarRight.setVisibility(8);
            }
            if (uICustomization.tipsTextSize > 0.0f) {
                this.timeTextView.setTextSize(uICustomization.tipsTextSize);
            }
            if (uICustomization.tipsTextColor != 0) {
                this.timeTextView.setTextColor(uICustomization.tipsTextColor);
            }
        }
    }

    public abstract void bindContentView();

    /* access modifiers changed from: protected */
    public void downloadAttachment() {
        if (this.message.getAttachment() != null && (this.message.getAttachment() instanceof FileAttachment)) {
            ((MsgService) NIMClient.getService(MsgService.class)).downloadAttachment(this.message, true);
        }
    }

    /* access modifiers changed from: protected */
    public <T extends View> T findViewById(int i) {
        return this.view.findViewById(i);
    }

    /* access modifiers changed from: protected|final */
    public final C5588c getAdapter() {
        return (C5588c) this.adapter;
    }

    public abstract int getContentResId();

    /* access modifiers changed from: protected|final */
    public final int getResId() {
        return C5961R.C5964layout.ysf_message_item;
    }

    /* access modifiers changed from: protected|final */
    public final void inflate() {
        this.timeTextView = (TextView) findViewById(C5961R.C5963id.ysf_message_item_time);
        this.avatarLeft = (HeadImageView) findViewById(C5961R.C5963id.ysf_message_item_portrait_left);
        this.avatarRight = (HeadImageView) findViewById(C5961R.C5963id.ysf_message_item_portrait_right);
        this.alertButton = findViewById(C5961R.C5963id.ysf_message_item_alert);
        this.progressBar = (ProgressBar) findViewById(C5961R.C5963id.ysf_message_item_progress);
        this.nameTextView = (TextView) findViewById(C5961R.C5963id.ysf_message_item_nickname);
        this.contentContainer = (MsgContainerLayout) findViewById(C5961R.C5963id.ysf_message_item_content);
        this.contentContainer.mo27798a(this);
        this.ivTrashIcon = findViewById(C5961R.C5963id.ysf_message_item_trash_icon);
        this.tvTrashTips = (TextView) findViewById(C5961R.C5963id.ysf_message_item_trash_tips);
        this.tvMessageItemReadStatus = (TextView) findViewById(C5961R.C5963id.tv_message_item_read_status);
        View.inflate(this.view.getContext(), getContentResId(), this.contentContainer);
        inflateContentView();
    }

    public abstract void inflateContentView();

    /* access modifiers changed from: protected */
    public boolean isMiddleItem() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isReceivedMessage() {
        return this.message.getDirect() == MsgDirectionEnum.In;
    }

    /* access modifiers changed from: protected */
    public int leftBackground() {
        return C5961R.C5962drawable.ysf_message_left_bg_selector;
    }

    public void onDetached() {
    }

    /* access modifiers changed from: protected */
    public void onItemClick() {
    }

    /* access modifiers changed from: protected */
    public boolean onItemLongClick() {
        return false;
    }

    /* access modifiers changed from: protected|final */
    public final void refresh(Object obj) {
        this.message = (IMMessage) obj;
        setHeadImageView();
        setNameTextView();
        setTimeTextView();
        setStatus();
        setOnClickListener();
        setLongClickListener();
        setContent();
        setOnClickListener();
        setTrashTips();
        uiCustomize();
        bindContentView();
    }

    public void refreshCurrentItem() {
        IMMessage iMMessage = this.message;
        if (iMMessage != null) {
            refresh(iMMessage);
        }
    }

    /* access modifiers changed from: protected */
    public int rightBackground() {
        return C5961R.C5962drawable.ysf_message_right_bg_selector;
    }

    /* access modifiers changed from: protected|final */
    public final void setGravity(View view, int i) {
        ((LayoutParams) view.getLayoutParams()).gravity = i;
    }

    /* access modifiers changed from: protected|varargs */
    public void setLayoutParams(int i, int i2, View... viewArr) {
        for (View view : viewArr) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public void setStatus() {
        int i = C56286.f18124a[this.message.getStatus().ordinal()];
        if (i == 1) {
            this.progressBar.setVisibility(8);
            this.alertButton.setVisibility(0);
            this.tvMessageItemReadStatus.setVisibility(8);
        } else if (i != 2) {
            String str = "1";
            if (i != 3) {
                if (i != 4) {
                    this.progressBar.setVisibility(8);
                    this.alertButton.setVisibility(8);
                    this.tvMessageItemReadStatus.setVisibility(8);
                } else if (C6029d.m24047g().mo29311m(this.message.getSessionId()) == null || !str.equals(C6029d.m24047g().mo29311m(this.message.getSessionId()).mo28880a())) {
                    this.progressBar.setVisibility(8);
                    this.alertButton.setVisibility(8);
                    this.tvMessageItemReadStatus.setVisibility(8);
                } else {
                    this.progressBar.setVisibility(8);
                    this.alertButton.setVisibility(8);
                    this.tvMessageItemReadStatus.setVisibility(0);
                    this.tvMessageItemReadStatus.setText("未读");
                    this.tvMessageItemReadStatus.setTextColor(Color.rgb(51, 136, 255));
                }
            } else if (C6029d.m24047g().mo29311m(this.message.getSessionId()) != null && str.equals(C6029d.m24047g().mo29311m(this.message.getSessionId()).mo28880a())) {
                this.progressBar.setVisibility(8);
                this.alertButton.setVisibility(8);
                this.tvMessageItemReadStatus.setVisibility(0);
                this.tvMessageItemReadStatus.setText("已读");
                this.tvMessageItemReadStatus.setTextColor(Color.rgb(177, 177, 177));
            }
        } else {
            this.progressBar.setVisibility(0);
            this.alertButton.setVisibility(8);
            this.tvMessageItemReadStatus.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public boolean showAvatar() {
        return true;
    }
}
