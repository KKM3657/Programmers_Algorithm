import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Collections;

class Pair implements Comparable<Pair>{
    int idx;
    int value;

    Pair(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
    // 객체 정렬 -> 1. 앞에 큰 사람이 몇명인지 오름차순 2. 번호 내림차순
    @Override
    public int compareTo(Pair p) {
        return this.value == p.value ? p.idx - this.idx : this.value - p.value;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        LinkedList<Pair> ll = new LinkedList<>();
        LinkedList<Integer> answer = new LinkedList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            ll.add(new Pair(i,Integer.parseInt(st.nextToken())));
        }

        Collections.sort(ll);   // 객체 정렬
        
        answer.add(ll.get(0).idx);  // 초기화

        for(int i=1; i<n; i++) {
            int cnt=0, idx = 0;
            Pair curr = ll.get(i);
            for(idx=0; idx<answer.size(); idx++) {  // 앞에 큰 사람이 몇명이 되는지 확인
                if(cnt == curr.value){  // 자리를 찾으면 멈춤
                    break;
                }
                if(answer.get(idx) > curr.idx)  // 자리 탐색
                    cnt++;
            }
            answer.add(idx, curr.idx);  // 해당 자리에 사람 넣기
        }
        for(int i=0; i<n; i++)
            System.out.print(answer.get(i) + " ");
    }
}