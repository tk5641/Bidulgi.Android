package com.teamnexters.bidulgi.fragments;

import java.util.List;

import com.teamnexters.bidulgi.client.ClickFriendActivity;
import com.teamnexters.bidulgi.client.ClickMailActivity;
import com.teamnexters.bidulgi.client.R;
import com.teamnexters.bidulgi.client.SoldierInfoStore;
import com.teamnexters.bidulgi.common.data.MessageData;
import com.teamnexters.bidulgi.common.data.SoldierData;
import com.teamnexters.bidulgi.message.UserMessageAdapter;

import android.content.Context;
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

public class BidoolgiMail extends Fragment {

	private UserMessageAdapter userMessageAdapter;
	private List<MessageData> soldierDataList;
	private ListView listView;
	Intent intent;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		listView = (ListView) getView().findViewById(R.id.messageListMessageListView);

		listView.setBackgroundResource(R.drawable.backgroundWhite);
		if (soldierDataList != null) {
			refreshList(soldierDataList, getActivity());
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View moodView = inflater.inflate(R.layout.fragment_mail, container, false);
		return moodView;
	}

	public void refreshList(List<MessageData> soldierDataList, Context context) {
		// userMessageAdapter.notifyDataSetChanged();
		this.soldierDataList = soldierDataList;
		userMessageAdapter = new UserMessageAdapter(soldierDataList, context);
		if (listView != null) {
			listView.setAdapter(userMessageAdapter);
			listView.setOnItemClickListener(onItemClickListener);
		}
	}

	OnItemClickListener onItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Log.d("aaaa", "메일 리스트 클릭");
			SoldierInfoStore soldierInfoStore = SoldierInfoStore.getInstance();
			intent = new Intent(getView().getContext(), ClickMailActivity.class);
			intent.putExtra("profilePhotoSrc", soldierInfoStore.getData(soldierDataList.get(position).getReceiveSoldierId()).getProfilePhotoSrc());
			intent.putExtra("name", soldierInfoStore.getData(soldierDataList.get(position).getReceiveSoldierId()).getName());
			intent.putExtra("id", soldierDataList.get(position).getReceiveSoldierId());
			Log.d("aaaa", "메일 리스트 클릭시 넘어가는 훈련병 이름 " + soldierInfoStore.getData(soldierDataList.get(position).getReceiveSoldierId()).getName());

			startActivityForResult(intent, 3);
			/*
			 * intent.putExtra("name", data.get(position).getName());
			 * intent.putExtra("regiment", data.get(position).getRegiment());
			 * intent.putExtra("address", data.get(position).getRegiment() +
			 * "연대 " + data.get(position).getCompany() + "소대 " +
			 * data.get(position).getPlatoon() + "분대 " +
			 * data.get(position).getNumber() + "번 훈련병");
			 * intent.putExtra("enterDate", data.get(position).getDate());
			 * intent.putExtra("id", data.get(position).getsoldierId());
			 * startActivity(intent); getActivity().finish();
			 */
		}

	};
}
