package cn.demon.hello.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LetterView extends LinearLayout {
    private Context mContext;
    private CharacterClickListener mListener;
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

    public TextView buildTextLayout(final String character){
        LinearLayout.LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT,1);
        TextView tv=new TextView(mContext);
        tv.setGravity(Gravity.CENTER);
        tv.setClickable(true);
        tv.setText(character);
        tv.setTextColor(Color.GRAY);
        tv.setTextSize(12);
        tv.setLayoutParams(layoutParams);
        tv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null){
                    mListener.clickCharacter(character);
                }
            }
        });
        return tv;
    }

    public void setCharacterClickListener(CharacterClickListener clickListener){
            mListener=clickListener;
    }


    public interface CharacterClickListener{
            void clickCharacter(String character);
    }


}
