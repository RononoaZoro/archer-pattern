package com.luo.decorator.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author luoxuzheng
 * @create 2019-09-15 20:54
 **/
public class InputTest {
	public static void main(String[] args) throws IOException {
		int c;
		InputStream in = null;
		try {
			in = 
				new LowerCaseInputStream(
					new BufferedInputStream(
						new FileInputStream("test.txt")));

			while((c = in.read()) >= 0) {
				System.out.print((char)c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) { in.close(); }
		}
		System.out.println();
		try (InputStream in2 = 
				new LowerCaseInputStream(
					new BufferedInputStream(
						new FileInputStream("test.txt")))) 
		{
			while((c = in2.read()) >= 0) {
				System.out.print((char)c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
