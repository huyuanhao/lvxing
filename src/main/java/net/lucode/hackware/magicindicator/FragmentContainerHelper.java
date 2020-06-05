package net.lucode.hackware.magicindicator;

import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p696b.PositionData;

/* renamed from: net.lucode.hackware.magicindicator.a */
public class FragmentContainerHelper {
    /* renamed from: a */
    public static PositionData m35616a(List<PositionData> list, int i) {
        PositionData aVar;
        if (i >= 0 && i <= list.size() - 1) {
            return (PositionData) list.get(i);
        }
        PositionData aVar2 = new PositionData();
        if (i < 0) {
            aVar = (PositionData) list.get(0);
        } else {
            i = (i - list.size()) + 1;
            aVar = (PositionData) list.get(list.size() - 1);
        }
        aVar2.f28116a = aVar.f28116a + (aVar.mo39960a() * i);
        aVar2.f28117b = aVar.f28117b;
        aVar2.f28118c = aVar.f28118c + (aVar.mo39960a() * i);
        aVar2.f28119d = aVar.f28119d;
        aVar2.f28120e = aVar.f28120e + (aVar.mo39960a() * i);
        aVar2.f28121f = aVar.f28121f;
        aVar2.f28122g = aVar.f28122g + (i * aVar.mo39960a());
        aVar2.f28123h = aVar.f28123h;
        return aVar2;
    }
}
