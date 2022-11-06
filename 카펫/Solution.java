class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;   // 총 면적
        int row = 0, column = 0;    // 가로, 세로
        for(int i = 1; i * i <= sum; i++){  // 순서쌍 구하기
            int j = 0;
            if(sum % i == 0){   // 순서쌍에 해당하면
                j = sum / i;    // 가로, 세로 분류
                if(i*2 + (j-2)*2 == brown){ // 갈색 면적와 같은지 판별후 저장
                    row = j;
                    column = i;
                }
            }
        }
        int[] answer = {row, column};
        return answer;
    }
}