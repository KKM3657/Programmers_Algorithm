import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();    // 해시맵
        
        for(int value : tangerine){  // 원소에 해당하는 갯수 파악
            if(map.containsKey(value))
                map.put(value, map.get(value)+1);
            else
                map.put(value, 1);
        }
        // 우선순위 큐, 갯수에 따른 내림차순 정렬
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(new Comparator<Integer[]>(){
            @Override
            public int compare(Integer[] o1, Integer[] o2){
                return o2[1] - o1[1];
            }
        });
        // 우선순위 큐에 값 넣기
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            pq.add(new Integer[]{entry.getKey(), entry.getValue()});
        }
        // 서로 다른 종류의 수의 최솟값 구하기
        while(k > 0 && pq.size() != 0){
            Integer[] curr = pq.poll();
            k -= curr[1];
            answer++;
        }
        return answer;
    }
}