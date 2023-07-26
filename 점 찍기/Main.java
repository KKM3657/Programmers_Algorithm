class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int i=0; i<=d; i += k){
            double y = Math.sqrt((long)dd - (long)ii);
            answer += Math.floor(y/k) + 1;
        }
        return answer;
    }
}