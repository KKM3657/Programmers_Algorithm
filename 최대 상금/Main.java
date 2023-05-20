import java.util.Scanner;
import java.io.FileInputStream;
import java.util.HashMap;
 
class Solution
{
    static int cnt, len, answer = 0;
    static int[] arr;
    public static void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void find_answer(int curr) {
        if(curr == cnt) {
            StringBuilder sb = new StringBuilder();
            for(Integer value: arr)
                sb.append(value);
            answer = Math.max(answer, Integer.parseInt(sb.toString()));
            return;
        }
         
        for(int i=0; i<len-1; i++) {
            for(int j=i+1; j<len; j++) {
                //바꾸기
                swap(i,j);
                find_answer(curr+1);
                swap(j,i);
            }
        }
    }
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            answer = 0;
            int N = sc.nextInt();
            cnt = sc.nextInt();
            String value = String.valueOf(N);
            len = value.length();
            arr = new int[len];
            if(cnt>len) {
                cnt = len;
            }
            for(int i=0; i<value.length(); i++) {
                arr[i] = value.charAt(i) - '0';
            }
            find_answer(0);
            System.out.println("#" + test_case + " " + answer);
        }
    }
}