package cn.demon.hello.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.demon.hello.R;
import cn.demon.hello.activity.PhotoBgAct;
import cn.demon.hello.bean.Photo;
/**
 *
 *个人相册adapter
 * @author Gn.w
 * @date 19.7.13
 */
public class PhotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Photo>  photoList;
    private Context context;
    private static final int item_type_header=1;
    private static final int item_type_content=2;

    public PhotoAdapter(List<Photo> photoList, Context context) {
        this.photoList = photoList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        RecyclerView.ViewHolder viewHolder=null;
        if(i==item_type_header){
            view= LayoutInflater.from(context).inflate(R.layout.rv_photo_header,viewGroup,false);
            viewHolder=new HeaderHolder(view);
            System.out.println("Header"+i);
            return viewHolder;
        }else if(i==item_type_content){
            view= LayoutInflater.from(context).inflate(R.layout.rv_photo_item,viewGroup,false);
            viewHolder=new ViewHolder(view);
            System.out.println("View"+i);
            return viewHolder;
        }
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return item_type_header;
        }else{
            return  item_type_content;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder vholder = null;
        HeaderHolder hHolder = null;

            if(viewHolder instanceof HeaderHolder){
                hHolder=(HeaderHolder)viewHolder;
                hHolder.ig_photo_bg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            showDialog(context);
                    }
                });
            }

        if(photoList.size()>0){
            if(viewHolder instanceof ViewHolder){
                vholder=(ViewHolder) viewHolder;
                vholder.tv_photo_comment.setText("评论("+photoList.get(i).getComment_data()+")");
                vholder.tv_photo_content.setText(photoList.get(i).getContent());
                vholder.tv_photo_date.setText(photoList.get(i).getDate());
                vholder.tv_photo_dz.setText("点赞("+photoList.get(i).getDz_data()+")");
                vholder.ig_photo.setImageResource(photoList.get(i).getImg());

                vholder.ig_photo_delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog("确认删除",R.layout.dialog_layout_login,i);

                    }
                });

            }
        }
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    /**
     * 子条目Item
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_photo_date, tv_photo_content, tv_photo_dz, tv_photo_comment;
        private ImageView ig_photo;
        private ImageView ig_photo_delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_photo_comment=itemView.findViewById(R.id.tv_photo_comment);
            tv_photo_date=itemView.findViewById(R.id.tv_photo_date);
            tv_photo_content=itemView.findViewById(R.id.tv_photo_content);
            tv_photo_dz=itemView.findViewById(R.id.tv_photo_dz);
            ig_photo=itemView.findViewById(R.id.ig_photo);
            ig_photo_delete=itemView.findViewById(R.id.ig_photo_delete);
        }
    }


    /**
     * 头部Item
     */
    public static class HeaderHolder extends RecyclerView.ViewHolder{
        private TextView tv_photo_name;
        private ImageView ig_photo_tv, ig_photo_bg;
        public HeaderHolder(@NonNull View itemView) {
            super(itemView);
            tv_photo_name=itemView.findViewById(R.id.tv_photo_name);
            ig_photo_tv=itemView.findViewById(R.id.ig_photo_tx);
            ig_photo_bg=itemView.findViewById(R.id.ig_photo_bg);
        }
    }

    public Dialog showDialog(final Context context){
        final Dialog dialog=new Dialog(context);
        Button button=new Button(context);
        button.setTextColor(Color.BLACK);
        button.setText("更换我的封面");
        button.setTextSize(15);
        button.setBackgroundColor(Color.alpha(0));
        dialog.setContentView(button);
        dialog.show();
        WindowManager.LayoutParams layoutParams=dialog.getWindow().getAttributes();
        layoutParams.width=600;
        layoutParams.height=150;
        Window window =dialog.getWindow();
        window.setBackgroundDrawableResource(R.drawable.circular_10_ffffff);
        window.setAttributes(layoutParams);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, PhotoBgAct.class);
                context.startActivity(intent);
                dialog.dismiss();
            }
        });
        return dialog;
    }

    public Dialog showDialog(String title, int layout, final int position){

        TextView tv_dialog_title;
        Button btn_dialog_cancel,btn_dialog_confirm;

        final Dialog dialog=new Dialog(context);
        View view=LayoutInflater.from(context).inflate(layout,null);
        dialog.setContentView(view);
        tv_dialog_title=view.findViewById(R.id.tv_dialog_title);
        btn_dialog_cancel=view.findViewById(R.id.btn_dialog_cancel);
        btn_dialog_confirm=view.findViewById(R.id.btn_dialog_confirm);
        btn_dialog_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_dialog_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoList.remove(position);
                if(dialog!=null){
                    dialog.dismiss();
                }
                notifyDataSetChanged();
            }
        });
        tv_dialog_title.setText(title);
        Window window=dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();
        return dialog;
    }

}
