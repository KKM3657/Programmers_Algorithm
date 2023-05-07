import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean isPalindrome(String input){
        
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            // 초기화
            String input = br.readLine();
            char[] arr = input.toCharArray();
            int answer1 = 0, answer2 = 0;
            int l = 0, r = arr.length - 1, cnt = 1;
            // 회문이 아니면 왼쪽으로 옮기기
            while(l<r){
                if(arr[l] == arr[r]){
                    l++;
                    r--;
                }
                else{
                    if(cnt == 1){
                        l++;
                        cnt--;
                    }
                    else{
                        answer1 = 2;
                        break;
                    }
                }
            }
            if(answer1 == 0){
                if(cnt == 1)
                    answer1 = 0;
                else
                    answer1 = 1;
            }
            
            // 회문이 아니라면 오른쪽으로 옮기기
            l = 0;
            r = arr.length - 1;
            cnt = 1;
            while(l<r){
                if(arr[l] == arr[r]){
                    l++;
                    r--;
                }
                else{
                    if(cnt == 1){
                        r--;
                        cnt--;
                    }
                    else{
                        answer2 = 2;
                        break;
                    }
                }
            }
            if(answer2 == 0){
                if(cnt == 1)
                    answer2 = 0;
                else
                    answer2 = 1;
            }
            System.out.println(Math.min(answer1, answer2));
        }
    }
}