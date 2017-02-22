package controller;

import java.util.concurrent.atomic.AtomicLong;

public class GenerateEMID {

	private static final AtomicLong LAST_TIME_MS = new AtomicLong();
	public static long getEmid() {
	    long now = System.currentTimeMillis();
	    while(true) {
	        long lastTime = LAST_TIME_MS.get();
	        if (lastTime >= now)
	            now = lastTime+1;
	        if (LAST_TIME_MS.compareAndSet(lastTime, now))
	            return now;
	        
	    }
	}
	
//	public static void main(String[]args)
//	{
//		long a = uniqueCurrentTimeMS();
//		System.out.println(a);
//
//		
//	}
}
