package androidx.databinding.adapters;

import android.widget.AutoCompleteTextView;
import android.widget.AutoCompleteTextView.Validator;
import androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelected;
import androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelectedComponentListener;
import androidx.databinding.adapters.AdapterViewBindingAdapter.OnNothingSelected;

public class AutoCompleteTextViewBindingAdapter {

    /* renamed from: androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter$FixText */
    public interface FixText {
        CharSequence fixText(CharSequence charSequence);
    }

    /* renamed from: androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter$IsValid */
    public interface IsValid {
        boolean isValid(CharSequence charSequence);
    }

    public static void setValidator(AutoCompleteTextView autoCompleteTextView, final FixText fixText, final IsValid isValid) {
        if (fixText == null && isValid == null) {
            autoCompleteTextView.setValidator(null);
        } else {
            autoCompleteTextView.setValidator(new Validator() {
                public boolean isValid(CharSequence charSequence) {
                    IsValid isValid = isValid;
                    if (isValid != null) {
                        return isValid.isValid(charSequence);
                    }
                    return true;
                }

                public CharSequence fixText(CharSequence charSequence) {
                    FixText fixText = fixText;
                    return fixText != null ? fixText.fixText(charSequence) : charSequence;
                }
            });
        }
    }

    public static void setOnItemSelectedListener(AutoCompleteTextView autoCompleteTextView, OnItemSelected onItemSelected, OnNothingSelected onNothingSelected) {
        if (onItemSelected == null && onNothingSelected == null) {
            autoCompleteTextView.setOnItemSelectedListener(null);
        } else {
            autoCompleteTextView.setOnItemSelectedListener(new OnItemSelectedComponentListener(onItemSelected, onNothingSelected, null));
        }
    }
}
