package cn.demon.hello.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import cn.demon.hello.R;
import cn.demon.hello.bean.Person;

public class BlacklistAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private List<Person> personList; //联系人列表
    private List<String> mContactName; //联系人名称列表
    private List<String> resultList;    //最终列表

    private static int ITEM_TYPE_CONTACT=1;
    private static int ITEM_TYPE_CHARACTER=2;


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CharacterHolder extends RecyclerView.ViewHolder {
        TextView tv_character;

        public CharacterHolder(@NonNull View itemView) {
            super(itemView);
            tv_character = itemView.findViewById(R.id.tv_character);
        }
    }

    public class ContcatHolder extends RecyclerView.ViewHolder {
        ImageView iv_icon;
        TextView tv_name;
        public ContcatHolder(@NonNull View itemView) {
            super(itemView);
            iv_icon = itemView.findViewById(R.id.iv_icon);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }

}
