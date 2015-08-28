package com.teamnexters.bidulgi.client;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.teamnexters.bidulgi.client.network.HttpRequestThread;
import com.teamnexters.bidulgi.client.ui.UIHandlingActivity;
import com.teamnexters.bidulgi.common.request.BidulgiRequestCode;
import com.teamnexters.bidulgi.common.request.LoginRequestPacket;
import com.teamnexters.bidulgi.common.response.BidulgiResponseCode;
import com.teamnexters.bidulgi.common.response.BidulgiResponsePacket;

public class MainActivity extends UIHandlingActivity {

	Intent intent;
	EditText editEmail;
	EditText editPassWord;
	Button btnLogin;
	Button btnSignUp;

	String email;
	String passWord;
	private SharedPreferences pref;
	private static final int RESPONSE_LOGIN_FAIL = 3;
	private static final int RESPONSE_LOGIN_SUCCESS = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("aaaa", "로딩 후 들어옴");

		pref = getSharedPreferences("email", Activity.MODE_PRIVATE);
		Log.d("pref", "pref 값은 " + pref.getString("email", "Nothing"));
		if (pref.contains("email")) {
			LoginRequestPacket request = new LoginRequestPacket();
			request.setEmail(pref.getString("email", null));
			request.setPassword(pref.getString("password", null));
			request.setRequestCode(BidulgiRequestCode.REQUEST_LOGIN);
			HttpRequestThread.getInstance().addRequest(request);
			intent = new Intent(getApplicationContext(), ClientActivity.class);
			startActivity(intent);
			finish();
		} else {
			Typeface typeface = Typeface.createFromAsset(getAssets(), "NANUMGOTHIC.TTF");
			setContentView(R.layout.activity_main);
			editEmail = (EditText) findViewById(R.id.editEmail);
			editEmail.setTypeface(typeface);
			editPassWord = (EditText) findViewById(R.id.editPassWord);
			btnLogin = (Button) findViewById(R.id.btnLogin);
			btnSignUp = (Button) findViewById(R.id.btnSignUp);

			btnLogin.setOnClickListener(onClickListener);
			btnSignUp.setOnClickListener(onClickListener);
		}

	}

	@Override
	public void onHandleUI(BidulgiResponsePacket response) {
		Log.d("aaa", "res : " + String.valueOf(response.getResponseCode()));
		Log.d("aaa", "val : " + String.valueOf(BidulgiResponseCode.RESPONSE_LOGIN_SUCCESS));
		switch (response.getResponseCode()) {
		case RESPONSE_LOGIN_SUCCESS:
			Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
			pref = getSharedPreferences("email", Activity.MODE_PRIVATE);
			SharedPreferences.Editor editor = pref.edit();
			editor.putString("email", editEmail.getText().toString());
			editor.putString("password", editPassWord.getText().toString());
			Log.d("aaaa", "로그인 ID는 " + editEmail.getText().toString());
			editor.commit();
			intent = new Intent(getApplicationContext(), ClientActivity.class);
			startActivity(intent);
			finish();
			break;
			
		case RESPONSE_LOGIN_FAIL:
			Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호를 잘못 입력하셨습니다. ", Toast.LENGTH_SHORT).show();
			break;
		}
	}

	protected OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			
			// TODO Auto-generated method stub
			// 로그인 버튼 클릭시 올바른 입력 여부 확인 및 로그인
			if (v.getId() == R.id.btnLogin) {
				
				if (editEmail.getText().toString().length() != 0) {
					if (editPassWord.getText().toString().length() != 0) {
						email = editEmail.getText().toString();
						passWord = editPassWord.getText().toString();

						LoginRequestPacket request = new LoginRequestPacket();
						request.setEmail(email);
						request.setPassword(passWord);
						request.setRequestCode(BidulgiRequestCode.REQUEST_LOGIN);
						HttpRequestThread.getInstance().addRequest(request);
						Log.d("aaaa", "버튼 클릭 후 서버에 request 보냄");

					} else {
						Toast.makeText(getApplicationContext(), "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
					}
				} else {
					Toast.makeText(getApplicationContext(), "이메일을 입력하세요.", Toast.LENGTH_SHORT).show();
				}

				// 회원가입 버튼 클릭 시 이용약관 화면으로 이동
			} else if (v.getId() == R.id.btnSignUp) {
				try{
				intent = new Intent(getApplicationContext(), AgreeActivity.class);
				startActivity(intent);
				finish();
				}catch(Exception e){
					Log.d("aaaa", "error 2 : " + e.toString());
				}
			}

		}

	};

}