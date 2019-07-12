package cn.demon.hello.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.demon.hello.R;
import cn.demon.hello.activity.AddFriendAct;
import cn.demon.hello.activity.FriendMesAct;
import cn.demon.hello.activity.FriendsAct;
import cn.demon.hello.bean.CityBean;

/**
 * Created by zhangxutong .
 * Date: 16/08/28
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {
    protected Context mContext;
    protected List<CityBean> mDatas;
    protected LayoutInflater mInflater;

    public CityAdapter(Context mContext, List<CityBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(mContext);
    }

    public List<CityBean> getDatas() {
        return mDatas;
    }

    public CityAdapter setDatas(List<CityBean> datas) {
        mDatas = datas;
        return this;
    }

    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.item_city, parent, false));
    }

    @Override
    public void onBindViewHolder(final CityAdapter.ViewHolder holder, final int position) {
        final CityBean cityBean = mDatas.get(position);
        holder.tvCity.setText(cityBean.getCity());
        holder.tvCity.setTextColor(Color.BLACK);
        holder.content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, FriendMesAct.class);
                Bundle bundle = new Bundle();
                bundle.putString("nick", cityBean.getCity());
                bundle.putInt("icon", cityBean.getImg());
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
        holder.avatar.setImageResource(cityBean.getImg());
    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCity;
        ImageView avatar;
        View content;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCity = itemView.findViewById(R.id.tvCity);
            avatar = itemView.findViewById(R.id.ivAvatar);
            content = itemView.findViewById(R.id.content);
        }
    }
}
