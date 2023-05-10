import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, answer = 0;
    static String[] words;
    static boolean[] alpha = new boolean[26];
    public static void search_answer(int curr, int cnt){
        // 가르친 단어를 이용해서 단어를 판별
        if(cnt == K-5){
            int temp = 0;
            for(int i=0; i<N; i++){ // 모든 단어 확인
                boolean flag = true;
                for(int j=0; j<words[i].length(); j++){
                    if(!alpha[words[i].charAt(j) - 'a']){   // 모르는 문자가 나오면 다음 단어로 이동
                        flag = false;
                        break;
                    }
                }
                if(flag)    // 아는 문자로만 이루어진 단어
                    temp++;
            }
            answer = Math.max(answer, temp);
            return;
        }
        // 가르칠 문자 선택
        for(int i=curr; i<26; i++){
            if(!alpha[i]){  // 모르는 문자면 가르침
                // 선택
                alpha[i] = true;
                search_answer(i, cnt+1);
                // 선택 안함
                alpha[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        if(K<5){
            System.out.println(0);
            return;
        }
        else if(K == 26){
            System.out.println(N);
            return;
        }
        // 고정적으로 사용하는 문자
        else{
            alpha['a' - 'a'] = true;
            alpha['n' - 'a'] = true;
            alpha['t' - 'a'] = true;
            alpha['i' - 'a'] = true;
            alpha['c' - 'a'] = true;
        }

        for(int i=0; i<N; i++){
            String input = br.readLine().replaceAll("anta|tica", "");
            words[i] = input;
        }
        search_answer(0,0);
        System.out.println(answer);
    }
}

//완전탐색(타임 아웃)
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//import java.util.LinkedList;
//public class Main {
//    static int N, K, answer = 0;
//    //static StringBuilder sb = new StringBuilder("antic");
//    static LinkedList<Character> list = new LinkedList<>();
//    static boolean[] alpha = new boolean[26];
//    public static void search_answer(int curr, int k, int temp, boolean flag){
//        // 끝점
//        if(curr == list.size()){
//            answer = Math.max(answer, temp);
//            return;
//        }
//        if(list.get(curr) == '/'){
//            if(flag)
//                search_answer(curr+1, k, temp+1, flag);
//            else
//                search_answer(curr+1, k, temp, true);
//        }
//        else{
//            if(alpha[list.get(curr) - 'a']){
//                search_answer(curr+1, k, temp, true);
//            }
//            else{
//                if(k > 0){
//                    // 선택
//                    alpha[list.get(curr) - 'a'] = true;
//                    search_answer(curr+1, k-1, temp, flag);
//                    // 선택하지 않고 넘어감
//                    alpha[list.get(curr) - 'a'] = false;
//                    search_answer(curr+1, k, temp, false);
//                }
//                else{
//                    // 넘어감
//                    search_answer(curr+1, k, temp, false);
//                }
//            }
//        }
//    }
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//
//        if(K<5){
//            System.out.println(0);
//            System.exit(0);
//        }
//        else{
//            alpha['a' - 'a'] = true;
//            alpha['n' - 'a'] = true;
//            alpha['t' - 'a'] = true;
//            alpha['i' - 'a'] = true;
//            alpha['c' - 'a'] = true;
//        }
//
//        for(int i=0; i<N; i++){
//            String input = br.readLine();
//            for(int j=4; j<input.length()-4; j++){
//                char value = input.charAt(j);
//                list.add(value);
//            }
//            list.add('/');
//        }
//
//        search_answer(0,K-5,0,true);
//        System.out.println(answer);
//    }
//}