package test.bwie.com.chenru1502s20170410;

import android.content.Context;
import android.os.Message;
import android.widget.ListView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * date: 2017/4/10
 * author:陈茹
 * 类的用途:
 */

public class MyXutils   {
    private ListView listview;
    private Context context;

    public MyXutils(ListView listview,Context context) {
        this.listview = listview;
        this.context=context;
    }
    public  void getdata(String uri){
        RequestParams params = new RequestParams(uri);
      //  params.addQueryStringParameter("username","abc");
      //  params.addQueryStringParameter("password","123");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Gson gson = new Gson();
                GsonBean gsonBean = gson.fromJson(result, GsonBean.class);
              if (gsonBean !=null){

                  List<GsonBean.ResultBean.DataBean> list = gsonBean.getResult().getData();
                  if (list.size()!=0) {
                      Myadapter adapter = new Myadapter(context,list);
                      listview.setAdapter(adapter);
                  }
              }
                //解析result
            }
            //请求异常后的回调方法
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }
            //主动调用取消请求的回调方法
            @Override
            public void onCancelled(CancelledException cex) {
            }
            @Override
            public void onFinished() {
            }
        });
    }
}
