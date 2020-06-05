package mtopsdk.xstate;

public enum NetworkClassEnum {
    NET_WIFI("WIFI"),
    NET_2G("2G"),
    NET_3G("3G"),
    NET_4G("4G"),
    NET_UNKONWN("UNKONWN"),
    NET_NO(r7),
    NET_ETHERNET(r8);
    
    private String netClass;

    public final String getNetClass() {
        return this.netClass;
    }

    private NetworkClassEnum(String str) {
        this.netClass = str;
    }
}
