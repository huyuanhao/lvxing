package discoveryAD;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qqpim.discovery.internal.model.ClickDataModel;

/* renamed from: discoveryAD.J */
class C7865J implements OnTouchListener {
    final /* synthetic */ C7867L this$0;

    C7865J(C7867L l) {
        this.this$0 = l;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        ClickDataModel clickDataModel = (ClickDataModel) view.getTag(117440511);
        int action = motionEvent.getAction();
        if (action == 0) {
            clickDataModel.down_x = (double) motionEvent.getX();
            clickDataModel.down_y = (double) motionEvent.getY();
        } else if (action == 1) {
            clickDataModel.up_x = (double) motionEvent.getX();
            clickDataModel.up_y = (double) motionEvent.getY();
        }
        return false;
    }
}
