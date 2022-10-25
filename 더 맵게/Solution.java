import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 0; i<scoville.length; i++){
            q.add(scoville[i]);
        }
        int min = q.get(0);
        while(min < K){
            answer++;
            int first = q.removeFirst();
            int second = q.removeFirst(); 
            
            int new_value = first + second * 2;
            q.add(new_value);
            Collections.sort(q);
            min = q.get(0);
        }
        return answer;
    }
}