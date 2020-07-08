package leetcode413;

public class FindTotalSlicesOfArithmeticFunction {
	// My brute force way
	public int numberOfArithmeticSlices(int[] A) {
        int result = 0;
        
        // Check each 3 items
        for(int i = 0; i < A.length - 2; i++){
            int previous = 0;
            int samePatterns = 1;
            
            for(int j = i; j < i + 2; j++){
                int current = A[j] - A[j + 1];
                
                if(j > i && previous == current){
                    samePatterns++;
                }
                
                if(samePatterns == 2){
                    result++;
                }
                
                previous = current;
            }
        }
        
        int prev = 0;
        
        // Check for the whole loop
        for(int i = 0; i < A.length - 3; i++){
            int counter = 1;
            for(int j = i; j < A.length - 1; j++){
                int current = A[j] - A[j + 1];
            
                if(j > i){
                    if(current == prev){
                        counter++;
                    } else {
                        break;
                    }
                }

                prev = current;
            }
            
            if(counter > 2){
            	// counter - 2 will get arithmetic that is more than 2 
                result += (counter - 2);
            }
        }
        
        return result;
    }
	
	// Using Dp O(N) time but O(N) space since the dp take extra space
    public int numberOfArithmeticSlices2(int[] A){
        int N = A.length;
        int result = 0;
        
        if(N < 3){
            return result;
        }
        
        int[] dp = new int[N];
        
        dp[0] = 0;
        dp[1] = 0;
        
        // Starting from third element
        for(int i = 2; i < N; i++){
        	// Check those three elements
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]){
            	// dp[i - 1] because if its same difference before, which mean it is same as current i
                dp[i] = dp[i - 1] + 1;
            } else { // reset to 0, same as dp[1] = 0
                dp[i] = 0;
            }
            
            result += dp[i];
        }
        
        return result;
    }

	// O(n) time and O(1) space using variable to store instead of extra O(n) memory like dp
	public int numberOfArithmeticSlices3(int[] A) {
		int N = A.length;
		int result = 0;

		if (N < 3) {
			return result;
		}

		int current = 0;

		for (int i = 2; i < N; i++) {
			// A pattern
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				current += 1;
				result += current;
			} else {
				current = 0;
			}
		}

		return result;
	}
}
