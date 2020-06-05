package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8247b;
import kotlin.jvm.p679a.C8263r;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022d\b\u0006\u0010\u0003\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u00042d\b\u0006\u0010\u000e\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u00042%\b\u0006\u0010\u000f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\r0\u0010H\b\u001a4\u0010\u0012\u001a\u00020\u0001*\u00020\u00022%\b\u0004\u0010\u0013\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\r0\u0010H\b\u001as\u0010\u0014\u001a\u00020\u0001*\u00020\u00022d\b\u0004\u0010\u0013\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0004H\b\u001as\u0010\u0015\u001a\u00020\u0001*\u00020\u00022d\b\u0004\u0010\u0013\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0004H\b¨\u0006\u0016"}, mo39189d2 = {"addTextChangedListener", "Landroid/text/TextWatcher;", "Landroid/widget/TextView;", "beforeTextChanged", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "text", "", "start", "count", "after", "", "onTextChanged", "afterTextChanged", "Lkotlin/Function1;", "Landroid/text/Editable;", "doAfterTextChanged", "action", "doBeforeTextChanged", "doOnTextChanged", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: TextView.kt */
public final class TextViewKt {
    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView textView, C8263r rVar, C8263r rVar2, C8247b bVar, int i, Object obj) {
        if ((i & 1) != 0) {
            rVar = TextViewKt$addTextChangedListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            rVar2 = TextViewKt$addTextChangedListener$2.INSTANCE;
        }
        if ((i & 4) != 0) {
            bVar = TextViewKt$addTextChangedListener$3.INSTANCE;
        }
        C8271i.m35386b(textView, "$this$addTextChangedListener");
        C8271i.m35386b(rVar, "beforeTextChanged");
        C8271i.m35386b(rVar2, "onTextChanged");
        C8271i.m35386b(bVar, "afterTextChanged");
        TextWatcher textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(bVar, rVar, rVar2);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static final TextWatcher addTextChangedListener(TextView textView, C8263r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> rVar, C8263r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> rVar2, C8247b<? super Editable, Unit> bVar) {
        C8271i.m35386b(textView, "$this$addTextChangedListener");
        C8271i.m35386b(rVar, "beforeTextChanged");
        C8271i.m35386b(rVar2, "onTextChanged");
        C8271i.m35386b(bVar, "afterTextChanged");
        TextWatcher textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(bVar, rVar, rVar2);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static final TextWatcher doBeforeTextChanged(TextView textView, C8263r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> rVar) {
        C8271i.m35386b(textView, "$this$doBeforeTextChanged");
        C8271i.m35386b(rVar, "action");
        TextWatcher textViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$1 = new TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$1(rVar);
        textView.addTextChangedListener(textViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$1);
        return textViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$1;
    }

    public static final TextWatcher doOnTextChanged(TextView textView, C8263r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> rVar) {
        C8271i.m35386b(textView, "$this$doOnTextChanged");
        C8271i.m35386b(rVar, "action");
        TextWatcher textViewKt$doOnTextChanged$$inlined$addTextChangedListener$1 = new TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$1(rVar);
        textView.addTextChangedListener(textViewKt$doOnTextChanged$$inlined$addTextChangedListener$1);
        return textViewKt$doOnTextChanged$$inlined$addTextChangedListener$1;
    }

    public static final TextWatcher doAfterTextChanged(TextView textView, C8247b<? super Editable, Unit> bVar) {
        C8271i.m35386b(textView, "$this$doAfterTextChanged");
        C8271i.m35386b(bVar, "action");
        TextWatcher textViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1 = new TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1(bVar);
        textView.addTextChangedListener(textViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1);
        return textViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1;
    }
}
