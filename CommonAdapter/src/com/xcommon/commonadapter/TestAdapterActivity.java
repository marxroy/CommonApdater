package com.xcommon.commonadapter;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class TestAdapterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TestCTSBaseAdapter();
	}

	/**
	 * 测试XBaseAdapter
	 */
	public void TestCTSBaseAdapter() {
		ListView listView = new ListView(this);
		listView.setAdapter(new AdapterUseDemo(this, getdata()));
		setContentView(listView);
	}

	public ArrayList<TestEntity> getdata() {
		ArrayList<TestEntity> list = new ArrayList<TestEntity>();
		TestEntity t1 = new TestEntity();
		t1.netpath = "http://tech.ddvip.com/2011/06/images/tc_logo.jpg";
		t1.resId = R.drawable.ic_launcher;
		TestEntity t2 = new TestEntity();
		t2.netpath = "http://tech.ddvip.com/2011/06/images/tc_logo.jpg";
		t2.resId = R.drawable.common_icon_calendar;

		list.add(t1);
		list.add(t2);
		return list;
	}

}
