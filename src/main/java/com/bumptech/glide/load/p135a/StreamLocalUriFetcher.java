package com.bumptech.glide.load.p135a;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.a.n */
public class StreamLocalUriFetcher extends LocalUriFetcher<InputStream> {
    /* renamed from: a */
    private static final UriMatcher f4425a = new UriMatcher(-1);

    static {
        String str = "com.android.contacts";
        f4425a.addURI(str, "contacts/lookup/*/#", 1);
        f4425a.addURI(str, "contacts/lookup/*", 1);
        f4425a.addURI(str, "contacts/#/photo", 2);
        f4425a.addURI(str, "contacts/#", 3);
        f4425a.addURI(str, "contacts/#/display_photo", 4);
        f4425a.addURI(str, "phone_lookup/*", 5);
    }

    public StreamLocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public InputStream mo12622b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream c = m5374c(uri, contentResolver);
        if (c != null) {
            return c;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("InputStream is null for ");
        sb.append(uri);
        throw new FileNotFoundException(sb.toString());
    }

    /* renamed from: c */
    private InputStream m5374c(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int match = f4425a.match(uri);
        if (match != 1) {
            if (match == 3) {
                return m5373a(contentResolver, uri);
            }
            if (match != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri lookupContact = Contacts.lookupContact(contentResolver, uri);
        if (lookupContact != null) {
            return m5373a(contentResolver, lookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    /* renamed from: a */
    private InputStream m5373a(ContentResolver contentResolver, Uri uri) {
        return Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo12621a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* renamed from: a */
    public Class<InputStream> mo12619a() {
        return InputStream.class;
    }
}
