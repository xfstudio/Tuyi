package dong.lan.tuyi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import dong.lan.tuyi.R;
import dong.lan.tuyi.bean.UserTuyi;
import dong.lan.tuyi.utils.MyImageAsyn;

/**
 * Created by Dooze on 2015/9/9.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private List<UserTuyi> tuyis;
    public RecyclerViewAdapter(Context context,List<UserTuyi> tuyis)
    {
        this.context = context;
        this.tuyis  =tuyis;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int pos) {
        View view = inflater.inflate(R.layout.item_like_tuyi,viewGroup,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int pos) {
        viewHolder.time.setText(tuyis.get(pos).getTime());
        viewHolder.content.setText(tuyis.get(pos).gettContent());
        viewHolder.tag.setText(tuyis.get(pos).getTAG());
            viewHolder.locDes.setText(tuyis.get(pos).getLocDes()+"");

        new MyImageAsyn(viewHolder.pic, MyImageAsyn.NORMAL).execute(tuyis.get(pos).gettPic());

    }

    @Override
    public int getItemCount() {
        return tuyis.size();
    }
}

 class MyViewHolder extends RecyclerView.ViewHolder
{
    TextView time;
    ImageView pic;
    TextView content;
    TextView locDes;
    TextView tag;
    public MyViewHolder(View view)
    {
        super(view);
        time = (TextView) view.findViewById(R.id.item_like_tuyi_time);
        pic = (ImageView) view.findViewById(R.id.item_like_tuyi_pic);
        content = (TextView) view.findViewById(R.id.item_like_tuyi_content);
        locDes  = (TextView) view.findViewById(R.id.item_like_locDes);
        tag = (TextView) view.findViewById(R.id.tuyi_tag);
    }
}
