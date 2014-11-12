package com.vaby.customadapterdemo;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity
{

	EditText editName,editAge;
	Button buttonAdd;
	ListView listViewPerson;

	ArrayList<Person> listPerson = new ArrayList<Person>();
	PersonAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		editName=(EditText)findViewById(R.id.editText1);
		editAge=(EditText)findViewById(R.id.editText2);
		buttonAdd=(Button)findViewById(R.id.button1);
		listViewPerson=(ListView)findViewById(R.id.listView1);

		adapter = new PersonAdapter(this,listPerson);
		
		Person p1 = new Person("Baba",101);
		Person p2 = new Person("Mama",12);
		
		listPerson.add(p1);
		listPerson.add(p2);
		listPerson.add(new Person("Abhinav",105));
		
		listViewPerson.setAdapter(adapter);
	
	buttonAdd.setOnClickListener(new OnClickListener()
	{
		@Override
		public void onClick(View v)
		{
			String name = editName.getText().toString();
			int age= Integer.parseInt(editAge.getText().toString());
			
			Person p3 = new Person(name,age);
			listPerson.add(p3);
			
			listViewPerson.setAdapter(adapter);
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

class PersonAdapter extends BaseAdapter
{
	Context context;
	ArrayList<Person>listPersons;
	
	
	public PersonAdapter(Context context, ArrayList<Person> listPersons)
	{
		super();
		this.context = context;
		this.listPersons = listPersons;
	}

	@Override
	public int getCount()
	{
		return listPersons.size();
	}

	@Override
	public Object getItem(int position)
	{
		return listPersons.get(position);
	}

	@Override
	public long getItemId(int position) 
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		Person person = listPersons.get(position);
		LayoutInflater inf = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		
		View myview = inf.inflate(R.layout.person_item_view, null);
		
		TextView textName = (TextView) myview.findViewById(R.id.textViewName);
		TextView textAge = (TextView)myview.findViewById(R.id.textViewAge);
		
		textName.setText(person.getName());
		textAge.setText(person.getAge()+"");
		
		return myview;
	}
	
}

