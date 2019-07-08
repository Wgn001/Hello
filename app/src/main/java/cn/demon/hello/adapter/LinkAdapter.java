package cn.demon.hello.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.demon.hello.R;
import cn.demon.hello.bean.Person;

public class LinkAdapter extends RecyclerView.Adapter<LinkAdapter.ViewHolder> {

    private List<Person> mlist;

    public LinkAdapter(List<Person> mlist) {
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_item,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Person person=mlist.get(i);
        if(person!=null){
            viewHolder.tv_name.setText(person.getName());
            viewHolder.iv_icon.setImageResource(person.getImgId());
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
         private TextView tv_name;
         private ImageView iv_icon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.tv_name);
            iv_icon=itemView.findViewById(R.id.iv_icon);
        }
    }

}
