import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int blue = 0, red = 0, answer = 1;
        String input = br.readLine();
        
        char[] arr = new char[n];
        char prev = 'B';    // 초기화

        for(int i=0; i<n; i++){
            char color = input.charAt(i);   // 현재 색깔
            if(i == 0){ // 처음 색깔 지정
                if(color == 'B')
                    blue++;
                else
                    red++;
            }
            else{
                if(color == 'B' && prev != 'B') // 파란색 구간 개수 확인
                    blue++;
                else if(color == 'R' && prev != 'R') // 빨간색 구간 개수 확인
                    red++;
            }
            prev = color;
            arr[i] = color;
        }
        answer = Math.min(blue, red) + 1;   // 최소 구간으로 바꾸는게 최소 작업
        System.out.println(answer);
    }
}