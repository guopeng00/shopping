package com.example.shoppimg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.shoppimg.R;

public class SingleLayoutAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private SingleLayoutHelper singleLayoutHelper;

    public SingleLayoutAdapter(Context context, SingleLayoutHelper singleLayoutHelper) {
        this.context = context;
        this.singleLayoutHelper = singleLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_one, null);
        return new SingleViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SingleViewHolder holder1= (SingleViewHolder) holder;
        holder1.oneName.getText();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class SingleViewHolder extends RecyclerView.ViewHolder {
   //     private ImageView oneImg;
        private EditText oneName;
        public SingleViewHolder(@NonNull View itemView) {
            super(itemView);
            //oneImg = (ImageView) itemView.findViewById(R.id.one_img);
            oneName = (EditText) itemView.findViewById(R.id.one_name);
        }
    }
}
