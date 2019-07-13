package cn.demon.hello.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.demon.hello.MainActivity;
import cn.demon.hello.R;
import cn.demon.hello.activity.AddFriendAct;
import cn.demon.hello.adapter.CityAdapter;
import cn.demon.hello.bean.CityBean;
import cn.demon.hello.suspension.SuspensionDecoration;
import cn.demon.hello.view.IndexBar;

/**
 *
 *通讯录
 * @author Gn.w
 * @date 19.7.13
 */
public class LinkFragment extends Fragment {

    private static final String TAG = "zxt";
    private static final String INDEX_STRING_TOP = "↑";
    private RecyclerView mRv;
    private CityAdapter mAdapter;
    private LinearLayoutManager mManager;
    private List<CityBean> mDatas = new ArrayList<>();
    private SuspensionDecoration mDecoration;
    MainActivity mainActivity;
    private ImageView ig_add_friends;

    /**
     * 右侧边栏导航区域
     */
    private IndexBar mIndexBar;

    /**
     * 显示指示器DialogText
     */
    private TextView mTvSideBarHint;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.linkman_fragment,container,false);
        mainActivity=(MainActivity) getActivity();
        mRv = view.findViewById(R.id.rv_linkman);
        mRv.setLayoutManager(mManager = new LinearLayoutManager(mainActivity));
//      添加好友
        ig_add_friends=view.findViewById(R.id.ig_add_friends);
        ig_add_friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainActivity, AddFriendAct.class);
                startActivity(intent);
            }
        });

        mAdapter = new CityAdapter(container.getContext(), mDatas);
        mRv.setAdapter(mAdapter);
        mRv.addItemDecoration(mDecoration = new SuspensionDecoration(mainActivity, mDatas));
        //如果add两个，那么按照先后顺序，依次渲染。
        mRv.addItemDecoration(new DividerItemDecoration(container.getContext(), cn.demon.hello.decoration.DividerItemDecoration.VERTICAL_LIST));

        //使用indexBar
        mTvSideBarHint = view.findViewById(R.id.tvSideBarHint);//HintTextView
        mIndexBar = view. findViewById(R.id.indexBar);//IndexBar

        //indexbar初始化
        mIndexBar.setmPressedShowTextView(mTvSideBarHint)//设置HintTextView
                .setNeedRealIndex(false)//设置需要真实的索引
                .setmLayoutManager(mManager);//设置RecyclerView的LayoutManager
        //模拟线上加载数据
        initDatas(getResources().getStringArray(R.array.provinces));
        return view;
    }
    /**
     * 组织数据源
     *
     * @param data
     * @return
     */
    private void initDatas(final String[] data) {
        //延迟两秒 模拟加载数据中....
        mainActivity.getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                mDatas = new ArrayList<>();
                //微信的头部 也是可以右侧IndexBar导航索引的，
                // 但是它不需要被ItemDecoration设一个标题titile
                mDatas.add((CityBean) new CityBean("新的朋友",R.drawable.contact_newfrend).setTop(true).setBaseIndexTag(INDEX_STRING_TOP));
                mDatas.add((CityBean) new CityBean("群组",R.drawable.ql_ic).setTop(true).setBaseIndexTag(INDEX_STRING_TOP));
                mDatas.add((CityBean) new CityBean("用户自己",R.drawable.new_user_pic).setTop(true).setBaseIndexTag(INDEX_STRING_TOP));
                for (int i = 0; i < data.length; i++) {
                    CityBean cityBean = new CityBean();
                    cityBean.setCity(data[i]);//设置城市名称
                    cityBean.setImg(R.drawable.new_user_pic);
                    mDatas.add(cityBean);
                }
                mAdapter.setDatas(mDatas);
                mAdapter.notifyDataSetChanged();
                mIndexBar.setmSourceDatas(mDatas)//设置数据
                        .invalidate();
                mDecoration.setmDatas(mDatas);
            }
        }, 500);
    }

}
