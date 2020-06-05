package mtopsdk.mtop.util;

import com.alibaba.fastjson.JSON;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;

/* renamed from: mtopsdk.mtop.util.a */
public class MtopConvert {
    @Deprecated
    /* renamed from: a */
    public static BaseOutDo m35581a(byte[] bArr, Class<?> cls) {
        BaseOutDo aVar;
        String str = "mtopsdk.MtopConvert";
        if (cls == null || bArr == null || bArr.length == 0) {
            TBSdkLog.m35510c(str, "[jsonToOutputDO]outClass is null or jsonData is blank");
            return null;
        }
        try {
            aVar = (BaseOutDo) JSON.parseObject(new String(bArr, "UTF-8"), cls);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("[jsonToOutputDO]invoke JSON.parseObject error ---Class=");
            sb.append(cls.getName());
            TBSdkLog.m35504a(str, sb.toString(), th);
            aVar = null;
        }
        return aVar;
    }

    @Deprecated
    /* renamed from: a */
    public static BaseOutDo m35580a(MtopResponse mtopResponse, Class<?> cls) {
        if (cls != null && mtopResponse != null) {
            return m35581a(mtopResponse.getBytedata(), cls);
        }
        TBSdkLog.m35510c("mtopsdk.MtopConvert", "outClass is null or response is null");
        return null;
    }
}
