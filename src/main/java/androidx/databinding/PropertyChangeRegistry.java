package androidx.databinding;

import androidx.databinding.CallbackRegistry.NotifierCallback;
import androidx.databinding.Observable.OnPropertyChangedCallback;

public class PropertyChangeRegistry extends CallbackRegistry<OnPropertyChangedCallback, Observable, Void> {
    private static final NotifierCallback<OnPropertyChangedCallback, Observable, Void> NOTIFIER_CALLBACK = new NotifierCallback<OnPropertyChangedCallback, Observable, Void>() {
        public void onNotifyCallback(OnPropertyChangedCallback onPropertyChangedCallback, Observable observable, int i, Void voidR) {
            onPropertyChangedCallback.onPropertyChanged(observable, i);
        }
    };

    public PropertyChangeRegistry() {
        super(NOTIFIER_CALLBACK);
    }

    public void notifyChange(Observable observable, int i) {
        notifyCallbacks(observable, i, null);
    }
}
