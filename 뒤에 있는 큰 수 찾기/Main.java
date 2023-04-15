import java.util.Stack;
class Solution {
    public int[] solution(int[] numbers) {
        int nLen = numbers.length;
        int[] answer = new int[nLen];
        Stack<Integer> s = new Stack<>();   // 스택 생성
        
        for(int i=numbers.length-1; i>=0; i--){
            while(!s.isEmpty()){    // 스택이 빌때까지 반복
                if(s.peek() > numbers[i]){  // 맨 위에 있는 숫자가 해당 변수보다 크면 정답
                    answer[i] = s.peek();
                    break;
                }
                else
                    s.pop();    // 다음 숫자 확인
            }
            if(s.isEmpty()) // 비어있으면 큰 숫자가 없는 상태
                answer[i] = -1;
            s.push(numbers[i]); // 앞으로 이동
        }
        return answer;
    }
}

// // O(n^2) 인 방법
// class Solution {
//     public int[] solution(int[] numbers) {
//         int nLen = numbers.length;
//         int[] answer = new int[nLen], dp = new int[nLen];
//         answer[nLen-1] = -1;
//         int temp = numbers[nLen-1];
//         boolean flag = false;
//         for(int i=numbers.length-2; i>=0; i--){
//             if(temp <= numbers[i]){
//                 for(int j=i+1; j<nLen; j++){
//                     if(numbers[i] < answer[j]){
//                         answer[i] = answer[j];
//                         flag = true;
//                         break;
//                     }
//                 }
//                 if(flag)
//                     flag = false;
//                 else
//                     answer[i] = -1;
//             }
//             else
//                 answer[i] = temp;
//             temp = numbers[i];
//         }
//         return answer;
//     }
// }