import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> arr = new ArrayList<>();
    public int[] select;
    public void make_number(int[] numbers, int curr, String num){
        // 모든 숫자를 사용한 경우
        if(curr == numbers.length){
            int number = Integer.parseInt(num);
            arr.add(number);
            return;
        }
        for(int i = 0; i < numbers.length; i++){
            if(select[i] != 1){
                select[i] = 1;  // 해당 숫자 선택
                String value = num + Integer.toString(numbers[i]); // 문자로 변환
                make_number(numbers, curr+1, value);    // 다음으로 이동
                select[i] = 0;
            }
        }
    }
    public String solution(int[] numbers) {
        select = new int[numbers.length];
        make_number(numbers, 0, "");
        Collections.sort(arr);
        String answer = Integer.toString(arr.get(arr.size()-1));
        return answer;
    }
}