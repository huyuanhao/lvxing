package androidx.databinding;

import androidx.databinding.CallbackRegistry.NotifierCallback;
import androidx.databinding.ObservableMap.OnMapChangedCallback;

public class MapChangeRegistry extends CallbackRegistry<OnMapChangedCallback, ObservableMap, Object> {
    private static NotifierCallback<OnMapChangedCallback, ObservableMap, Object> NOTIFIER_CALLBACK = new NotifierCallback<OnMapChangedCallback, ObservableMap, Object>() {
        public void onNotifyCallback(OnMapChangedCallback onMapChangedCallback, ObservableMap observableMap, int i, Object obj) {
            onMapChangedCallback.onMapChanged(observableMap, obj);
        }
    };

    public MapChangeRegistry() {
        super(NOTIFIER_CALLBACK);
    }

    public void notifyChange(ObservableMap observableMap, Object obj) {
        notifyCallbacks(observableMap, 0, obj);
    }
}
