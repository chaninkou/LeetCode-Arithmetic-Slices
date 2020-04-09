package leetcode413;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		
		System.out.println("Input: " + Arrays.toString(nums));
		
		FindTotalSlicesOfArithmeticFunction solution = new FindTotalSlicesOfArithmeticFunction();
		
		System.out.println("Solution: " + solution.numberOfArithmeticSlices(nums));
	}
}
