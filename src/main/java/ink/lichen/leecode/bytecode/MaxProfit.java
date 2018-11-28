package ink.lichen.leecode.bytecode;


/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *      dp【i】=Max（dp【i-1】，nums【i】-min）
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int n  =prices.length;
        if (n <= 1){
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int val : prices){
            if (min > val){
                min = val;
            }
            max = (val - min) > max ? (val - min) : max;
        }

        return max;
    }
}
