import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    static int[] arr = new int[9];  // 입력 정보
    static ArrayList<Integer> answer_list = new ArrayList<>();  // 정답 리스트
    public static void find_answer(int select, int curr, int value_sum){
        if(select == 7){    // 7명의 난쟁이 선택 완료
            if(value_sum == 100){   // 키 합이 100인 경우 정답
                Collections.sort(answer_list);  // 오름차순 정렬
                for(Integer value : answer_list)
                    System.out.println(value);
                System.exit(0);
            }
            return;
        }
        if(curr == 9)   // 모든 경우를 본 경우 종료
            return;
        // 해당 난쟁이 선택
        answer_list.add(arr[curr]);
        find_answer(select+1, curr+1, value_sum+arr[curr]);
        // 해당 난쟁이 선택하지 않음
        answer_list.remove(answer_list.size()-1);
        find_answer(select, curr+1, value_sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<9; i++){
            arr[i] = sc.nextInt();
        }
        find_answer(0,0,0);
    }
}