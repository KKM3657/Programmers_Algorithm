import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();

        String input = br.readLine();
        int wl = input.length();
        int[] DP = new int[wl];

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            set.add(br.readLine());
        }
        // 문자열 자르기
        for(int i=wl-1; i>=0; i--){
            for(int j=i+1; j<wl; j++){
                if(DP[j] == 1){ // 문자를 잘랐을때 앞 부분에서 잘린 부분까지 단어가 있는지 판별
                    if(set.contains(input.substring(i,j)))
                        DP[i] = 1;
                }
            }
            // 나머지 부분이 단어가 있는지 판별
            if(set.contains(input.substring(i)))
                DP[i] = 1;
        }
        System.out.println(DP[0]);

    }
}

// 완전 탐색
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.io.IOException;

// public class Main {
//     static String[] arr;
//     static String input;
//     static int N, answer = 0;
//     static int ws = 0;
//     static StringBuilder sb = new StringBuilder();
//     public static void find_answer(int word) {
//         if(word >= ws){
//             String result = sb.toString();
//             if(word == ws && input.equals(result)){
//                 answer = 1;
//                 System.out.println(answer);
//                 System.exit(0);
//             }
//             return;
//         }
//         //단어 선택
//         for(int i=0; i<N; i++) {
//             int size = arr[i].length();
//             sb.append(arr[i]);
//             find_answer(word + size);

//             sb.delete(word, word + size);
//         }
//     }
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         input = br.readLine();
//         ws = input.length();

//         N = Integer.parseInt(br.readLine());
//         arr = new String[N];

//         for(int i=0; i<N; i++) {
//             arr[i] = br.readLine();
//         }

//         find_answer(0);
//         System.out.println(answer);
//     }
// }