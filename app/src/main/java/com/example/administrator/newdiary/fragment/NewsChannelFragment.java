package com.example.administrator.newdiary.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.newdiary.R;


public class NewsChannelFragment extends Fragment {

	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
	}
	private String title;
	
	@Override
	public void setArguments(Bundle bundle) {
		// TODO Auto-generated method stub
		title=bundle.getString("title");
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
			view=inflater.inflate(R.layout.channel_fragment, null);
			((TextView)view.findViewById(R.id.tvTitle)).setText(title);
			
		}
		ViewGroup parent=(ViewGroup)view.getParent();
		if(parent!=null) parent.removeView(view);
		return view;
	}
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}

}
