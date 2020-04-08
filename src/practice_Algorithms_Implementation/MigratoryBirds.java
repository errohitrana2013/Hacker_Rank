package practice_Algorithms_Implementation;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class MigratoryBirds {

	// Complete the migratoryBirds function below.
	static int migratoryBirds(List<Integer> arr) {
		Map<Integer,Integer> counterMap = new HashMap<>();
		for(int i=0;i<arr.size();i++){
		         if(counterMap.containsKey(arr.get(i))){
		          counterMap.put(arr.get(i), counterMap.get(arr.get(i))+1 );
		         }else{
		          counterMap.put(arr.get(i), 1);
		         }
		    }
		int max = 0, index = 0, min=0;
		for (Entry<Integer, Integer> entry : counterMap.entrySet())
        {
            if(max<entry.getValue())
            {
                max = entry.getValue(); 
                index = entry.getKey();
            }
			
        }
		return index;
	}

	public static void main(String[] args) throws IOException {
		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(4);
		arr.add(4);
		arr.add(4);
		arr.add(5);
		arr.add(3);
		arr.add(3);
		arr.add(3);

		int result = migratoryBirds(arr);
		System.out.println(result);

	}
}

