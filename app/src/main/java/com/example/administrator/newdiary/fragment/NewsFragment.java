package com.example.administrator.newdiary.fragment;

import java.util.ArrayList;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.newdiary.R;
import com.example.administrator.newdiary.adapter.NewsFragmentPagerAdapter;


public class NewsFragment extends Fragment {


	private ViewPager mViewPager;
//	private PagerTabStrip mTabs; 
	private List<String> tabs;
	private List<Fragment> fragmentList;
	private NewsFragmentPagerAdapter adapter;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	private View view;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if(view==null){
			view=inflater.inflate(R.layout.news_fragment, null);
			mViewPager=(ViewPager)view.findViewById(R.id.pager);
			initViewPager();
		}
		ViewGroup parent=(ViewGroup)view.getParent();
		if(parent!=null) parent.removeView(view);
		return view;
	}
	private void initViewPager(){
		setTabs();
		setFragments();
		adapter=new NewsFragmentPagerAdapter(super.getActivity().getSupportFragmentManager(), 
				fragmentList, tabs);
		mViewPager.setAdapter(adapter);
	}
	
	private void setFragments(){
		fragmentList=new ArrayList<Fragment>();
		for(int i=0;i<tabs.size();i++){
			NewsChannelFragment fragment=new NewsChannelFragment();
			Bundle bundle=new Bundle();
			bundle.putString("title", tabs.get(i)+"区域");
			fragment.setArguments(bundle);
			fragmentList.add(fragment);
			
		}
	}
	private void setTabs(){
		tabs=new ArrayList<String>();
		tabs.add("头条");
		tabs.add("娱乐");
		tabs.add("体育");
		tabs.add("财经");
		tabs.add("热点");
		tabs.add("科技");
	}
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}

}
