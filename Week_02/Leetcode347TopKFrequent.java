
import java.util.*;
import java.util.stream.IntStream;

public class Leetcode347TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparing(hashMap::get));
        for (int num : nums) {
            hashMap.merge(num, 1, (v1, v2) -> v1 + v2);
        }
        for (int key : hashMap.keySet()) {
            priorityQueue.add(key);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        List<Integer> list = new ArrayList<>(priorityQueue);
        Collections.reverse(list);
        return list.stream().mapToInt(i-> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        Leetcode347TopKFrequent leetcode347TopKFrequent = new Leetcode347TopKFrequent();
        leetcode347TopKFrequent.topKFrequent(nums, 2);
    }
}
