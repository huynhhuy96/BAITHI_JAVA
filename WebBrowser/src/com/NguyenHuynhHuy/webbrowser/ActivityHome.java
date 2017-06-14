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

	public void getElements() {

		inputUrl = (EditText) findViewById(R.id.inputUrl);
		btnmenu = (Button) findViewById(R.id.btnmenuHome);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_home);
		getElements();
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
								if (menuItem.getItemId() == R.id.gopage) {
									Toast.makeText(
											ActivityHome.this,
											"Please wait when system is executioning : "
													+ menuItem.getTitle(),
											Toast.LENGTH_SHORT).show();
									Intent myIntent = new Intent(
											ActivityHome.this,
											MainActivity.class);
									ActivityHome.this.startActivity(myIntent);
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
}
