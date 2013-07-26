package com.kp.kpcontroller.player;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kp.kpcontroller.R;

/**
 * Created by Usuario on 25/07/13.
 */
public class SeriesFragment extends Fragment {

    public SeriesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_kpplayer_series, container, false);
        return rootView;
    }
}
