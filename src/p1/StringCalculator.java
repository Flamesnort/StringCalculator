package p1;

import java.util.ArrayList;

import edu.princeton.cs.algs4.Out;

public class StringCalculator {
	public int Add(String numbers) throws Exception{
		int sum = 0;
		String delimiter = "";
		if(numbers.startsWith("\\")){
			String[] delSplit = numbers.split("\n");
			delimiter = "(" + delSplit[0].substring(1, delSplit[0].length()) + ")|";
			numbers = numbers.substring(numbers.indexOf("\n"), numbers.length());
		}
		delimiter += ",|(\n)";
		if(numbers == "")
			return 0;
		else{
			if(numbers.indexOf(',') < 0 && numbers.indexOf("\n") < 0){
				return Integer.parseInt(numbers);
			}
			else{
				String[] split = numbers.split(delimiter);
				ArrayList<String> negativeNumbers = new ArrayList<>();
				for(int i = 0; i < split.length; i++){
					//An additional check, for some reason an empty space always started at the start of each 
					if(!split[i].equals("")){
						if(Integer.parseInt(split[i]) >= 0){
							if(Integer.parseInt(split[i]) <= 1000){
								sum += Integer.parseInt(split[i]);
							}
						}
						else{
							negativeNumbers.add(split[i]);
						}
					}
				}
				if(!negativeNumbers.isEmpty()){
					String s = "";
					for(String st : negativeNumbers){
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
		
		sum = str.Add("\\k\n2k5k10");
		out.println(sum);
	}
	
	public static void main(String[] args) throws Exception{
		test();
	}
}
