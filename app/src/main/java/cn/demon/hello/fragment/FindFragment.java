package cn.demon.hello.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import cn.demon.hello.R;
import cn.demon.hello.activity.FriendsAct;

public class FindFragment extends Fragment {
    private LinearLayout ll_friends;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_fragment, container, false);

        ll_friends=view.findViewById(R.id.ll_friends);
        ll_friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), FriendsAct.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
