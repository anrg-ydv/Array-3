// Approach 1: using extra space
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int [] temp = new int[n];
        int j = 0;
        k = k%n;    // rotation repeats
        for (int i = n-k; i< n; i++){
            temp[j++] = nums[i];
        }
        for (int i = 0; i< n-k; i++){
            temp[j++] = nums[i];
        }
        
        //nums = temp; (this won't work because of call by val vs call by reference)
        for (int i = 0; i< n; i++){
            nums[i] = temp[i];
        }
    }
}


// Approach 2: reversing the array completely first & then reversing in parts.
// tc = O(N)
// sc = O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;    // because rotation repeats        
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    
    private static void reverse(int[] arr, int left, int right){
        while(left <= right){
            swap(arr,left, right);
            left++;
            right--;
        }
    }
    
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
