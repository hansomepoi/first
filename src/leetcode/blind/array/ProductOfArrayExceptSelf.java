package leetcode.blind.array;

// https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] ex1 = new int[]{0,0,0};
        ProductOfArrayExceptSelf ex = new ProductOfArrayExceptSelf();
        int[] ret = ex.productExceptSelf(ex1);
        for(int i = 0; i < ret.length; i++){
            System.out.println(ret[i]);
        }
    }

    // start value == -10000
    public int[] productExceptSelf(int[] nums) {

        int[][] cache = new int[61][2]; // 0 ~ 60, -30 ~ 30
        for(int i = 0; i < 61; i++){
            cache[i][0] = 1;
            cache[i][1] = -10000;
        }

        for(int i = 0; i < nums.length; i++){
            int index = getIndex(nums[i]);
            cache[index][0] *= nums[i];
            if(cache[index][1] == -10000) cache[index][1] = 1;
            else cache[index][1] *= nums[i];
        }


        int[] result = new int[nums.length];
        for(int i = 0; i < result.length; i++){
            result[i] = getResult(cache, getIndex(nums[i]));
        }

        return result;
    }

    private int getResult(int[][] cache, int index) {
        int result = 1;
        for(int i = 0; i < 61; i++){
            if(i == index) result *= cache[index][1];
            else result *= cache[i][0];
        }
        return result;
    }

    private int getIndex(int num){
        return num+30;
    }

}
