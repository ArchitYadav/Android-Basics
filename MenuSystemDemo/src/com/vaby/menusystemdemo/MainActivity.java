package com.vaby.menusystemdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView text;
	ImageView imageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		text = (TextView)findViewById(R.id.textView1);
		imageView = (ImageView) findViewById(R.id.imageView1);
		
		registerForContextMenu(imageView);   //For generating context menu.
		registerForContextMenu(text);
	}

	// to attach context menu with the views
	// executed for registered context menu and when on long pressed on selected item 
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo)
	{
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
		int viewId = v.getId();
		
		switch (viewId){
		case R.id.textView1:
			inflater.inflate(R.menu.textmenu, menu);
			break;
			
		case R.id.imageView1:
			inflater.inflate(R.menu.imagemenu, menu);
		default:
			break;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mainmenu, menu);
		Toast.makeText(this,"Options",Toast.LENGTH_LONG).show();
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		int id = item.getItemId();
		
		switch (id){
		case R.id.menuClose:
			
			finish();
			break;

		case R.id.menuNext:
			Toast.makeText(this,"Next",Toast.LENGTH_LONG).show();
			Intent intent = new Intent(MainActivity.this,StudentListActivity.class);
			startActivity(intent);
			break;
		case R.id.menuHelp:
			Toast.makeText(this,"Help",Toast.LENGTH_LONG).show();
			break;	
		case R.id.menuSetting:
			Toast.makeText(this,"Setting",Toast.LENGTH_LONG).show();
			break;
		
		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item)
	{
		int id = item.getItemId();
		switch (id) {
		case R.id.menuRed:
			text.setTextColor(Color.RED);			
			break;

		case R.id.menuGreen:
			text.setTextColor(Color.GREEN);			
			break;	
			
		case R.id.menuBlue:
			text.setTextColor(Color.BLUE);			
			break;
	
		case R.id.menuMyball:
			imageView.setImageResource(R.drawable.i1);			
			break;
			
		case R.id.menuTeddy:
			imageView.setImageResource(R.drawable.i2);			
			break;
			
		case R.id.menuGreenBlack:
			imageView.setImageResource(R.drawable.i3);			
			break;
	
		default:
			break;
		}
		return super.onContextItemSelected(item);
	}
}
