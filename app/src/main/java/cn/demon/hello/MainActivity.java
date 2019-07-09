package cn.demon.hello;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

import cn.demon.hello.bean.Login;
import cn.demon.hello.bean.Person;
import cn.demon.hello.fragment.FindFragment;
import cn.demon.hello.fragment.LinkFragment;
import cn.demon.hello.fragment.MessageFragment;
import cn.demon.hello.fragment.MyFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private List<Fragment> fragmentList;
    private ViewPager viewPager;
    private BottomNavigationView btnNav;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_main);
        initFragment();
        initView();
        initAdapter();
        initViewPagerListener();
    }

    private void initViewPagerListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                btnNav.getMenu().getItem(i).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        btnNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_msg:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.action_linkman:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.action_find:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.action_mine:
                        viewPager.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });
    }






    private void initAdapter() {
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragmentList.get(i);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
    }

    private void initFragment() {
            fragmentList=new ArrayList<>();
            fragmentList.add(new MessageFragment());
            fragmentList.add(new LinkFragment());
            fragmentList.add(new FindFragment());
            fragmentList.add(MyFragment.newInstance(getIntent().getBundleExtra("intent_login")));
    }

    /**
     * 初始化
     */
    private void initView() {
        viewPager=findViewById(R.id.viewPager);
        btnNav=findViewById(R.id.Btnv);
    }

}
