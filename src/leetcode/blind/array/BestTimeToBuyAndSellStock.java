package leetcode.blind.array;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int[] itemCount = new int[10001];
        for(int i = 0; i < prices.length; i++){
            itemCount[prices[i]]++;
        }
        int result = 0;

        Integer[] maxIndicator = Arrays.stream(prices).boxed().toArray(Integer[]::new);
        int idx = 0;
        Arrays.sort(maxIndicator, Comparator.reverseOrder());

        for(int i = 0; i < prices.length; i++){
            result = Math.max(result, maxIndicator[idx] - prices[i]);
            itemCount[prices[i]]--;
            while (idx < maxIndicator.length && itemCount[maxIndicator[idx]]== 0){
                idx++;
            }
        }
        return result;

    }
}
