import java.util.ArrayList;
import java.util.List;

//  39.组合总和
public class Solution39 {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    //  定义二维列表lists保存最终结果
    static List<List<Integer>> lists = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    //  先判断参数数组是否为null或者为空，target是否小于0。直接返回空列表lists
        if (candidates == null || candidates.length == 0 || target < 0) return lists;

    //  定义list来存放每一组结果
        List<Integer> list = new ArrayList<>();
        process(0, candidates, target, list);
        return lists;
    }

    //  定义一个递归，来保存符合添加的结果
    private static void process (int start, int[] candidates, int target, List<Integer> list) {

        if (target < 0) return;

        if (target == 0) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                process(i, candidates, target - candidates[i], list);
                list.remove(list.size() - 1);
            }
        }
    }
}
