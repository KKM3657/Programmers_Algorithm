import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> qu1 = new LinkedList<>();
        Queue<Integer> qu2 = new LinkedList<>();
        
        long qu1_sum = 0, qu2_sum = 0;
        
        // 큐 구현 및 각 큐의 총합 구하기
        for(int i = 0; i < queue1.length; i++){
            qu1.add(queue1[i]);
            qu2.add(queue2[i]);
            qu1_sum += queue1[i];
            qu2_sum += queue2[i];
        }
        
        // 해가 없는 경우
        if((qu1_sum + qu2_sum) % 2 != 0)
            return -1;
        
        int p1 = 0, p2 = 0, limit = queue1.length*2;
        // 이동 횟수 구하기
        while((p1<=limit && p2<=limit)){
            if(qu1_sum == qu2_sum){ // 두 큐의 합이 같은 경우 반환
                return p1 + p2;
            } else if(qu1_sum > qu2_sum){   // queue1 합계가 queue2 합계보다 큰 경우 이동
                qu1_sum -= qu1.peek();
                qu2_sum += qu1.peek();
                qu2.add(qu1.poll());
                p1 += 1;
            } else{ // queue2 합계가 queue1 합계보다 큰 경우 이동
                qu1_sum += qu2.peek();
                qu2_sum -= qu2.peek();
                qu1.add(qu2.poll());
                p2 += 1;
            }
        }
        return -1;
    }
}