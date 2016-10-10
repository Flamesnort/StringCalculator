package p1;

import java.util.ArrayList;

import edu.princeton.cs.algs4.Out;

public class StringCalculator {
	public int Add(String numbers){
		int sum = 0;
		if(numbers == "")
			return 0;
		else{
			if(numbers.indexOf(',') < 0){
				return Integer.parseInt(numbers);
			}
			else{
				String[] split = numbers.split(",");
				for(int i = 0; i < split.length; i++){
					sum += Integer.parseInt(split[i]);
				}
				return sum;
			}
		
		}	
	}
	
	public static void test(){
		Out out = new Out();
		StringCalculator str = new StringCalculator();
		int sum = 0;
		
		sum = str.Add("");
		out.println(sum);
		
		sum = str.Add("62");
		out.println(sum);
		
		sum = str.Add("4,14");
		out.println(sum);
	}
	
	public static void main(String[] args){
		test();
	}
}
