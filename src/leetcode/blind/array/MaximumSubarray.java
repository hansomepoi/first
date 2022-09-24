package leetcode.blind.array;

/**
 * 분할 정복
 *
 * 분할 정복을 구현할 때는 어떻게 작업을 분할할지를 잘 생각하면 된다.(근데 이게 쉽지 않음)
 * 1) 현재의 구간합
 * 2) 첫항을 뺀 구간합
 * 3) 끝항을 뺀 구간합
 *
 * 구간합의 연속 유무를 잘 생각해야함
 *
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int arr[] = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }


    public static int maxSubArray(int[] nums) {
        return maxSumOfArray(nums, 0, nums.length-1);
    }

    // f(n) = 2*f(n-1) + n
    // f(n-1) = 2*f(n-2) + n-1
    // ...
    // f(1) = 1
    //
    private static int maxSumOfArray(int[] array, int s, int e){
        if(s == e) return array[s];
        int leftSum = maxSumOfArray(array, s, e-1);
        int rightSum = maxSumOfArray(array, s+1, e);
        int sum = 0;
        for(int i = s; i <= e; i++){
            sum += array[i];
        }

        return Math.max(sum, Math.max(leftSum, rightSum));
    }
}
