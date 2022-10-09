import java.util.*;

public class Main {
    public static final int MAX_N = 100; // 격자의 최대 크기
    public static int[][] arr = new int[MAX_N + 1][MAX_N + 1]; // 2차원 배열 선언
    public static int n,m,k; // n = 격자 크기, m = 블록 크기, k = k ~ k + m - 1(열)

    public static boolean checkNext(int i){
        for(int j = k; j <= k + m - 1; j++){
            if(arr[i + 1][j] > 0)
                return true;
        }
        return false;
    }

    public static int getTargetRow(){
        for(int i = 1; i < n; i++){
            if(checkNext(i))
                return i;
        }
        return n;
    }

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 격자 크기 4
        m = sc.nextInt(); // 블록 크기 3
        k = sc.nextInt(); // 블록이 떨어질 위치 1
        // k ~ k + m - 1

        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                arr[i][j] = sc.nextInt(); // 2차원 배열의 원소를 입력

        
        int targetRow = getTargetRow();


        for(int col = k; col <= k + m - 1; col++)
            arr[targetRow][col] = 1;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
           
        }
        //System.out.println(targetRow);
    }
}