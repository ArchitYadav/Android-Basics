package com.vaby.assignday3_3;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity 
{

	TextView productName,Price,Qty;
	Button buttonAdd;
	ListView listViewProducts;
	
	ArrayList<Product> product = new ArrayList<Product>();
	ProductAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		productName = (TextView)findViewById(R.id.editText1);
		Price = (TextView)findViewById(R.id.editText2);
		Qty= (TextView)findViewById(R.id.editText3);
		listViewProducts = (ListView) findViewById(R.id.listView1);
		buttonAdd = (Button)findViewById(R.id.button1);
		
		adapter = new ProductAdapter(this,product);	
		
		Product p1 = new Product("Sony",25000.0,12);
		Product p2 = new Product("Nexus",22000.0,10);

		product.add(p1);
		product.add(p2);
		listViewProducts.setAdapter(adapter);
		
		buttonAdd.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View v)
			{
				String name = productName.getText().toString();
				Double price = Double.parseDouble(Price.getText().toString()); 
				int qty= Integer.parseInt(Qty.getText().toString());
				
				Product p3 = new Product(name,price,qty);
				product.add(p3);
				
				listViewProducts.setAdapter(adapter);
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

class ProductAdapter extends BaseAdapter
{
	Context context;
	ArrayList<Product>listProduct;
	
	
	public ProductAdapter(Context context, ArrayList<Product> listProduct)
	{
		super();
		this.context = context;
		this.listProduct = listProduct;
	}

	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return listProduct.size();
	}

	@Override
	public Object getItem(int position)
	{
		// TODO Auto-generated method stub
		return listProduct.get(position);
	}

	@Override
	public long getItemId(int position) 
	{
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		final Product product = listProduct.get(position);
		LayoutInflater inf = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View myview = inf.inflate(R.layout.product_item_view, null);
		
		
		TextView textViewName = (TextView) myview.findViewById(R.id.textViewName);
		Button details  = (Button)myview.findViewById(R.id.buttonDetails);
		
		textViewName.setText(product.getpName());
	
		details.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Toast.makeText(context,product.toString(),Toast.LENGTH_SHORT).show();
				
				String name = product.getpName();
				Double price = product.getPrice();
				int qty = product.getQty();
				
				Intent intent = new Intent(context,Activity2.class);
				
				intent.putExtra("p", product);
				/*intent.putExtra("name",name);
				intent.putExtra("price",price);
				intent.putExtra("Qty",qty);	
*/				
				context.startActivity(intent);
				
			}
			
		});
		return myview;
	}
}
