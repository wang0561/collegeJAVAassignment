package algonquin.practise;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		Integer [] array1={1,5,3,4};
		Integer[] array2=new Integer[4];
		array2=array1;
		Arrays.sort(array2);
		for(Integer i:array2)
			System.out.println(i);
	}

}

class SayHello {
	static int helloCtr = 0; // static counter

	public SayHello() {
		outputHello();
	}

	public void outputHello() {
		helloCtr++;
		System.out.println("Output Hello #" + helloCtr);
	}
}