import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int answer1 = Integer.MAX_VALUE, answer2 = Integer.MIN_VALUE;

            String input = br.readLine();
            int k = Integer.parseInt(br.readLine());
            int[] idx_arr = new int[26];    // 알파벳 배열

            ArrayList<ArrayList<Integer>> alp = new ArrayList<>();  // 해당하는 위치
            //초기화
            for(int i=0; i<26; i++){
                alp.add(new ArrayList<>());
            }

            for(int i=0; i<input.length(); i++){
                int idx = input.charAt(i) - 'a';    // 해당 위치
                alp.get(idx).add(i);    // 글자 위치 추가
                if(alp.get(idx).size() >= k){
                    int value = i - alp.get(idx).get(idx_arr[idx]) + 1; // 글자 길이
                    answer1 = Math.min(answer1, value); // 정답1
                    answer2 = Math.max(answer2, value); // 정답2
                    idx_arr[idx]++; // 다음 지점으로 이동
                }
            }
            if(answer1 == Integer.MAX_VALUE)
                System.out.println(-1);
            else{
                System.out.println(answer1 + " " + answer2);
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int answer1 = Integer.MAX_VALUE, answer2 = Integer.MIN_VALUE;
            int s = -1, e = -1;
            String input = br.readLine();
            int k = Integer.parseInt(br.readLine());
            int[] idx_arr = new int[26];

            ArrayList<ArrayList<Integer>> alp = new ArrayList<>();
            for(int i=0; i<26; i++){
                alp.add(new ArrayList<Integer>());
            }

            for(int i=0; i<input.length(); i++){
                int idx = input.charAt(i) - 'a';
                alp.get(idx).add(i);
                if((alp.get(idx).size()) >= k){
                    int value = i - alp.get(idx).get(idx_arr[idx]) + 1;
                    if(answer1 > value){
                        answer1 = value;
                        s = alp.get(idx).get(idx_arr[idx]);
                        e = i;
                        answer2 = answer1;
                    }
                    if(answer2 < value && alp.get(idx).get(idx_arr[idx]) <= s && e <= i){
                        answer2 = value;
                    }
                    idx_arr[idx]++;
                }
            }
            if(answer1 == Integer.MAX_VALUE)
                System.out.println(-1);
            else{
                System.out.println(answer1 + " " + answer2);
            }
        }
    }
}

// 3번과 4번 조건 둘다 만족하는 경우
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class Main {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        for(int t=0; t<T; t++){
//            int answer1 = Integer.MAX_VALUE, answer2 = Integer.MIN_VALUE;
//            int s = -1, e = -1;
//            String input = br.readLine();
//            int k = Integer.parseInt(br.readLine());
//            int[] idx_arr = new int[26];
//
//            ArrayList<ArrayList<Integer>> alp = new ArrayList<>();
//            for(int i=0; i<26; i++){
//                alp.add(new ArrayList<Integer>());
//            }
//
//            for(int i=0; i<input.length(); i++){
//                int idx = input.charAt(i) - 'a';
//                alp.get(idx).add(i);
//                if((alp.get(idx).size()) >= k){
//                    int value = i - alp.get(idx).get(idx_arr[idx]) + 1;
//                    if(answer1 > value){
//                        answer1 = value;
//                        s = alp.get(idx).get(idx_arr[idx]);
//                        e = i;
//                        answer2 = answer1;
//                    }
//                    if(answer2 < value && alp.get(idx).get(idx_arr[idx]) <= s && e <= i){
//                        answer2 = value;
//                    }
//                    idx_arr[idx]++;
//                }
//            }
//            if(answer1 == Integer.MAX_VALUE)
//                System.out.println(-1);
//            else{
//                System.out.println(answer1 + " " + answer2);
//            }
//        }
//    }
//}