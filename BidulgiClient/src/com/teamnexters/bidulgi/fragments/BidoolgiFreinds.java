package com.teamnexters.bidulgi.fragments;

import java.util.ArrayList;

import com.teamnexters.bidulgi.client.ClickFriendActivity;
import com.teamnexters.bidulgi.client.DialogLongClickFriend;
import com.teamnexters.bidulgi.client.R;
import com.teamnexters.bidulgi.list.ListViewAdapter;
import com.teamnexters.bidulgi.list.ListViewItem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class BidoolgiFreinds extends Fragment {
	ListView listView;
	private String name;
	Intent intent;

	private ArrayList<ListViewItem> data;
	private ListViewAdapter adapter;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		ListView listView = (ListView) getView().findViewById(R.id.listview);

		data = new ArrayList<>();
		ListViewItem test1 = new ListViewItem(R.drawable.user01, "착한남자 비둘기" , "전역자");
		ListViewItem test2 = new ListViewItem(R.drawable.user02, "집으로 비둘기" , "전역자");
		ListViewItem test3 = new ListViewItem(R.drawable.user03, "공길이 비둘기", "전역자");
		ListViewItem test4 = new ListViewItem(R.drawable.user04, "발리에서 생긴 비둘기", "전역자");
		ListViewItem test5 = new ListViewItem(R.drawable.user05, "시크릿 가든 비둘기", "전역자");

		data.add(test1);
		data.add(test2);
		data.add(test3);
		data.add(test4);
		data.add(test5);

		adapter = new ListViewAdapter(getView().getContext(), R.layout.fragment_list, data);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(onItemClickListener);
		listView.setOnItemLongClickListener(onItemLongClickListener);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View moodView = inflater.inflate(R.layout.fragment_friends, container, false);

		return moodView;
	}

	public void addData(String name, String date) {

		Log.d("aaaa", "넘어온 String 값은 " + name);
		if (name.equals("나둘기")) {
			ListViewItem test1 = new ListViewItem(R.drawable.user06, name , "복무중ㅠ.ㅠ");

			data.add(test1);

			adapter.notifyDataSetChanged();
		} else {
			ListViewItem test1 = new ListViewItem(R.drawable.ic_launcher, name , date);

			data.add(test1);

			adapter.notifyDataSetChanged();
		}

	}

	public void deleteData(int position) {
		data.remove(position);
		adapter.notifyDataSetChanged();

	}

	OnItemClickListener onItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			// TODO Auto-generated method stub
			intent = new Intent(getView().getContext(), ClickFriendActivity.class);
			intent.putExtra("icon", data.get(position).getIcon());
			intent.putExtra("name", data.get(position).getName());
			startActivity(intent);
		}

	};

	OnItemLongClickListener onItemLongClickListener = new OnItemLongClickListener() {

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
			// TODO Auto-generated method stub

			intent = new Intent(getView().getContext(), DialogLongClickFriend.class);
			intent.putExtra("position", position);
			startActivityForResult(intent, 0);

			Log.d("aaaa", "LongClick리스너 실행 position 값은 " + position);
			return true;
		}

	};

}