package test_drcare.dao;

import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import java.util.UUID;

import org.junit.Test;

public class GenerateUUIDTest {
	public static String shortUUID() {
		  UUID uuid = UUID.randomUUID();
		  long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
		  return Long.toString(l, Character.MAX_RADIX);
		}
	
	

	
	@Test
	public void test(){
		String a = shortUUID();
	  	int result=a.length();
		assertTrue(result>=12);
		System.out.println("Aha,UUID success");
	   }
	
}
