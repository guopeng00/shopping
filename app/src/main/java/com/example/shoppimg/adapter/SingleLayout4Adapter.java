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

public class SingleLayout4Adapter extends DelegateAdapter.Adapter {
    private Context context;
    private SingleLayoutHelper singleLayoutHelper4;

    public SingleLayout4Adapter(Context context, SingleLayoutHelper singleLayoutHelper4) {
        this.context = context;
        this.singleLayoutHelper4 = singleLayoutHelper4;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper4;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_five1, null);
        return new SingleLayout4ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
    class SingleLayout4ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvHome;
        public SingleLayout4ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHome = (TextView) itemView.findViewById(R.id.tv_home_five_name);
        }
    }
}
