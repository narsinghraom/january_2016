package collections.example;
import java.util.*;

public class Example1 
{
	public static void main(String[] args) 
	{
		ArrayList list1=new ArrayList();
		list1.add("1");
		list1.add("dhatri");
		Example1 example=new Example1();
		list1.add(example);
		System.out.println(list1);
		
		ArrayList<String> list2=new ArrayList<String>();
		list2.add("d");
		list2.add("ad");
		
		Iterator<String > iteratorr=list2.iterator();
		while(iteratorr.hasNext())
		{
			
		}
		
		
	}
	

}
