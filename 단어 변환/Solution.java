import java.util.Queue;
import java.util.LinkedList;
// 해당 단어와 words 안에서의 인덱스 번호를 저장하기 위한 Pair
class Pair{
    int num;
    String name;
    
    public Pair(int num, String name){
        this.num = num;
        this.name = name;
    }
}
class Solution {
    boolean[] visited;  // 방문기록
    int[] step; // 횟수
    Queue<Pair> q = new LinkedList<>(); // 큐
    // 다음 단어로 변경할 수 있는지 판별
    public boolean can_go(String target, String word){
        int k = 0;
        // 단어 하나만 바꿨을 때 같은지 구하기
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == word.charAt(i)) {
                k++;
            }
        }
        if(k == target.length() - 1)
            return true;
        else
            return false;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];    // 방문 했는지 확인하기 위한 배열
        step = new int[words.length];   // 변경 횟수를 위한 배열
        q.add(new Pair(-1, begin));    // 시작 부분 저장
        while(!q.isEmpty()){    // 큐가 빌때까지 반복
            Pair curr = q.poll();   // 다음으로 이동
            String name = curr.name;
            for(int i = 0; i < words.length; i++){
                // 방문한 적이 없으면서 다음 단어로 선택이 가능한지 판별
                if(!visited[i] && can_go(name, words[i])){
                    visited[i] = true;
                    // 처음 단어 변경인 경우
                    if(curr.num == -1)
                        step[i] = 1;
                    else
                        step[i] = step[curr.num] + 1;
                    q.add(new Pair(i, words[i]));
                }
            }
        }
        // target 단어가 있는지 그리고 답 확인
        for(int i = 0; i < words.length; i++){
            if(target.equals(words[i]))
                answer = step[i];
        }
        return answer;
    }
}