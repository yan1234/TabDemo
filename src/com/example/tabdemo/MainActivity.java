package com.example.tabdemo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity implements View.OnClickListener{
	
	//����ViewPager�ؼ�
	private ViewPager mViewPager;
	//����FragmentPagerAdapter������
	private FragmentPagerAdapter mAdapter;
	//����Fragment����
	private List<Fragment> fragments = new ArrayList<Fragment>();
	
	private LinearLayout mTab0;
	private LinearLayout mTab1;
	private LinearLayout mTab2;
	private LinearLayout mTab3;
	
	private ImageView imgView1;
	private ImageView imgView2;
	private ImageView imgView3;
	private ImageView imgView4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		//��ʼ������
		initView();
		
		//��ʼ��ʱ��
		initEvent();
		
		//���ó�ʼҳ��Ϊ�ڶ�ҳ
		selectPage(1);
	}

	/**
	 * ��ʼ���¼�
	 */
	private void initEvent() {
		// TODO Auto-generated method stub
		
		//��LinearLayout��ӵ���¼�
		mTab0.setOnClickListener(this);
		mTab1.setOnClickListener(this);
		mTab2.setOnClickListener(this);
		mTab3.setOnClickListener(this);
		//��Ӱ�������
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()){

			@Override
			public Fragment getItem(int arg0) {
				// TODO Auto-generated method stub
				return fragments.get(arg0);
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return fragments.size();
			}
			
		};
		mViewPager.setAdapter(mAdapter);
		
		//ΪViewPager���ҳ��ı�����¼�
		mViewPager.setOnPageChangeListener(new OnPageChangeListener(){
			

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub		
				//����ͼƬ��ʽ
				selectPage(position);
				
			}
			
		});
		
	}
	
	/**
	 * ����λ��������ʾ��ҳ��
	 * @param position����ʼλ�ô�0��ʼ
	 */
	private void selectPage(int position){
		//�������õײ�ͼƬ
		resetImage();
		//����position����ViewPager�ĵ�ǰҳ��
		mViewPager.setCurrentItem(position);
		switch (position){
		case 0:
			imgView1.setImageResource(R.drawable.one);
			break;
		case 1:
			imgView2.setImageResource(R.drawable.two);
			break;
		case 2:
			imgView3.setImageResource(R.drawable.three);
			break;
		case 3:
			imgView4.setImageResource(R.drawable.four);
			break;
		}
			
	}
	
	/**
	 * ���õײ�ͼƬ
	 */
	private void resetImage() {
		// TODO Auto-generated method stub
		imgView1.setImageResource(R.drawable.one_normal);
		imgView2.setImageResource(R.drawable.two_normal);
		imgView3.setImageResource(R.drawable.three_normal);
		imgView4.setImageResource(R.drawable.four_normal);
	}

	/**
	 * ��ʼ������
	 */
	private void initView() {
		// TODO Auto-generated method stub
		mViewPager = (ViewPager)this.findViewById(R.id.id_viewpage);
		
		mTab0 = (LinearLayout)this.findViewById(R.id.id_tab1);
		mTab1 = (LinearLayout)this.findViewById(R.id.id_tab2);
		mTab2 = (LinearLayout)this.findViewById(R.id.id_tab3);
		mTab3 = (LinearLayout)this.findViewById(R.id.id_tab4);
		
		imgView1 = (ImageView)this.findViewById(R.id.id_tab_img1);
		imgView2 = (ImageView)this.findViewById(R.id.id_tab_img2);
		imgView3 = (ImageView)this.findViewById(R.id.id_tab_img3);
		imgView4 = (ImageView)this.findViewById(R.id.id_tab_img4);
		
		//��fragment��ӵ�List<Fragment>
		Tab01 tab01 = new Tab01();
		Tab01 tab02 = new Tab01();
		Tab01 tab03 = new Tab01();
		Tab01 tab04 = new Tab01();
		
		fragments.add(tab01);
		fragments.add(tab02);
		fragments.add(tab03);
		fragments.add(tab04);
		
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		//���ݵ���¼�ִ��ҳ����ת
		Log.i("TabDemo", "view>>>>>>>>>>"+view.getId());
		switch (view.getId()){
		case R.id.id_tab1:
			selectPage(0);
			break;
		case R.id.id_tab2:
			selectPage(1);
			break;
		case R.id.id_tab3:
			selectPage(2);
			break;
		case R.id.id_tab4:
			selectPage(3);
			break;
		}
	}

}
