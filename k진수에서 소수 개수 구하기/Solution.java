import java.util.LinkedList;

class Solution {
    // 소수인지 판별
    public boolean isPrime(long value){
        if(value<2)
            return false;
        // 제곱근을 이용한 소수판별
        for(long i=2; i*i<=value; i++) {
            if(value % i == 0)
                return false;
        }
        return true;
    }
    
    public int solution(int n, int k) {
        LinkedList<Integer> l = new LinkedList<>(); // k진수로 표현
        LinkedList<Integer> ans_list = new LinkedList<>();  // P가 되는지 판별하기 위한 저장소
        int answer = 0, value = n;
        
        // n을 k진수로 표현
        do{
            int next = value / k, remain = value % k;
            l.add(remain);
            value = next;
        } while(value != 0);
        // k진수로 표현 수가 P가 되는지 판별
        for(int i = 0; i <= l.size(); i++){
            // 마지막 까지 순회한 경우, 0을 만난 경우 P인 판별
            if(i == l.size() || l.get(i) == 0){
                // 0이 연속된 경우
                if(ans_list.isEmpty())
                    continue;
                // P가 소수인지 판별하기 위해 10진법으로 표현
                long prime = 0;
                for(int j = 0; j < ans_list.size(); j++)
                    prime += ans_list.get(j) * (long)Math.pow(10, j);
                // P가 소수이면 정답 + 1
                if(isPrime(prime))
                    answer++;
                ans_list.clear();
                continue;
            }
            ans_list.add(l.get(i)); // 0이 아닌 경우 저장소에 추가
        }
        return answer;
    }
}