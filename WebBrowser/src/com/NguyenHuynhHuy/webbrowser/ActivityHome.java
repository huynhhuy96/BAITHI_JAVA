package com.NguyenHuynhHuy.webbrowser;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

@SuppressLint("NewApi")
public class ActivityHome extends Activity {

	public EditText inputUrl;
	public Button btnmenu;
	public Button btnfb;
	public Button btn24h;
	public Button btnurl;
	public Button btnsearch;

	public void getElements() {

		inputUrl = (EditText) findViewById(R.id.inputUrlsub1);
		btnmenu = (Button) findViewById(R.id.btnmenusub1);
		btnfb = (Button) findViewById(R.id.btnFB);
		btn24h = (Button) findViewById(R.id.btn24h);
		btnurl = (Button) findViewById(R.id.btnurl);
		btnsearch = (Button) findViewById(R.id.btnsearch);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_home);
		getElements();
		btnurl.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent myIntent = new Intent(
						ActivityHome.this,
						MainActivity.class);
				ActivityHome.this.startActivity(myIntent);
				
			}
		});
		
		btnmenu.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				PopupMenu popupMenu = new PopupMenu(getApplicationContext(),
						btnmenu);
				popupMenu.getMenuInflater().inflate(R.menu.menu_home,
						popupMenu.getMenu());
				popupMenu
						.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
							@Override
							public boolean onMenuItemClick(MenuItem menuItem) {
								if (menuItem.getItemId() == R.id.exit) {
									Toast.makeText(
											ActivityHome.this,
											"Please wait when system is executioning : "
													+ menuItem.getTitle(),
											Toast.LENGTH_SHORT).show();
									System.exit(0);
									
								}
								return true;
							}
						});
				popupMenu.show();
			}
		});

		btnsearch.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent myIntent = new Intent(ActivityHome.this,
						ActivitySub1.class);
				myIntent.putExtra("url", "https://www.google.com.vn");
				ActivityHome.this.startActivity(myIntent);

			}
		});

		btn24h.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent myIntent = new Intent(ActivityHome.this,
						ActivitySub1.class);
				myIntent.putExtra("url", "http://www.24h.com.vn");
				ActivityHome.this.startActivity(myIntent);

			}
		});
		
		btnfb.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent myIntent = new Intent(ActivityHome.this,
						ActivitySub1.class);
				myIntent.putExtra("url", "https://www.facebook.com/");
				ActivityHome.this.startActivity(myIntent);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
