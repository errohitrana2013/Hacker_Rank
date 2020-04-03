package practice_Algorithms_Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BetweenTwoSets {
	public static int getTotalX(List<Integer> a, List<Integer> b) {
		int finalCount = 0;
		int lcm1 = findLCM(a);
		int gcf = findGCF(b);

		for(int i = lcm1, j =2; i<=gcf; i=lcm1*j,j++){
			if(gcf%i==0){ finalCount++;}
		}

		System.out.println(finalCount);
		return finalCount;
		// Write your code here

	}
	static int findLCM(List<Integer> a){
		int result = a.get(0);
		for (int i = 1; i < a.size(); i++) {
			result = findLCM(result, a.get(i));
		}

		return result;
	}
	static int findLCM(int a,int b){
		int min,max,lcm=1,x;
		if(a>b){
			max =  a;
			min =  b;
		}else{
			max =  b;
			min =  a;
		}

		for(int i=1;i<max;i++){
			x = max*i;
			if(x%min==0){
				lcm = x;
				break;
			}
		}

		return lcm;
	}
	static int findGCF(List<Integer> a){
		int result = a.get(0);
		for (int i = 1; i < a.size(); i++) {
			result = findGCF(result, a.get(i));
		}
		return result;
	}
	static int findGCF(int a,int b) {
		List<Integer> numberList = new ArrayList<Integer>();
		numberList.add(a);
		numberList.add(b);
		Integer maxNumber = Collections.max(numberList);
		// int minNumber = Collections.max(numberList);
		int gcf1 = 1;
		for (int i = maxNumber; i > 1; i--) { // taking max number for iterating loop
			boolean check = false;
			for (int j = 0; j < numberList.size(); j++) {
				if (numberList.get(j) % i == 0) {
					check = true;
				} else {
					check = false;
					break;
				}
			}
			if (check) {
				for (int j = 0; j < numberList.size(); j++) {
					numberList.set(j, numberList.get(j) / i);
				}
				gcf1 *= i;
				maxNumber = Collections.max(numberList);
			}
		}

		return gcf1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int m = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		int total = getTotalX(arr, brr);

		bufferedWriter.write(String.valueOf(total));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
