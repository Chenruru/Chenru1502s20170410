package test.bwie.com.chenru1502s20170410;

import android.app.Fragment;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * date: 2017/4/10
 * author:陈茹
 * 类的用途:
 */

public class Myadapter extends BaseAdapter {
    List<GsonBean.ResultBean.DataBean> list;
    private Context context;
    public  Myadapter(Context context,List<GsonBean.ResultBean.DataBean> list){
        this.context=context;
        this.list=list;

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
      convertView=View.inflate(context,R.layout.fragment_,null);
           ImageView imageview= (ImageView) convertView.findViewById(R.id.imageview);
            TextView textView= (TextView) convertView.findViewById(R.id.textView);

            textView.setText(list.get(position).getTitle());

            x.image().bind(imageview,list.get(position).getThumbnail_pic_s(),new ImageOptions.Builder()
                  //  .setSize(screenWidth,screenHeight*85/100)
                    .setCrop(true)
                    .build());

        }
        return convertView;
    }
}
