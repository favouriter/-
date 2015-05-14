package com.example.doubledrawerlayout;

import java.util.List;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.telephony.CellInfo;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class MainActivity extends FragmentActivity {

	/**
	 * 侧滑组件
	 */
	@InjectView(R.id.maindrawer)
	DrawerLayout mindrawer;

	/**
	 * 主布局
	 */
	@InjectView(R.id.mainlayou)
	RelativeLayout mainlayout;
	/**
	 * 放缩比例，
	 */
	private float scale;
	/**
	 * 开始放缩比例
	 */
	private float basescale = 0.9f;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.inject(this);
		// 初始化控件
		// initView();
		// 注册滑动布局监听
		initDrawerListenner();
//		getDeviceID(MainActivity.this);
	}

	// @SuppressLint("NewApi")
	/**
	 * 注册滑动组件监听
	 */
	private void initDrawerListenner() {
		// TODO Auto-generated method stub
		// 滑动组件添加监听事件
		mindrawer.setDrawerListener(new DrawerListener() {

			@Override
			public void onDrawerStateChanged(int arg0) {
				// TODO Auto-generated method stub
				System.out.println("change:"+arg0);
			}

			@SuppressLint("NewApi")
			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
				// TODO 正在滑动监听方法
				/*
				 * drawerView:滑动的视图左侧或者右侧 slideOffset:滑动进度值
				 */
				// 设置滑动时滑动视图的透明度
				drawerView.setAlpha(slideOffset);
				// 判断滑动的视图
				if (drawerView.getTag().equals("Left")) {
					// 设置X轴中心点
					mainlayout.setPivotX(mainlayout.getMeasuredWidth());
					// 如果滑动的是左视图，主布局向右移动当前滑动的距离(当前移动的距离=移动的视图drawerView*移动进度值slideOffset)
					mainlayout.scrollTo(
							(int) (drawerView.getMeasuredWidth() * -slideOffset),
							0);
				} else if (drawerView.getTag().equals("Right")){
					// 设置X轴中心点
					mainlayout.setPivotX(0);
					// 如果滑动的是右视图，主布局向左移动
					mainlayout.scrollTo(
							(int) (drawerView.getMeasuredWidth() * slideOffset),
							0);
				}
				// 设置Y轴中心点
				mainlayout.setPivotY(mainlayout.getMeasuredHeight() / 2);
				// 放缩比例值从原始值到1.0
				scale = (1 - basescale) * (1 - slideOffset) + basescale;
				// 设置水平放缩比例值
				mainlayout.setScaleX(scale);
				// 设置垂直放缩比例值
				mainlayout.setScaleY(scale);
			}

			@Override
			public void onDrawerOpened(View arg0) {
				// TODO Auto-generated method stub
				System.out.println("onDrawerOpened:"+arg0);
			}

			@Override
			public void onDrawerClosed(View arg0) {
				// TODO Auto-generated method stub
				System.out.println("onDrawerClosed:"+arg0);
			}
		});
	}

	// 右侧按钮方法
	public void openright(View v) {
		// 打开右侧视图
		mindrawer.openDrawer(Gravity.RIGHT);
	}

	// 左侧按钮方法
	public void openleft(View v) {
		// 打开左侧视图
		mindrawer.openDrawer(Gravity.LEFT);
	}
	
	//获取设备ID
	private String getDeviceID(Context context){
		TelephonyManager tm=(TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		//设备ID
		System.out.println("device:"+tm.getDeviceId());
		//设备软件版本
		System.out.println("DeviceSoftwareVersion:"+tm.getDeviceSoftwareVersion());
		System.out.println("GroupIdLevel1:"+tm.getGroupIdLevel1());
		//当前使用手机号
		System.out.println("Line1Number():"+tm.getLine1Number());
		//获取国别码
		System.out.println("NetworkCountryIso:"+tm.getNetworkCountryIso());
		//获取网络营运商代码
		System.out.println("NetworkOperator():"+tm.getNetworkOperator());
		//获取网路营运商名称
		System.out.println("NetworkOperatorName"+tm.getNetworkOperatorName());
		//获取SIM卡国别
		System.out.println("SimCountryIso:"+tm.getSimCountryIso());
		//获取SIM卡营运商代码
		System.out.println("SimOperator():"+tm.getSimOperator());
		//获取SIM卡营运商名称
		System.out.println("SimOperatorName():"+tm.getSimOperatorName());
		//获取SIM卡的序列号
		System.out.println("SimSerialNumber:"+tm.getSimSerialNumber());
		//全球用户识别卡
		System.out.println("SubscriberId:"+tm.getSubscriberId());
		//语音信箱标签
		System.out.println("VoiceMailAlphaTag:"+tm.getVoiceMailAlphaTag());
		return tm.getDeviceId();
	}
}