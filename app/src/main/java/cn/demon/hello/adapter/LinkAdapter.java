package cn.demon.hello.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.view.ViewGroup;
import java.util.List;
import cn.demon.hello.bean.Person;

public class LinkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PhotoAdapter.ViewHolder(viewGroup);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }



}
