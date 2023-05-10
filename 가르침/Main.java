import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
public class Main {
    static int N, K, answer = 0;
    //static StringBuilder sb = new StringBuilder("antic");
    static LinkedList<Character> list = new LinkedList<>();
    static boolean[] alpha = new boolean[26];
    public static void search_answer(int curr, int k, int temp, boolean flag){
        // 끝점
        if(curr == list.size()){
            answer = Math.max(answer, temp);
            return;
        }
        if(list.get(curr) == '/'){
            if(flag)
                search_answer(curr+1, k, temp+1, flag);
            else
                search_answer(curr+1, k, temp, true);
        }
        else{
            if(alpha[list.get(curr) - 'a']){
                search_answer(curr+1, k, temp, true);
            }
            else{
                if(k > 0){
                    // 선택
                    alpha[list.get(curr) - 'a'] = true;
                    search_answer(curr+1, k-1, temp, flag);
                    // 선택하지 않고 넘어감
                    alpha[list.get(curr) - 'a'] = false;
                    search_answer(curr+1, k, temp, false);
                }
                else{
                    // 넘어감
                    search_answer(curr+1, k, temp, false);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(K<5){
            System.out.println(0);
            System.exit(0);
        }
        else{
            alpha['a' - 'a'] = true;
            alpha['n' - 'a'] = true;
            alpha['t' - 'a'] = true;
            alpha['i' - 'a'] = true;
            alpha['c' - 'a'] = true;
        }

        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=4; j<input.length()-4; j++){
                char value = input.charAt(j);
                list.add(value);
            }
            list.add('/');
        }

        search_answer(0,K-5,0,true);
        System.out.println(answer);
    }
}