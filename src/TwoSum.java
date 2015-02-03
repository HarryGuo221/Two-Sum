import java.util.HashMap;
import java.util.Map;

/**
 * @question
 * Given an array of integers, find two numbers such that they add up to a specific target number.
	The function twoSum should return indices of the two numbers such that they add up to the target
	where index1 must be less than index2. 
	Please note that your returned answers (both index1 and index2) are not zero-based.	
	You may assume that each input would have exactly one solution.
 * @example
 * Input: numbers={2, 7, 11, 15}, target=9
    Output: index1=1, index2=2
 * @author HarryGuo
 *	@solution
 *	1. use index of every element as the hash key and push every element into hash map
 *	2. use target-numbers[i] as the search function to search the other add number
 */
public class TwoSum { 
	public static int[] twosum_1(int[] numbers, int target){
		int[] result = new int[2];
		
		Map<Integer , Integer > hashmap = new HashMap<Integer, Integer>();
		//把index作为键值，按照此键值进行构造hashmap
		for(int i = 0; i < numbers.length; i++){
			hashmap.put(numbers[i], i);
		}
		
		for(int i = 0; i < numbers.length; i++){
			int otherAddNumber = target - numbers[i]; //潜在的另一加数
			if(hashmap.get(otherAddNumber)!= null && hashmap.get(otherAddNumber)!= i){
				//利用hashmap.get(Object key)，查找另一加数，另外防止4=2+2类似的情况
				result[0] = i+1;
				result[1] = hashmap.get(otherAddNumber) + 1;
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		int [] numbers = {-3,3,4,90};
		int target = 0;
		int [] result = twosum_1(numbers, target);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
