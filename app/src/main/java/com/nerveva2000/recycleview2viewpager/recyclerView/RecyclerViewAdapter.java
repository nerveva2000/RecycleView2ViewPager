package com.nerveva2000.recycleview2viewpager.recyclerView;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nerveva2000.recycleview2viewpager.R;
import com.nerveva2000.recycleview2viewpager.fragment.ShowFragment;

/**
 * @author wanglong
 * @date 2018/4/9.
 * @describe RecyclerViewAdapter
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public RecyclerViewAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        int resultType = 0;
        switch (position) {
            case 0:
                resultType = 0;
                break;
            case 1:
                resultType = 1;
                break;
            case 2:
                resultType = 2;
                break;
            default:
                break;
        }
        return resultType;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case 0:
                viewHolder = new MyViewHolder(mLayoutInflater.inflate(R.layout.item_view0, parent, false));
                break;
            case 1:
                viewHolder = new MyViewHolder1(mLayoutInflater.inflate(R.layout.item_view1, parent, false));
                break;
            case 2:
                viewHolder = new MyViewHolder2(mLayoutInflater.inflate(R.layout.item_view2, parent, false));
                break;
            default:
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewId = View.NO_ID;
        Bundle bundle = new Bundle();
        if (holder instanceof MyViewHolder) {
            bundle.putString("TEXT_CENTER", "Fragment0");

            MyViewHolder myViewHolder = (MyViewHolder) holder;
            viewId = myViewHolder.rl_root.getId();
        } else if (holder instanceof MyViewHolder1) {
            bundle.putString("TEXT_CENTER", "Fragment1");

            MyViewHolder1 myViewHolder1 = (MyViewHolder1) holder;
            viewId = myViewHolder1.rl_root.getId();
        } else if (holder instanceof MyViewHolder2) {
            bundle.putString("TEXT_CENTER", "Fragment2");

            MyViewHolder2 myViewHolder2 = (MyViewHolder2) holder;
            viewId = myViewHolder2.rl_root.getId();
        }

        if (viewId != View.NO_ID) {
            Fragment fragment = new ShowFragment();
            fragment.setArguments(bundle);

            FragmentManager fragmentManager = ((Activity) mContext).getFragmentManager();
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.replace(viewId, fragment);
            beginTransaction.commit();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        View rl_root;

        public MyViewHolder(View itemView) {
            super(itemView);
            rl_root = itemView.findViewById(R.id.rl_root0);
        }
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder {
        View rl_root;

        public MyViewHolder1(View itemView) {
            super(itemView);
            rl_root = itemView.findViewById(R.id.rl_root1);
        }
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder {
        View rl_root;

        public MyViewHolder2(View itemView) {
            super(itemView);
            rl_root = itemView.findViewById(R.id.rl_root2);
        }
    }
}
