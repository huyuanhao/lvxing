package androidx.databinding.adapters;

import android.os.Build.VERSION;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.SearchView.OnSuggestionListener;

public class SearchViewBindingAdapter {

    /* renamed from: androidx.databinding.adapters.SearchViewBindingAdapter$OnQueryTextChange */
    public interface OnQueryTextChange {
        boolean onQueryTextChange(String str);
    }

    /* renamed from: androidx.databinding.adapters.SearchViewBindingAdapter$OnQueryTextSubmit */
    public interface OnQueryTextSubmit {
        boolean onQueryTextSubmit(String str);
    }

    /* renamed from: androidx.databinding.adapters.SearchViewBindingAdapter$OnSuggestionClick */
    public interface OnSuggestionClick {
        boolean onSuggestionClick(int i);
    }

    /* renamed from: androidx.databinding.adapters.SearchViewBindingAdapter$OnSuggestionSelect */
    public interface OnSuggestionSelect {
        boolean onSuggestionSelect(int i);
    }

    public static void setOnQueryTextListener(SearchView searchView, final OnQueryTextSubmit onQueryTextSubmit, final OnQueryTextChange onQueryTextChange) {
        if (VERSION.SDK_INT < 11) {
            return;
        }
        if (onQueryTextSubmit == null && onQueryTextChange == null) {
            searchView.setOnQueryTextListener(null);
        } else {
            searchView.setOnQueryTextListener(new OnQueryTextListener() {
                public boolean onQueryTextSubmit(String str) {
                    OnQueryTextSubmit onQueryTextSubmit = onQueryTextSubmit;
                    if (onQueryTextSubmit != null) {
                        return onQueryTextSubmit.onQueryTextSubmit(str);
                    }
                    return false;
                }

                public boolean onQueryTextChange(String str) {
                    OnQueryTextChange onQueryTextChange = onQueryTextChange;
                    if (onQueryTextChange != null) {
                        return onQueryTextChange.onQueryTextChange(str);
                    }
                    return false;
                }
            });
        }
    }

    public static void setOnSuggestListener(SearchView searchView, final OnSuggestionSelect onSuggestionSelect, final OnSuggestionClick onSuggestionClick) {
        if (VERSION.SDK_INT < 11) {
            return;
        }
        if (onSuggestionSelect == null && onSuggestionClick == null) {
            searchView.setOnSuggestionListener(null);
        } else {
            searchView.setOnSuggestionListener(new OnSuggestionListener() {
                public boolean onSuggestionSelect(int i) {
                    OnSuggestionSelect onSuggestionSelect = onSuggestionSelect;
                    if (onSuggestionSelect != null) {
                        return onSuggestionSelect.onSuggestionSelect(i);
                    }
                    return false;
                }

                public boolean onSuggestionClick(int i) {
                    OnSuggestionClick onSuggestionClick = onSuggestionClick;
                    if (onSuggestionClick != null) {
                        return onSuggestionClick.onSuggestionClick(i);
                    }
                    return false;
                }
            });
        }
    }
}
