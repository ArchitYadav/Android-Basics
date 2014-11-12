package com.vaby.fragementdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class AddFragment extends android.support.v4.app.Fragment
{
	EditText editTextName,editTextPrice,editTextQuantity;
	Button buttonAdd;
	
	// attach layout or user inteface with fragment it takes xml and return a view
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
	{
		View myView = inflater.inflate(R.layout.addfragement,container,false);
		editTextName =(EditText)myView.findViewById(R.id.editText1);
		editTextPrice=(EditText)myView.findViewById(R.id.editText2);
		editTextQuantity =(EditText)myView.findViewById(R.id.editText3);
		buttonAdd = (Button)myView.findViewById(R.id.button1);
		
	buttonAdd.setOnClickListener(new OnClickListener()
	{
		@Override
		public void onClick(View v)
		{
			String name = editTextName.getText().toString();
			String price =editTextPrice.getText().toString();
			String quantity = editTextQuantity.getText().toString();
			
			String item = name+":"+price+":"+quantity;
	
			/*MainActivity mainAct = (MainActivity) getActivity(); 
			//returns referance of the activity on which it is loaded from.
			
			mainAct.listItems.add(item);
 		}*/
			DynamicMainActivity mainAct = (DynamicMainActivity) getActivity();
			mainAct.listItems.add(item);}
	});	
	
	
		return myView;
	}
}
