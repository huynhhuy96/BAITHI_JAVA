package com.NguyenHuynhHuy.webbrowser;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	// Variable
	public Button btnGo;
	public EditText inputUrl;
	public WebView mainView;

	public Button btnmenu;

	public void getElements() {
		btnGo = (Button) findViewById(R.id.Go);
		inputUrl = (EditText) findViewById(R.id.txtinputUrl);
		mainView = (WebView) findViewById(R.id.manView);
		btnmenu = (Button) findViewById(R.id.btnmenu);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getElements();
		mainView.setWebViewClient(new myBrowser());
		btnGo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				showUrl();

			}
		});

				
		btnmenu.setOnClickListener(new View.OnClickListener() {
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
								if(menuItem.getItemId()==R.id.item1)
								{
									Toast.makeText(MainActivity.this,
											"Please wait when system is executioning : " + menuItem.getTitle(),
											Toast.LENGTH_SHORT).show();
									backUrl();
								}
								if(menuItem.getItemId()==R.id.item2)
								{
									Toast.makeText(MainActivity.this,
											"Please wait when system is executioning : " + menuItem.getTitle(),
											Toast.LENGTH_SHORT).show();
									forwardUrl();
								}
								if(menuItem.getItemId()==R.id.item3)
								{
									Toast.makeText(MainActivity.this,
											"Please wait when system is executioning : " + menuItem.getTitle(),
											Toast.LENGTH_SHORT).show();
									refresh();
								}
								
								
								return true;
							}
						});
				popupMenu.show();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// Method Get Url from inputUrl
	private String getinputUrl() {
		inputUrl = (EditText) findViewById(R.id.txtinputUrl);
		String Url = inputUrl.getText().toString().trim();
		return Url;
	}

	// Method Show web from url input
	private void showUrl() {
		String url = getinputUrl();
		mainView.getSettings().setLoadsImagesAutomatically(true);
		mainView.getSettings().setJavaScriptEnabled(true);
		mainView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		mainView.loadUrl(url);
	}

	// Method for btnback
	private void backUrl() {
		mainView.goBack();
	}

	// Method for forwark
	private void forwardUrl() {
		mainView.goForward();
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
