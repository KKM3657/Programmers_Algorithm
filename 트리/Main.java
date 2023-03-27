import java.io.*;
import java.util.*;
 
public class Main {
 
    static int T, N;
    static int[] preOrder, inOrder;
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
 
        for (int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            preOrder = new int[N];
            inOrder = new int[N];
 
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                preOrder[i] = Integer.parseInt(st.nextToken());
            }
 
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                inOrder[i] = Integer.parseInt(st.nextToken());
            }
 
            findPostOrder(0, 0, N - 1);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
 
    private static void findPostOrder(int rootIdx, int begin, int end) {
        if(rootIdx>=N) {
            return;
        }
 
        int rootValue = preOrder[rootIdx];
        
        for (int idx = begin; idx <= end; idx++) {
            if (rootValue == inOrder[idx]) {
                findPostOrder(rootIdx + 1, begin, idx);
                findPostOrder(rootIdx + idx + 1 - begin, idx + 1, end);
                sb.append(rootValue + " ");
                return;
            }
        }
    }
}