package p1;

import java.util.ArrayList;

import edu.princeton.cs.algs4.Out;

public class StringCalculator {
	public int Add(String numbers) throws Exception{
		int sum = 0;
		if(numbers == "")
			return 0;
		else{
			if(numbers.indexOf(',') < 0 && numbers.indexOf("\n") < 0){
				return Integer.parseInt(numbers);
			}
			else{
				ArrayList<String> negNumbers = new ArrayList<String>();
				String[] split = numbers.split(",|(\n)");
				for(int i = 0; i < split.length; i++){
					if(Integer.parseInt(split[i]) >= 0){
						if(Integer.parseInt(split[i]) <= 1000){
							sum += Integer.parseInt(split[i]);
						}
					}
					else{
						negNumbers.add(split[i]);
					}
				}
				if(!negNumbers.isEmpty()){
				String s = "";
				for(String st : negNumbers){
					s += st + ", ";
				}
				throw new Exception("Negatives not allowed: " + s);
				}
				return sum;
			}
		
		}	
	}
	
	public static void test() throws Exception{
		Out out = new Out();
		StringCalculator str = new StringCalculator();
		int sum = 0;
		
		sum = str.Add("");
		out.println(sum);
		
		sum = str.Add("62");
		out.println(sum);
		
		sum = str.Add("4,14");
		out.println(sum);
		
		sum = str.Add("3,2,1,3,2,1");
		out.println(sum);
		
		sum = str.Add("3,2,1\n3\n2\n1");
		out.println(sum);
		
		//sum = str.Add("-2,3,4,-3");
		//out.println(sum);
		
		sum = str.Add("1001,2");
		out.println(sum);
	}
	
	public static void main(String[] args) throws Exception{
		test();
	}
}
