package enumeration.demo;

import java.util.ArrayList;
import java.util.List;
/*forEach will not change the value of element in collection*/
public class ForeachDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={1,2,3,4,5};
		for (int n : array)
			println(n=0);
		for(int n: array)
			println(n);
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.forEach(i -> {if (i%2==0) println(i);});	//2,4
        println(list);//[1,2,3,4,5]
        
	}

	public static void println(Object s){
		String str=String.valueOf(s);
		System.out.println(str);
	}


	public static void print(Object s){
		System.out.print(s);
	}
	

}
