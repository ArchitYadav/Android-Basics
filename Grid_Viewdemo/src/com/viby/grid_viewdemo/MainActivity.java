package com.viby.grid_viewdemo;

import java.util.ArrayList;
import java.util.zip.Inflater;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	ArrayList<Photo> listPhoto=new ArrayList<Photo>();	
	GridView gridView;
	PhotoAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gridView =(GridView)findViewById(R.id.gridView1);
	listPhoto.add(new Photo("Baba",R.drawable.i1));
	listPhoto.add(new Photo("mama",R.drawable.i2));
	listPhoto.add(new Photo("Papa",R.drawable.i3));	
	listPhoto.add(new Photo("Abhinav",R.drawable.i4));
	listPhoto.add(new Photo("chch",R.drawable.i5));
	listPhoto.add(new Photo("abhi",R.drawable.i6));	
	listPhoto.add(new Photo("android",R.drawable.ic_launcher));
		
	adapter=new PhotoAdapter(this, listPhoto);	
	gridView.setAdapter(adapter);
	
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Photo photo=(Photo) adapter.getItem(arg2);
				Intent intent=new Intent(MainActivity.this,Activity2.class);
				intent.putExtra("photo", photo);
				startActivity(intent);
				
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

class PhotoAdapter extends BaseAdapter
{

	Context context;
	ArrayList<Photo> listPhoto;
	

	public PhotoAdapter(Context context, ArrayList<Photo> listPhoto) {
		super();
		this.context = context;
		this.listPhoto = listPhoto;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listPhoto.size();
	}
	
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listPhoto.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflator=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View myView=inflator.inflate(R.layout.item_view,null);
		TextView texttitle=(TextView) myView.findViewById(R.id.textView1);
		
		ImageView imageView=(ImageView) myView.findViewById(R.id.imageView1);
		
		Photo photo=listPhoto.get(position);
		texttitle.setText(photo.getNames());
		imageView.setImageResource(photo.getImgId());
	
		
		
		return myView;
	}

	
	
}

