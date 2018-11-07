import java.lang.reflect.Array;
import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums).get(0).get(0));
    }

    public static List<List<Integer>> threeSum (int[] nums){

        Set<List<Integer>> set = new LinkedHashSet<>();
        List<List<Integer>> ls = new ArrayList<>();
        int n = nums.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                for (int k=j+1; k<n; k++) {
                    if ( nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        set.add(list);
                        break;
                    }
                }
            }
        }
        Iterator<List<Integer>> it = set.iterator();
        while (it.hasNext()) {
            ls.add(it.next());
        }

        return ls;
    }
}
