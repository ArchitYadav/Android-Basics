package com.example.cameraapp;

import java.io.IOException;
import java.util.List;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class CameraPreview extends SurfaceView implements
SurfaceHolder.Callback {
	Camera camera;
	Context context;
	SurfaceHolder holder;

	public CameraPreview(Context context, Camera camera) {
		super(context);
		this.camera = camera;
		context = context;
		holder = getHolder();
		holder.addCallback(this);
		holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

	}

	// lifecycle methods of surface view
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		Camera.Parameters cp = camera.getParameters();

		// setting height and width of camera
		cp.setPreviewSize(width, height);
		camera.setParameters(cp);

		try {
			camera.setPreviewDisplay(holder);
		} catch (IOException e) {
			e.printStackTrace();
		}
		camera.setParameters(cp);
		camera.setPreviewCallback(null);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		camera.startPreview();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder)
	{

	}

}
