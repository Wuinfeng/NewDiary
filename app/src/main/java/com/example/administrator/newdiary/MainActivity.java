package com.example.administrator.newdiary;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.newdiary.fragment.FoundFragment;
import com.example.administrator.newdiary.fragment.NewsFragment;
import com.example.administrator.newdiary.fragment.OwnerFragment;
import com.example.administrator.newdiary.fragment.ReadFragment;
import com.example.administrator.newdiary.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private ListView navList;
    private FragmentManager fm;
    private List<Fragment> fragments;
    private ArrayAdapter<String> adapter;
    private ActionBar actionBar;
    private TextView TextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=(DrawerLayout)super.findViewById(R.id.drawer_layout);
        //navList=(ListView)super.findViewById(R.id.left_drawer);
        //navList.setOnItemClickListener(this);
        fragments=new ArrayList<Fragment>();
        fm=super.getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.left_drawer);
        if(fragment == null){
            fragment = new ReadFragment();
            fm.beginTransaction().add(R.id.left_drawer,fragment).commit();
        }


        //initListView();
        initActionBar();
        initDrawerLayout();
        initFragments();
    }
    private String[] tabs=new String[]{"新闻","阅读 ","视听","发现","我的设置 "};
    /**
     初始化drawer的item列表。这要根据你的app内容来处理，但是一个navigation drawer通常由一个ListView组成，所以列表应该通过一个Adapter填入。
     */
    private void initListView(){
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                tabs);
        navList.setAdapter(adapter);

        navList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?>parent,View view,int position,long id){
                Toast.makeText(MainActivity.this,"ddd",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initFragments(){
        //NewsFragment newsFragment=new NewsFragment();
        //fragments.add(newsFragment);
        ReadFragment readFragment=new ReadFragment();
        fragments.add(readFragment);
        VideoFragment videoFragment=new VideoFragment();
        fragments.add(videoFragment);
        FoundFragment foundFragment=new FoundFragment();
        fragments.add(foundFragment);
        OwnerFragment ownerFragment=new OwnerFragment();
        fragments.add(ownerFragment);
        setFragments(0);
    }
    private void setFragments(int position){
        fm.beginTransaction().replace(R.id.content_frame,
                fragments.get(position),"t"+position).commit();
    }
    private void initActionBar(){
        actionBar=super.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setIcon(R.drawable.com_btn);
        actionBar.setTitle(tabs[0]);
    }
    private void initDrawerLayout(){
        toggle=new ActionBarDrawerToggle(this, drawerLayout,
                R.drawable.com_btn, R.string.drawer_open,
                R.string.drawer_close){
            /** 当drawer处于完全关闭的状态时调用 */
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
            /** 当drawer处于完全打开的状态时调用 */
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

        };
        // 设置drawer触发器为DrawerListener
        drawerLayout.setDrawerListener(toggle);
    }
    private void toggleNav(){
        if(drawerLayout.isDrawerOpen(Gravity.START)){
            drawerLayout.closeDrawer(Gravity.START);
        }else{
            drawerLayout.openDrawer(Gravity.START);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                toggleNav();
                break;
        }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
