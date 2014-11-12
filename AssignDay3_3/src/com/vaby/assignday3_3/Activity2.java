package com.vaby.assignday3_3;

import org.w3c.dom.Text;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends Activity 
{
	TextView textName,textPrice,textQty;
	Button backButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details);

		textName=(TextView)findViewById(R.id.textView1);
		textPrice=(TextView)findViewById(R.id.textView2);
		textQty= (TextView)findViewById(R.id.textView3);
		backButton=(Button)findViewById(R.id.button1);
		
		Intent intent = getIntent();
		Product person = (Product)intent.getSerializableExtra("p");
		/*String name = intent.getStringExtra("name");
		Double price= intent.getDoubleExtra("price",0.0);
		int quantity= intent.getIntExtra("Qty",0);
*/
		textName.setText(person.getpName());
		textPrice.setText(String.valueOf(person.getPrice()));
		textQty.setText(String.valueOf(person.getQty()));
		
		backButton.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
}
