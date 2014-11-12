package com.vaby.aidlservicedemo;

import com.aidlcode.IUtil.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MathService extends Service  
{
	@Override
	public IBinder onBind(Intent intent)
	{
		/*IBinder iBinder = new Math();
		return iBinder;
		 */
		
		// another way to write it....
		Math m = new Math();
		return m;
	}

	class Math extends Stub
	{

		@Override
		public int add(int x, int y) throws RemoteException
		{
			return (x+y);
		}

		@Override
		public int power(int m, int n) throws RemoteException
		{
			int result =1;
			for(int i=1; i<=n;i++)
			{
				result = result*m;
			}
			return result;
		}

		@Override
		public int summation(int n) throws RemoteException
		{
			int result = 0;
			for(int i=1; i<=n;i++)
			{
				result = result+i;
			}
			return result;
		}
	}
}
