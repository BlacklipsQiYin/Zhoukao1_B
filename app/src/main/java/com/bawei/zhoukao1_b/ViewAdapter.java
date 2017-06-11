package com.bawei.zhoukao1_b;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder>{
private Context rContext;
private List<Students.StudentsBean.StudentBean> rList ;
private LayoutInflater inflater ;
public ViewAdapter(Context context, List<Students.StudentsBean.StudentBean> list){

this.rContext = context;
this.rList = list ;
inflater = LayoutInflater.from(context);
}

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


View view = inflater.inflate(R.layout.itemview, parent, false);

ViewHolder viewHolder = new ViewHolder(view);

return viewHolder;


}

@Override
public void onBindViewHolder(ViewHolder holder, final int position) {


holder.mingzi.setText(rList.get(position).getName());
ImageLoader.getInstance().displayImage(rList.get(position).getImg(), holder.touxiang);

    //条目点击
    holder.touxiang.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            listener.onItemClickListener(position,v);
        }
    });

    holder.mingzi.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            listener.onItemLongClickListener(position,v);
            return true;
        }
    });



}



@Override
public int getItemCount() {
return rList.size();
}

class ViewHolder extends RecyclerView.ViewHolder {

    private TextView mingzi;
    private ImageView touxiang;

    public ViewHolder(View itemView) {
        super(itemView);

        mingzi = (TextView) itemView.findViewById(R.id.mingzi);
        touxiang = (ImageView) itemView.findViewById(R.id.touxiang);

    }
}

    //条目点击
    interface OnItemClickListener {

        void onItemClickListener(int position,View view);
        void onItemLongClickListener(int position,View view);
    }


    public OnItemClickListener listener ;



    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

}