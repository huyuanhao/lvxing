package com.qiyukf.nim.uikit.common.media.picker.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.qiyukf.nim.uikit.common.fragment.TFragment;
import com.qiyukf.nim.uikit.common.media.picker.model.PhotoInfo;
import com.qiyukf.nim.uikit.common.media.picker.p422a.C5452b;
import com.qiyukf.nim.uikit.common.media.picker.p423b.C5463b;
import com.qiyukf.unicorn.C5961R;
import java.util.ArrayList;
import java.util.List;

public class PickerImageFragment extends TFragment implements OnItemClickListener {
    /* renamed from: a */
    private GridView f17553a;
    /* renamed from: b */
    private C5467a f17554b;
    /* renamed from: c */
    private List<PhotoInfo> f17555c;
    /* renamed from: d */
    private C5452b f17556d;
    /* renamed from: e */
    private boolean f17557e;
    /* renamed from: f */
    private int f17558f;
    /* renamed from: g */
    private int f17559g = 1;

    /* renamed from: com.qiyukf.nim.uikit.common.media.picker.fragment.PickerImageFragment$a */
    public interface C5467a {
        void onPhotoSelectClick(PhotoInfo photoInfo);

        void onPhotoSingleClick(List<PhotoInfo> list, int i);
    }

    public PickerImageFragment() {
        setContainerId(C5961R.C5963id.picker_photos_fragment);
    }

    /* renamed from: a */
    private void m22286a() {
        GridView gridView = this.f17553a;
        if (gridView != null) {
            gridView.setNumColumns(this.f17559g == 2 ? 6 : 4);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        this.f17555c = new ArrayList();
        this.f17555c.addAll(C5463b.m22274a(getContext()));
        this.f17557e = arguments.getBoolean("multi_select_mode");
        this.f17558f = arguments.getInt("multi_select_size_limit", 9);
        this.f17559g = arguments.getInt("extra_screen_orientation");
        if (getView() != null) {
            this.f17553a = (GridView) getView().findViewById(C5961R.C5963id.picker_images_gridview);
            m22286a();
            C5452b bVar = new C5452b(getActivity(), this.f17555c, this.f17553a, this.f17557e, 0, this.f17558f, this.f17559g);
            this.f17556d = bVar;
            this.f17553a.setAdapter(this.f17556d);
            this.f17553a.setOnItemClickListener(this);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (this.f17554b == null) {
            this.f17554b = (C5467a) activity;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f17559g = configuration.orientation;
        m22286a();
        this.f17556d.mo27458a(configuration);
        C5452b bVar = this.f17556d;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C5961R.C5964layout.ysf_picker_images_fragment, viewGroup, false);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f17554b.onPhotoSingleClick(this.f17555c, i);
    }

    public void resetFragment(List<PhotoInfo> list, int i) {
        if (this.f17553a == null) {
            if (getView() != null) {
                this.f17553a = (GridView) getView().findViewById(C5961R.C5963id.picker_images_gridview);
            } else {
                return;
            }
        }
        this.f17553a.setAdapter(null);
        List<PhotoInfo> list2 = this.f17555c;
        if (list2 == null) {
            this.f17555c = new ArrayList();
        } else {
            list2.clear();
        }
        if (list != null) {
            this.f17555c.addAll(list);
        }
        m22286a();
        C5452b bVar = new C5452b(getActivity(), this.f17555c, this.f17553a, this.f17557e, i, this.f17558f, this.f17559g);
        this.f17556d = bVar;
        this.f17553a.setAdapter(this.f17556d);
    }

    public void updateSelectPhotos(List<PhotoInfo> list) {
        if (list != null) {
            for (PhotoInfo photoInfo : this.f17555c) {
                photoInfo.setChoose(list.contains(photoInfo));
            }
            C5452b bVar = this.f17556d;
            if (bVar != null) {
                bVar.notifyDataSetChanged();
            }
        }
    }

    public void updateSelectedForAdapter(int i) {
        C5452b bVar = this.f17556d;
        if (bVar != null) {
            bVar.mo27457a(i);
        }
    }
}
