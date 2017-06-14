package com.NguyenHuynhHuy.webbrowser;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class ActivitySub1 extends Activity {

	public EditText inputUrl;
	public WebView mainView;
	public Button btnmenu;
	public Button btnpd;

	public void getElements() {

		inputUrl = (EditText) findViewById(R.id.inputUrlsub1);
		mainView = (WebView) findViewById(R.id.mainViewsub1);
		btnmenu = (Button) findViewById(R.id.btnmenusub1);
		btnpd = (Button) findViewById(R.id.btnpagedu);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_sub1);
		getElements();

		Intent intent = getIntent();
		String url = intent.getStringExtra("url").toString();
		inputUrl.getText().clear();
		inputUrl.setText(url);

		mainView.getSettings().setLoadsImagesAutomatically(true);
		mainView.getSettings().setJavaScriptEnabled(true);
		mainView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		mainView.loadUrl(url);

		mainView.setWebViewClient(new myBrowser());
		btnmenu.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("NewApi")
			@Override
			public void onClick(View view) {
				// Khởi tạo 1 popupmenu
				PopupMenu popupMenu = new PopupMenu(getApplicationContext(),
						btnmenu);
				// đẩy layout của mình vừa tạo ở trên vào ứng dụng
				popupMenu.getMenuInflater().inflate(R.menu.menu_web,
						popupMenu.getMenu());
				// Sự kiện click vào item của menu
				popupMenu
						.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
							@Override
							public boolean onMenuItemClick(MenuItem menuItem) {
								if (menuItem.getItemId() == R.id.item1) {
									Toast.makeText(
											ActivitySub1.this,
											"Please wait when system is executioning : "
													+ menuItem.getTitle(),
											Toast.LENGTH_SHORT).show();
									backUrl();
								}
								if (menuItem.getItemId() == R.id.item2) {
									Toast.makeText(
											ActivitySub1.this,
											"Please wait when system is executioning : "
													+ menuItem.getTitle(),
											Toast.LENGTH_SHORT).show();
									forwardUrl();
								}
								if (menuItem.getItemId() == R.id.item3) {
									Toast.makeText(
											ActivitySub1.this,
											"Please wait when system is executioning : "
													+ menuItem.getTitle(),
											Toast.LENGTH_SHORT).show();
									refresh();

								}

								if (menuItem.getItemId() == R.id.item5) {
									Toast.makeText(
											ActivitySub1.this,
											"Please wait when system is executioning : "
													+ menuItem.getTitle(),
											Toast.LENGTH_SHORT).show();
									// to do some thing here!
									Intent intent = new Intent(
											ActivitySub1.this,
											ActivityHome.class);
									startActivity(intent);
								}

								if (menuItem.getItemId() == R.id.item4) {
									Toast.makeText(
											ActivitySub1.this,
											"Please wait when system is executioning : "
													+ menuItem.getTitle(),
											Toast.LENGTH_SHORT).show();
									showUrl();
								}

								return true;
							}
						});
				popupMenu.show();
			}
		});

		btnpd.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (btnpd.getText() == "↓") {
					mainView.pageDown(true);
					btnpd.setText("↑");
				} else {
					mainView.pageUp(true);
					btnpd.setText("↓");
				}

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sub1, menu);
		return true;
	}

	public String geturlfromhome() {
		Intent intent = getIntent();
		String url = intent.getStringExtra("url").toString();
		inputUrl.getText().clear();
		inputUrl.setText(url);
		return url;
	}

	// Method Show web from url input
	@SuppressLint("SetJavaScriptEnabled")
	private void showUrl() {
		String url = inputUrl.getText().toString().trim();

		mainView.getSettings().setLoadsImagesAutomatically(true);
		mainView.getSettings().setJavaScriptEnabled(true);
		mainView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		mainView.loadUrl(url);
	}

	// Method for btnback
	private void backUrl() {
		mainView.goBack();
		inputUrl.setText(mainView.getUrl());
	}

	// Method for forwark
	private void forwardUrl() {
		mainView.goForward();
		inputUrl.setText(mainView.getUrl());
	}

	private void refresh() {
		mainView.reload();
	}

	private class myBrowser extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String Url) {
			view.loadUrl(Url);
			inputUrl.setText(Url);
			return true;
		}
	}

}
