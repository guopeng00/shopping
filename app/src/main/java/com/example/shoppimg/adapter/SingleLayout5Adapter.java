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

public class SingleLayout5Adapter extends DelegateAdapter.Adapter {
    private Context context;
    private SingleLayoutHelper singleLayoutHelper5;

    public SingleLayout5Adapter(Context context, SingleLayoutHelper singleLayoutHelper5) {
        this.context = context;
        this.singleLayoutHelper5 = singleLayoutHelper5;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper5;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_six1, null);
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
            tvHome = (TextView) itemView.findViewById(R.id.tv_home_six_name);
        }
    }
}
