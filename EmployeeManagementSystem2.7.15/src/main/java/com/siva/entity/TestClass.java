package com.siva.entity;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

class ImmutableClass
{
	private static ImmutableClass im;
	private ImmutableClass()
	{
		
	}
	public static ImmutableClass getInstance()
	{
		if(im==null)
		{
			im=new ImmutableClass();
			return im;
		}
		else
		{
			return im;
		}
	}
	
}
public class TestClass {

	public static void main(String[] args) throws Exception{
		//  ImmutableClass obj = ImmutableClass.getInstance();
		/*System.out.println(obj.hashCode());
		ImmutableClass obj2 = ImmutableClass.getInstance();
		System.out.println(obj2.hashCode());
		*/ 
		  new TestClass().meth4();
	    
		 
	}
	void meth1()throws Exception
	{
		File file = new File("D:\\Emp_proj\\emp\\");
		if(!file.exists())
		{
			file.mkdirs();
		}
		System.out.println(file.getAbsolutePath());
	}
	void meth2()
	{
		
		for(int i=1;i<=10;i++)
		{
			System.out.println(i);
		}
	}
	void meth3()
	{
		LocalDate ld=LocalDate.now();
		System.out.println(ld);
		System.out.println(String.valueOf(ld));
	}
	void meth4() {
		Integer arr[]= {1,2,3,4,5};
		List<Integer> list=Arrays.asList(arr);
		 OptionalInt max = list.stream().mapToInt(i->i).max();
		 list.stream().sorted().collect(null);
		System.out.println(max);
	}
}
