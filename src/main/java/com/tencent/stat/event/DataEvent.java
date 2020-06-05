package com.tencent.stat.event;

public class DataEvent extends FBIEvent {
    public EventType getType() {
        return EventType.DATA_EVENT;
    }
}
