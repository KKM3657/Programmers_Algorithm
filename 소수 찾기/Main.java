import java.util.ArrayList;

class Solution {
    static int answer = 0;
    static int[] visited;
    static StringBuilder st = new StringBuilder();
    static ArrayList<Integer> al = new ArrayList<>();
    // 소수인지 판별
    public static boolean check_value(int value){
        // 1이면 소수가 아님
        if(value<2)
            return false;
        // 제곱근을 이용한 소수판별
        for(int i=2; i*i<=value; i++) {
            if(value % i == 0)
                return false;
        }
        return true;
    }
    // 재귀함수를 이용한 완전탐색
    public static void find(String numbers, int curr_num){
        // 모든 숫자를 사용한 경우
        if(curr_num == numbers.length() + 1){
            return;
        }
        // 남은 숫자 사용
        for(int i = 0; i<numbers.length(); i++){
            // 사용했으면 넘어감
            if(visited[i] == 1)
                continue;
            
            visited[i] = 1;
            char ch = numbers.charAt(i);    // 문자 추출
            st.append(ch);
            String str = st.toString();
            int value = Integer.parseInt(str);  // 정수 변환
            // 소수인지 판별
            if(check_value(value)){
                // 중복 처리
                if(!al.contains(value)){
                    answer++;
                    al.add(value);
                }   
            }
            find(numbers, curr_num+1);  // 다음 자릿수로 넘어감
            st.deleteCharAt(st.length()-1); // 사용후 원래 상태로 돌림
            visited[i] = 0;
        }
    }
    
    public int solution(String numbers) {
        visited = new int[numbers.length()];
        find(numbers, 0);
        return answer;
    }
}