package com.example.doubledrawerlayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RightLayout extends Fragment {
	private View mainview;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mainview = inflater.inflate(R.layout.right_layout, null);
		return mainview;
	}
	
}
