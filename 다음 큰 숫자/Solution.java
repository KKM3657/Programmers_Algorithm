class Solution {
    public int solution(int n) {
        int answer = n;  // 답이 되는 값
        int cnt1 = 0, cnt2 = 0; // 1의 개수를 확인하기 위한 변수
        // 2진수 변환 및 1의 개수 확인
        while(n != 0){
            if(n % 2 == 1)
                cnt1++;
            n = n / 2;
        }
        // 닶이 되는 값 탐색
        do{
            answer++;    // n+1부터 탐색 시작
            cnt2 = 0;   // 초기화
            int k = answer; // 2진수 변환을 위한 변수 선언
            while(k != 0){
                if(k % 2 == 1)
                    cnt2++;
                k = k / 2;
            }
        }while(cnt1 != cnt2);   // 조건2를 만족하는지 판별
        return answer;
    }
}