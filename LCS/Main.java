import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine(), input2 = br.readLine();
        int N = input1.length(), M = input2.length();
        int[][] LCS = new int[N+1][M+1];

        char[] arr1 = new char[N+1];
        for(int i=1; i<=N; i++){
            arr1[i] = input1.charAt(i-1);
        }

        char[] arr2 = new char[M+1];
        for(int i=1; i<= M; i++){
            arr2[i] = input2.charAt(i-1);
        }

        for(int i=0; i<=N; i++){
            for(int j=0; j<=M; j++){
                if(i == 0 || j == 0){
                    LCS[i][j] = 0;
                }
                else if (arr1[i] == arr2[j]) {
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                }
                else{
                    LCS[i][j] = Math.max(LCS[i][j-1], LCS[i-1][j]);
                }
            }
        }
        System.out.println(LCS[N][M]);
        //해당 문자열
//        StringBuilder sb = new StringBuilder();
//
//        int idx1 = N, idx2 = M;
//
//        while(!(idx1 == 0 || idx2 == 0)){
//            if(LCS[idx1][idx2] == LCS[idx1-1][idx2])
//                idx1 -= 1;
//            else if (LCS[idx1][idx2] == LCS[idx1][idx2-1])
//                idx2 -= 1;
//            else{
//                sb.append(arr1[idx1]);
//                idx1 -= 1;
//                idx2 -= 1;
//            }
//        }
//        System.out.println(sb.reverse().toString());
    }
}