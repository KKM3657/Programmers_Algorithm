import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        LinkedList<BigInteger> ll = new LinkedList<>(); //100자리 숫자가 가능하므로 BigInteger 사용

        for(int i=0; i<n; i++) {
            // 문자를 숫자로 토큰화 시킴
            st = new StringTokenizer(br.readLine(), "abcdefghijklmnopqrstuvwxyz");
            while(st.hasMoreTokens()) {
                ll.add(new BigInteger(st.nextToken()));
            }
        }
        Collections.sort(ll);   // 정렬
        for(BigInteger value : ll) {
            System.out.println(value.toString()); // 출력
        }
    }
}