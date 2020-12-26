package com.example.shoppimg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.shoppimg.R;

public class SingleLayout3Adapter extends DelegateAdapter.Adapter {
    private Context context;
    private SingleLayoutHelper singleLayoutHelper3;


    public SingleLayout3Adapter(Context context, SingleLayoutHelper singleLayoutHelper3) {
        this.context = context;
        this.singleLayoutHelper3 = singleLayoutHelper3;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper3;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_four1, null);
        return new SingleLayout3ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
    class SingleLayout3ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvHome;
        public SingleLayout3ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHome = (TextView) itemView.findViewById(R.id.tv_home_four_name);
        }
    }
}
