package com.wimc.twodgame;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

public class GameThread extends Thread 
{
	SurfaceHolder holder;   // it'll give u canvas
	Context context;
	int gameHeight,gameWidth;
	Random rn;
	
	// sprites
	Sprite rifle;
	
	CopyOnWriteArrayList<Sprite> ballonList = new CopyOnWriteArrayList<Sprite>();
	Bitmap bmpBall;
	
	CopyOnWriteArrayList<Sprite> bulletList = new CopyOnWriteArrayList<Sprite>();
	Bitmap bmpBullet;
	
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
		Bitmap bmpBullet = BitmapFactory.decodeResource(context.getResources(), R.drawable.bullet);
		
		rifle = new Sprite(rx, ry, 100, 36, 0,0,bmpRifle,0);
		//ballon
		bmpBall = BitmapFactory.decodeResource(context.getResources(),R.drawable.ballon1);
		
		rn = new Random();
		for(int i =0;i<=7;i++)
		{
			int bx = rn.nextInt(gameWidth-40);
			int time = rn.nextInt(3000);
			Sprite ballon = new Sprite(bx, by, 69, 77, 5, 5, bmpBall,time);

			ballonList.add(ballon);
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
		for(Sprite bullet : bulletList)
		{
			bullet.draw(canvas);
		}
	}
	
	void updateScreen()
	{
		//update ballons
		for(Sprite ballon : ballonList)
		{
			ballon.timeToAppear -= 100;
			ballon.moveUp();
		}		
		for(Sprite ballon : ballonList)
		{
			if(ballon.y < 0)
			{
				ballonList.remove(ballon);
			}
		}		
		if(ballonList.size() < 5)
		{
			// add a ballon
			newBallon();
		}
		
		// bullets
		for(Sprite bullet : bulletList)
		{
			bullet.moveUp();
			if(bullet.y < 0)
			{
				bulletList.remove(bullet);
			}
		}
		
	}
	
	void newBallon()
	{
		int bx = rn.nextInt(gameWidth-40);
		int by = gameHeight-rn.nextInt(150);
		int time = rn.nextInt(3000);
		Sprite ballon = new Sprite(bx,by,69,77,5,5, bmpBall,time);

		ballonList.add(ballon);
	}
	
	
	public void onTouchEvent(MotionEvent event)
	{
		int x = (int)(event.getX());
		int y = (int)(event.getY());
		
		if(rifle.getRect().contains(x, y))
		{
			newBullet();
		}
	}
	
	void newBullet()
	{
		
		Sprite bullet = new Sprite((gameWidth/2)-5,(gameHeight-150),10,30,8,8, bmpBullet,0);

		bulletList.add(bullet);
	}
	
}
