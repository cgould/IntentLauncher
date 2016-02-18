package com.slide531.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	private Button button;
	private EditText text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		button = (Button) findViewById(R.id.launch_deep_link);
		text = (EditText) findViewById(R.id.deep_link);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String url = text.getText().toString();
				if (url != null && url.length() > 0) {
					try {
						Uri uri = Uri.parse(url);
						Intent intent = new Intent();
						intent.setAction("android.intent.action.VIEW");
						intent.setData(uri);
						startActivity(intent);
					} catch (Exception e) {
						Toast.makeText(MainActivity.this, "Well, that one didn't work...", Toast.LENGTH_SHORT).show();
					}
				}
			}
		});

	}
}
