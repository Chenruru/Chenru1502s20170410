package test.bwie.com.chenru1502s20170410;

import android.app.Application;

import org.xutils.x;

/**
 * date: 2017/4/10
 * author:陈茹
 * 类的用途:
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false); //输出debug日志，开启会影响性能
    }
}
