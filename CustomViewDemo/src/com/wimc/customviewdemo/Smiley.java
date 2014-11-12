package com.wimc.customviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class Smiley extends View 
{

	public Smiley(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
		
	}
@Override
protected void onDraw(Canvas canvas) {
	// TODO Auto-generated method stub
	super.onDraw(canvas);
	canvas.drawColor(Color.YELLOW);
	Paint p=new Paint();
	p.setColor(Color.RED);
	canvas.drawCircle(30, 30, 10, p);
	canvas.drawCircle(70, 30, 10, p);
	canvas.drawRect(49, 39, 55, 55, p);
	RectF rf= new RectF(30, 60, 70, 70);
	canvas.drawArc(rf, 0, 180, true, p);
	
	
	
	
}
}
