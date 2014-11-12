package com.wimc.twodgame;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback 
{
	SurfaceHolder holder;
	GameThread gameThread;
	
	public GameView(Context context)
	{
		super(context);
		holder = getHolder();
		holder.addCallback(this);
		gameThread = new GameThread(holder, context);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,int height)
	{
		gameThread.gameWidth = width;
		gameThread.gameHeight = height;
		gameThread.initSprites();
		gameThread.start();
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder)
	{
		gameThread.isRunning = false;		
	}

}
