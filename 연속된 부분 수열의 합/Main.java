class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0,0};
        // 초기값 설정
        int N = sequence.length, value = Integer.MAX_VALUE;
        int l = 0, r = -1;
        long total = 0; // 구간의 합
        // 투 포인터 사용
        while(l < N){
            while(r + 1 <= N && total <= k){    // 구간 나누기
                if(total == k){ // 정답이 되는 경우 구간 길이 확인
                    int temp = r-l; // 구간 길이
                    if(temp < value){   // 구간이 길이가 더 작은 경우 갱신
                        value = temp;
                        answer[0] = l;
                        answer[1] = r;
                        break;
                    }
                }
                if(r+1 < N) // 마지막 원소까지 확인
                    total += sequence[r+1];
                r++;
            }
            total -= sequence[l];   // l 이동할때 값을 빼기
            l++;
        }
        return answer;
    }
}