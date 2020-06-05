package tmsdk.common.roach.nest;

import android.os.Bundle;
import tmsdk.common.roach.RoachManager;

public abstract class ActionI {
    public static final String privDirKey = "privDirKey";

    public abstract void clean();

    public void finish() {
        onStop();
        RoachManager.getInstance().releaseItem(this);
    }

    public abstract void onStart(Bundle bundle);

    public abstract void onStop();
}
