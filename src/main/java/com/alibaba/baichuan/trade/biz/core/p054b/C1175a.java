package com.alibaba.baichuan.trade.biz.core.p054b;

import com.alibaba.baichuan.trade.biz.core.config.model.ActionDO;
import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.biz.core.config.model.ParamDO;
import com.alibaba.baichuan.trade.biz.core.config.model.RouteConfigDO;
import com.alibaba.baichuan.trade.biz.core.p054b.p055a.C1176a;
import com.alibaba.baichuan.trade.biz.core.p054b.p055a.C1179d;
import com.alibaba.baichuan.trade.biz.core.p054b.p056b.C1183b;
import com.alibaba.baichuan.trade.biz.core.p054b.p056b.C1184c;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.alibaba.baichuan.trade.biz.core.b.a */
public class C1175a implements C1176a {
    /* renamed from: a */
    private C1176a f2434a;

    /* renamed from: a */
    public C1179d mo10750a(ConfigDO configDO, C1179d dVar, C1184c cVar, C1183b bVar) {
        String a = dVar.mo10752a();
        if (a == null || a.length() == 0) {
            cVar.mo10664a(1600);
            return null;
        }
        if (configDO != null) {
            ArrayList arrayList = new ArrayList();
            for (RouteConfigDO routeConfigDO : configDO.getRouteConfig()) {
                int[] index = routeConfigDO.getIndex();
                Matcher matcher = Pattern.compile(routeConfigDO.getMatch()).matcher(a);
                if (matcher.find()) {
                    for (int i : index) {
                        if (i <= matcher.groupCount()) {
                            arrayList.add(matcher.group(i));
                        }
                    }
                    List<ActionDO> action = routeConfigDO.getAction();
                    for (ActionDO actionDO : action) {
                        ParamDO param = actionDO.getParam();
                        String targetPath = param.getTargetPath();
                        if (!(targetPath == null || targetPath.length() == 0)) {
                            String str = targetPath;
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("{");
                                sb.append(i2);
                                sb.append("}");
                                str = str.replace(sb.toString(), (CharSequence) arrayList.get(i2));
                            }
                            targetPath = str;
                        }
                        param.setTargetPath(targetPath);
                        actionDO.setParam(param);
                    }
                    dVar.mo10753a(action);
                    return dVar;
                }
            }
        } else {
            cVar.mo10664a(1100);
        }
        return null;
    }

    /* renamed from: a */
    public void mo10751a(C1176a aVar) {
        this.f2434a = aVar;
    }
}
