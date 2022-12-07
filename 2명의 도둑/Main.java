import java.io.*;
import java.util.*;

class Product {
    int x;
    int y;

    Product(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n, m, c;
    static int[][] grid;
    static Product[] p = new Product[2];
    static int maxValue = 0, sumValue = 0, powValue = 0;

    static boolean isPossible() {
        if (p[0].x == p[1].x && p[0].y + m > p[1].y)
            return false;
        return true;
    }
    
    static void choiceMaxSum(int x, int y, int maxY, int value) {
        if (y >= maxY) {
            if (sumValue <= c) {
                powValue = Math.max(powValue, value);
            }   
            return;
        }

        sumValue += grid[x][y];
        choiceMaxSum(x, y + 1, maxY, value + (int)Math.pow(grid[x][y], 2));
        sumValue -= grid[x][y];

        choiceMaxSum(x, y + 1, maxY, value);
    }
    static int calMaxPow() {
        int fX = p[0].x, fY = p[0].y;
        int sX = p[1].x, sY = p[1].y;
        int total = 0;
        
        sumValue = 0;
        powValue = 0;

        choiceMaxSum(fX, fY, fY + m, 0);
        total += powValue;

        sumValue = 0;
        powValue = 0;

        choiceMaxSum(sX, sY, sY + m, 0);
        total += powValue;
        return total;
    }
    static void choice(int num, int x, int y) {
        if (y > n-m) {
            x += 1;
            y = 0;
        }
        if (num >= 2) {
            if (isPossible()) {
                maxValue = Math.max(maxValue, calMaxPow());
            }
            return;
        }
        if (x == n)
            return;

        p[num] = new Product(x, y);
        choice(num + 1, x, y+1);
        choice(num, x, y+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        c = Integer.parseInt(str[2]);

        grid = new int[n][n];
        for(int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(str[j]);
            }
        }

        choice(0, 0, 0);

        System.out.println(maxValue);
    }
}