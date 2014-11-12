/*AlertDialogueBox class can not be instantiated
   so we need use Builder to instantiate the object of AlertDialogueBox     
*/
package com.vaby.alertdialoguebox;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.shapes.ArcShape;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView textView;
	Button buttonShow,buttonSelectCity,buttonEducation;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView =(TextView)findViewById(R.id.textView1 );
		buttonShow = (Button)findViewById(R.id.button1);
		buttonSelectCity = (Button)findViewById(R.id.button2);
		buttonEducation = (Button)findViewById(R.id.button3);
		
		buttonShow.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
			
				builder.setTitle("Movie Today ??");
				builder.setMessage("Godzilla");
				builder.setPositiveButton("Yes!!",new DialogInterface.OnClickListener() // second argument will take task u will perform based upon 1st argument
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{					
						Toast.makeText(MainActivity.this,"Yes Of course!!" ,Toast.LENGTH_SHORT).show();
					}
				});  
				builder.setNegativeButton("No",new DialogInterface.OnClickListener()
				{
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
					
						Toast.makeText(MainActivity.this,"Dont have time Sorry.", Toast.LENGTH_SHORT).show();
					}
				});
				builder.setNeutralButton("Later",null);
				
				AlertDialog dialog = builder.create(); // generate dialgue box based on information provided
				dialog.show();
			}
		});
		
		buttonSelectCity.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				final String arrayCity []={"Pune","Delhi","Mumbai","Chennai","Dehradun","Patna"};  
				
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
			
				builder.setTitle("Select City");
				builder.setItems(arrayCity,new DialogInterface.OnClickListener()
				{					
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						// fetch data from array of cities
						textView.setText(arrayCity[which]);
					}
				});
				
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
		
		buttonEducation.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				final String arrayEducation []={"Doctor","Engineer","Scientist","Professor","Carpenter","Barber"};  
				
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				
				builder.setTitle("Select Profession");
				final boolean bselected[] ={false,false,true,false,true,true}; 
				
				builder.setMultiChoiceItems(arrayEducation, bselected,
						new DialogInterface.OnMultiChoiceClickListener()
				// arg1 = to show the bydefault check box values either checked on uncheked andit is bool array
				{
					@Override
					public void onClick(DialogInterface dialog, int which, boolean isChecked)
					{
						bselected[which] = isChecked;
					}
				});
				builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
				{
					
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						
						String strEdu="";
						for(int i=0;i<bselected.length;i++)
						{
							if(bselected[i])
							{
								strEdu = strEdu+" " +arrayEducation[i];
							}
						}
						textView.setText(strEdu);
						//Toast.makeText(MainActivity.this, strEdu,5).show();
					}
				}); // so we can go on main GUI page				
				AlertDialog dialog = builder.create();
				dialog.show();
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
