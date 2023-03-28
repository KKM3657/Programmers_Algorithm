import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>(); // 해시맵
        for(int i=0; i<phone_book.length; i++){ //해시맵에 데이터 넣기
            map.put(phone_book[i], i);
        }
        boolean answer = true;
        // 전화번호가 접두사에 포함되는 경우 탐색
        for(int i=0; i<phone_book.length; i++){
            for(int j=0; j<phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0, j)))
                    return false;
            }
        }
        return answer;
    }
}