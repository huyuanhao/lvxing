package org.apache.thrift.server;

import org.apache.thrift.server.AbstractNonblockingServer.C8571a;
import org.slf4j.C8580b;
import org.slf4j.LoggerFactory;

public class TThreadedSelectorServer extends AbstractNonblockingServer {
    /* renamed from: a */
    private static final C8580b f29162a = LoggerFactory.m37316a(TThreadedSelectorServer.class.getName());

    /* renamed from: org.apache.thrift.server.TThreadedSelectorServer$Args */
    public static class Args extends C8571a<Args> {

        /* renamed from: org.apache.thrift.server.TThreadedSelectorServer$Args$AcceptPolicy */
        public enum AcceptPolicy {
            FAIR_ACCEPT,
            FAST_ACCEPT
        }
    }
}
