package com.vaby.onlineshopping;

import java.util.ArrayList;

import com.vaby.onlineshopping.controller.CatagoryController;
import com.vaby.onlineshopping.controller.ProductController;
import com.vaby.onlineshopping.model.Catagory;
import com.vaby.onlineshopping.model.Product;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText editTextId,editTextName,editTextPrice,editTextQuantity,editTextDate;
	Spinner spinnerCat;
	Button buttonSelect,buttonAdd;
	
	ArrayList<Catagory> listCatagory;
	ArrayAdapter<Product> adapter;
	ArrayAdapter<Catagory> adapterCatagory;
	CatagoryController catagoryController;
	ProductController productController;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editTextName = (EditText)findViewById(R.id.editText1);
		editTextPrice = (EditText)findViewById(R.id.editText2);
		editTextQuantity = (EditText)findViewById(R.id.editText3);
		editTextDate = (EditText)findViewById(R.id.editText4);
		editTextId = (EditText)findViewById(R.id.editText5);
		spinnerCat = (Spinner)findViewById(R.id.spinner1);
		buttonSelect=(Button)findViewById(R.id.button1);
		buttonAdd = (Button)findViewById(R.id.button2);
		
		catagoryController = new CatagoryController(this);
		productController = new ProductController(this);
		listCatagory = catagoryController.getAllCatagory();
		adapterCatagory = new ArrayAdapter<Catagory>(this,android.R.layout.simple_spinner_item,listCatagory);
		spinnerCat.setAdapter(adapterCatagory);	
		
		buttonAdd.setOnClickListener(new OnClickListener()
		{	
			@Override
			public void onClick(View v) 
			{
				String name = editTextName.getText().toString();
				int id = Integer.parseInt(editTextId.getText().toString());
				int quantity = Integer.parseInt(editTextQuantity.getText().toString());
				double price = Double.parseDouble(editTextPrice.getText().toString());
				String date = editTextDate.getText().toString();
				
				Catagory dept = (Catagory) spinnerCat.getSelectedItem();
				
				Product product = new Product(id,name,price,quantity,date);
				long r = productController.insertProduct(product);
				if(r != -1)
				{
					Toast.makeText(MainActivity.this,"Inserted successfully",Toast.LENGTH_SHORT).show(); 
					
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.option_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		int i = item.getItemId();
		switch (i)
		{
		case R.id.item1:
			Intent intent=new Intent(MainActivity.this,ReportActivity.class );
			startActivity(intent);			
			break;

		default:
			break;
		}
		
		
		return super.onOptionsItemSelected(item);
	}
}
