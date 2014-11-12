package com.wimc.twodgame;

import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;

public class GameThread extends Thread 
{
	SurfaceHolder holder;   // it'll give u canvas
	Context context;
	int gameHeight,gameWidth;
	// sprites

	Sprite rifle;
	ArrayList<Sprite> ballonList = new ArrayList<Sprite>();

	public GameThread(SurfaceHolder holder, Context context)
	{
		super();
		this.holder = holder;
		this.context = context;
	}

	void initSprites()
	{
		int rx = (gameWidth/2) - 18;
		int ry = gameHeight - 100; 
		//int bx = (gameWidth/2)-34;
		int by = (gameHeight-150);
		Bitmap bmpRifle = BitmapFactory.decodeResource(context.getResources(), R.drawable.rifle);
		rifle = new Sprite(rx, ry, 100, 36, 0,0,bmpRifle);
		//ballon
		Bitmap bmpBall1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.ballon1);

		Random rn = new Random();
		for(int i =0;i<=5;i++)
		{
			int bx = rn.nextInt(gameWidth-40);
			Sprite ballon1 = new Sprite(bx, by, 69, 77, 5, 5, bmpBall1);

			ballonList.add(ballon1);
		}


	}

	boolean isRunning= true;
	@Override
	public void run()
	{
		super.run();
		while(isRunning)
		{
			try 
			{
				Thread.sleep(17);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			// lock canvas
			Canvas canvas = holder.lockCanvas();

			synchronized (holder) 
			{		
				drawScreen(canvas);
				updateScreen();
			}
			//unlock canvas
			holder.unlockCanvasAndPost(canvas);
		}
	}

	void drawScreen(Canvas canvas)
	{
		// background
		canvas.drawColor(Color.YELLOW);

		//rifle
		rifle.draw(canvas);
		//ballons
		for(Sprite balloon : ballonList)
		{
			balloon.draw(canvas);
		}
		//bullet

	}
	
	void updateScreen()
	{
		//update ballons
		for(Sprite ballon : ballonList)
		{
			ballon.moveUp();
		}
	}
}
