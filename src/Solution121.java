// 121.买卖股票的最佳时机
public class Solution121 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
    public static int maxProfit(int[] prices) {
//        股票的最低价格
        int minPrice = prices[0];
//        最终利润
        int res = 0;
//        当前已知最高利润
        int preRes = 0;

//        遍历股票价格
        for (int i = 1; i < prices.length; i++) {
//            res 更新最终利润，为已知最高利润 和 当前利润(遍历到的股票价格 - 已知最低股票价格) 中的最大值
            res = Math.max(preRes, (prices[i] - minPrice));
//            preRes 更新当前已知最高利润， 取最终利润和当前已知最高利润的最大值
            preRes = Math.max(res, preRes);
//            更新股票价格最小值，保存到minPrice中
            minPrice = Math.min(prices[i], minPrice);
        }
        return res;
    }
}
