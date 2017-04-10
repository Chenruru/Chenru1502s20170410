package test.bwie.com.chenru1502s20170410;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

/**
 * date: 2017/4/10
 * author:陈茹
 * 类的用途:
 */

public class MyFragment extends Fragment {

//    private Handler handler=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            if (msg.what==0){
//                GsonBean obj = (GsonBean) msg.obj;
//                List<GsonBean.ResultBean.DataBean> list = obj.getResult().getData();
//                Myadapter adapter=new Myadapter(getActivity(),list);
//                listview.setAdapter(adapter);
//            }
//        }
//    };
    private ListView listview;
    private String name;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_list, null);
        listview = (ListView) view.findViewById(R.id.listview);
        Bundle bundle = getArguments();
        if (bundle != null) {
            name = bundle.get("name").toString();
            Log.d("MyFragment", name);
        }
        MyXutils x=new MyXutils(listview,getActivity());
            x.getdata(name);

        return view;
    }

    public static MyFragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString("name", name);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);

        return fragment;
    }


}
