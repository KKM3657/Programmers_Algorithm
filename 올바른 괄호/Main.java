import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<String> st = new Stack<>();	// 스택 생성
        String[] array = s.split("");	// 문자 분할
        boolean answer = false;
        for(String str : array){	// 올바른 괄호인지 확인
            if(str.equals("(")){	// (이면 스택에 저장
                st.push(str);
            } else{
                if(st.empty()){	// ( 개수와 다르면 False
                    answer = false;
                    return answer;
                }
                st.pop();	// 올바른 ) 개수
            }
        }
        if(st.empty())
            answer = true;
        return answer;
    }
}

// import java.util.Stack;

// class Solution {
//     boolean solution(String s) {
//         Stack<Character> st = new Stack<>();
//         boolean answer = false;
//         for(int i = 0; i < s.length(); i++){
//             if(s.charAt(i) == '('){
//                 st.push('(');
//             } else{
//                 if(st.empty()){
//                     answer = false;
//                     return answer;
//                 }
//                 st.pop();
//             }
//         }
//         if(st.empty())
//             answer = true;
//         return answer;
//     }
// }