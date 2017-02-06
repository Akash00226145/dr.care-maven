package controller;

import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import java.util.UUID;

import org.junit.Test;

public class generateUUID {
	public static String shortUUID() {
		  UUID uuid = UUID.randomUUID();
		  long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
		  return Long.toString(l, Character.MAX_RADIX);
		}
	
	
	public static void main(String[]args)
	{
		String a = shortUUID();
		System.out.println(a);
		int result=a.length();
		System.out.println(result);
		
	}
	
	@Test
	public void test(){
		String a = shortUUID();
	  	int result=a.length();
		assertTrue(result>=12);
	   }
	
}
