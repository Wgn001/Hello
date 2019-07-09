package cn.demon.hello.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LetterView extends LinearLayout {
    private Context mContext;

    public LetterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
        setOrientation(VERTICAL);
        initView();
    }

    private void initView() {

        addView(buildTextLayout("#"));
        for (char i = 'A'; i <= 'Z'; i++) {
            TextView tv=buildTextLayout(i+"");
            addView(tv);
        }

    }

    public TextView buildTextLayout(String character){
        LinearLayout.LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT,1);
        TextView tv=new TextView(mContext);
        tv.setGravity(Gravity.CENTER);
        tv.setClickable(true);
        tv.setText(character);
        tv.setTextColor(Color.GRAY);
        tv.setTextSize(7);
        tv.setLayoutParams(layoutParams);
        return tv;
    }

}
