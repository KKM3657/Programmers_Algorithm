import java.io.*;
import java.util.*;

public class Main {
    public static int[][] grid;      // 흑백 이미지
    public static StringBuilder sb = new StringBuilder();   // 정답을 위한 StringBuilder

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];

        for(int i = 0; i < n; i++) {
            String[] strArray = br.readLine().split("");
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(strArray[j]);
            }
        }

        solution(0, 0, n);
        System.out.println(sb);
    }

    public static void solution(int x, int y, int size) {
        // 압축 확인
        if(isReduction(x, y, size)) {
            sb.append(grid[x][y]);  // 값 추가
            return;
        }

        int part = size / 2;   // 압축이 불가, 4부분으로 나누기

        sb.append('(');   // 각 부분을 나타내기 위한 열기
        solution(x, y, part);                  // 왼쪽 위
        solution(x, y + part, part);            // 오른쪽 위
        solution(x + part, y, part);            // 왼쪽 아래
        solution(x + part, y + part, part);   // 오른쪽 아래
        sb.append(')');   // 각 부분이 끝나면 닫기
    }
    // 압축이 가능한지 판별
    public static boolean isReduction(int start_x, int start_y, int size) {
        int value = grid[start_x][start_y];

        for(int i = start_x; i < start_x + size; i++) {
            for(int j = start_y; j < start_y + size; j++) {
                if(value != grid[i][j]) {
                    return false;   // 다른값을 가지고 있으므로 압축 불가
                }
            }
        }
        return true;
    }

}