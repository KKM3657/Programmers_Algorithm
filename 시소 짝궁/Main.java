// 프로그래머스 탐색(시소 짝궁)
import java.util.Arrays;
class Solution {
    static long answer = 0;
    static int size, idx;
    public void find_solution(int[] weights, int curr){
        if(curr == size)
            return;
        if(weights[idx] * 3 < weights[curr])
            return;
        if(weights[idx] == weights[curr]){
            answer++;
        }
        //2m
        if(weights[idx] * 2 == weights[curr] * 3 || weights[idx] * 2 == weights[curr] * 4){
            answer++;
        }
        //3m
        if(weights[idx] * 3 == weights[curr] * 2 || weights[idx] * 3 == weights[curr] * 4){
            answer++; 
        }
            
        //4m
        if(weights[idx] * 4 == weights[curr] * 2 || weights[idx] * 4 == weights[curr] * 3){
            answer++;
        }
        find_solution(weights, curr+1);
    }
    public long solution(int[] weights) {
        size = weights.length;
        Arrays.sort(weights);
        for(int i=1; i<size; i++) {
            idx = i-1;
            find_solution(weights, i);
        }
        return answer;
    }
}