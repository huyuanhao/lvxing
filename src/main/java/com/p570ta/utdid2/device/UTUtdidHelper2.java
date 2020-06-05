package com.p570ta.utdid2.device;

import com.p570ta.utdid2.p572b.p573a.AESUtils;
import com.p570ta.utdid2.p572b.p573a.C6797b;
import com.p570ta.utdid2.p572b.p573a.C6804i;

/* renamed from: com.ta.utdid2.device.e */
public class UTUtdidHelper2 {
    /* renamed from: p */
    private String f22560p;

    public UTUtdidHelper2() {
        this.f22560p = "XwYp8WL8bm6S4wu6yEYmLGy4RRRdJDIhxCBdk3CiNZTwGoj1bScVZEeVp9vBiiIsgwDtqZHP8QLoFM6o6MRYjW8QqyrZBI654mqoUk5SOLDyzordzOU5QhYguEJh54q3K1KqMEXpdEQJJjs1Urqjm2s4jgPfCZ4hMuIjAMRrEQluA7FeoqWMJOwghcLcPVleQ8PLzAcaKidybmwhvNAxIyKRpbZlcDjNCcUvsJYvyzEA9VUIaHkIAJ62lpA3EE3H";
        this.f22560p = C6797b.encodeToString(this.f22560p.getBytes(), 0);
    }

    /* renamed from: b */
    public String mo32719b(String str) {
        return AESUtils.m29022e(this.f22560p, str);
    }

    /* renamed from: c */
    public String mo32720c(String str) {
        String e = AESUtils.m29022e(this.f22560p, str);
        if (!C6804i.m29033a(e)) {
            try {
                return new String(C6797b.decode(e, 0));
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }
}
