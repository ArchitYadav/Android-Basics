package com.vaby.newanimation;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	ListView listView;
	String City[]={"Pune","Indore","Mumbai","Chennai","Goa"};
	ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView = (ListView)findViewById(R.id.listView1);
		adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1 ,City);
		
		listView.setAdapter(adapter);
		
		
				Animation anim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.set);
				listView.setAnimation(anim);
				
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
