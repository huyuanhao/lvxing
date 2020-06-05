package com.p570ta.utdid2.device;

import com.p570ta.utdid2.p572b.p573a.AESUtils;
import com.p570ta.utdid2.p572b.p573a.C6797b;
import java.util.Random;

/* renamed from: com.ta.utdid2.device.d */
public class UTUtdidHelper {
    /* renamed from: a */
    private static Random f22558a = new Random();
    /* renamed from: p */
    private String f22559p;

    public UTUtdidHelper() {
        this.f22559p = "XwYp8WL8bm6S4wu6yEYmLGy4RRRdJDIhxCBdk3CiNZTwGoj1bScVZEeVp9vBiiIsgwDtqZHP8QLoFM6o6MRYjW8QqyrZBI654mqoUk5SOLDyzordzOU5QhYguEJh54q3K1KqMEXpdEQJJjs1Urqjm2s4jgPfCZ4hMuIjAMRrEQluA7FeoqWMJOwghcLcPVleQ8PLzAcaKidybmwhvNAxIyKRpbZlcDjNCcUvsJYvyzEA9VUIaHkIAJ62lpA3EE3H";
        this.f22559p = C6797b.encodeToString(this.f22559p.getBytes(), 2);
    }

    /* renamed from: c */
    public String mo32718c(byte[] bArr) {
        return AESUtils.m29021d(this.f22559p, C6797b.encodeToString(bArr, 2));
    }

    /* renamed from: a */
    public String mo32716a(String str) {
        return AESUtils.m29021d(this.f22559p, str);
    }

    /* renamed from: b */
    public String mo32717b(String str) {
        return AESUtils.m29022e(this.f22559p, str);
    }
}
