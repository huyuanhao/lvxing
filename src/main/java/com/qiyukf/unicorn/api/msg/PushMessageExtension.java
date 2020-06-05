package com.qiyukf.unicorn.api.msg;

import java.io.Serializable;

public class PushMessageExtension implements Serializable {
    private Action action;
    private Sender sender;

    /* renamed from: com.qiyukf.unicorn.api.msg.PushMessageExtension$Action */
    public static class Action implements Serializable {
        private String label;
        private String url;

        public String getLabel() {
            return this.label;
        }

        public String getUrl() {
            return this.url;
        }

        public void setLabel(String str) {
            this.label = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    /* renamed from: com.qiyukf.unicorn.api.msg.PushMessageExtension$Sender */
    public static class Sender implements Serializable {
        private String avatar;
        /* renamed from: id */
        private String f18815id;
        private String name;

        public String getAvatar() {
            return this.avatar;
        }

        public String getId() {
            return this.f18815id;
        }

        public String getName() {
            return this.name;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public void setId(String str) {
            this.f18815id = str;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    public Action getAction() {
        return this.action;
    }

    public Sender getSender() {
        return this.sender;
    }

    public void setAction(Action action2) {
        this.action = action2;
    }

    public void setSender(Sender sender2) {
        this.sender = sender2;
    }
}
