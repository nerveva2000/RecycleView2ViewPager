package com.nerveva2000.recycleview2viewpager.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nerveva2000.recycleview2viewpager.R;

/**
 * @author wanglong
 * @date 2018/4/8.
 * @describe
 */
public class ShowFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment, null);
        TextView mTV_center = root.findViewById(R.id.tv_center);
        Bundle arguments = getArguments();
        String text_center = arguments.getString("TEXT_CENTER");
        mTV_center.setText(text_center);
        return root;
    }
}
