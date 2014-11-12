package com.wimc.twodgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Sprite 
{
	int x,y;
	int height,width;
	int vx,vy;
	Bitmap image;
	int timeToAppear;
	
	public Sprite(int x, int y, int height, int width, int vx, int vy,Bitmap image,int timeToAppear)
	{
		super();
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.vx = vx;
		this.vy = vy;
		this.image = image;
		this.timeToAppear = timeToAppear;
	}

	
	Rect getRect()
	{
		Rect r =  new Rect(x,y,x+width,y+height);
		return r;
	}
	
	void draw(Canvas canvas)
	{
		if(timeToAppear <= 0)
		{
			canvas.drawBitmap(image, x, y, new Paint());
		}
	}
	
	void moveUp()
	{
		y = y - vy;
		
	}
}
