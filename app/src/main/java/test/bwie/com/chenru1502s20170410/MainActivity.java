package test.bwie.com.chenru1502s20170410;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewpager;

    private List<String> listtitle=new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    private TabLayout tableLayout;
    private MainAdapter mainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initdata();

    }


    private void initdata() {
       inittitle();
        initfragment();
        mainAdapter = new MainAdapter(getSupportFragmentManager(),fragments,listtitle);
      //  mainAdapter.setFragments(fragments);
        viewpager.setAdapter(mainAdapter);
        //设置title滑动
        tableLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
       //设置tabLayout
        tableLayout.setupWithViewPager(viewpager);
        tableLayout.setTabsFromPagerAdapter(mainAdapter);
        //设置文字的颜色
        tableLayout.setTabTextColors(Color.GRAY, Color.RED);
        //设置下划线的颜色
      tableLayout.setSelectedTabIndicatorColor(Color.RED);

   }

    private void initfragment() {
        fragments.add(MyFragment.newInstance(Url.url1));
        fragments.add(MyFragment.newInstance(Url.url2));
        fragments.add(MyFragment.newInstance(Url.url3));
        fragments.add(MyFragment.newInstance(Url.url4));
        fragments.add(MyFragment.newInstance(Url.url5));
        fragments.add(MyFragment.newInstance(Url.url6));
        fragments.add(MyFragment.newInstance(Url.url7));
        fragments.add(MyFragment.newInstance(Url.url8));
        fragments.add(MyFragment.newInstance(Url.url9));
        fragments.add(MyFragment.newInstance(Url.url10));

    }

    private void inittitle() {
        listtitle.add("头条");
        listtitle.add("社会");
        listtitle.add("国内");
        listtitle.add("国际");
        listtitle.add("娱乐");
        listtitle.add("体育");
        listtitle.add("军事");
        listtitle.add("科技");
        listtitle.add("音乐");
        listtitle.add("科技");
    }
    private void initview() {
        tableLayout = (TabLayout) findViewById(R.id.tablayout);

        viewpager = (ViewPager) findViewById(R.id.viewpager);

  }
}
