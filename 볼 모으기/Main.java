import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static int count_rball(char[] arr, char color1){
        int answer_c = 0;
        boolean move = false;
        // 색 구분
        char color2 = ' ';
        if(color1 == 'R')
            color2 = 'B';
        else
            color2 = 'R';
        // 옮기기
        for(int i=0; i<N; i++){
            if(arr[i] == color2){
                move = true;
                continue;
            }
            if(arr[i] == color1 && move){
                answer_c++;
            }
        }
        return answer_c;
    }
    public static int count_lball(char[] arr, char color1){
        int answer_c = 0;
        boolean move = false;
        // 색 구분
        char color2 = ' ';
        if(color1 == 'R')
            color2 = 'B';
        else
            color2 = 'R';
        // 옮기기
        for(int i=N-1; i>=0; i--){
            if(arr[i] == color2){
                move = true;
                continue;
            }
            if(arr[i] == color1 && move){
                answer_c++;
            }
        }
        return answer_c;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        char[] arr = new char[N];
        
        int red = 0, blue = 0;
        
        String input = br.readLine();
        for(int i=0; i<N; i++) {
            arr[i] = input.charAt(i);
        }
        
        int answer = 0;

        //빨간색 옮기기(왼쪽, 오른쪽)
        int red1 = count_lball(arr, 'R'), red2 = count_rball(arr, 'R');
        int answer1 = Math.min(red1,red2);
        //파란색 옮기기(왼쪽, 오른쪽)
        int blue1 = count_lball(arr, 'B'), blue2 = count_rball(arr, 'B');
        int answer2 = Math.min(blue1,blue2);
    
        answer = Math.min(answer1, answer2);
        System.out.println(answer);
    }
}