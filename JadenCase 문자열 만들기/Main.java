class Solution {
    public String solution(String s) {
        // 정답을 나타내기 위해 StringBuilder 사용
        StringBuilder st = new StringBuilder();
        st.append(s);
        boolean prev = true;    // 공백처리를 위한 flag
        for(int i = 0; i < s.length(); i++){
            char word = st.charAt(i);   // char 문자로 변환
            if(word == ' '){    // 공백처리후 다음으로 넘어감
                prev = true;
                continue;
            }
            char c = prev ? Character.toUpperCase(word) : Character.toLowerCase(word); // 단어 첫글자 처리
            prev = false;
            String str = String.valueOf(c);
            st.replace(i,i+1,str);
        }
        
        System.out.println(st.toString());
        return st.toString();
    }
}