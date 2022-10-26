import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();    // 우선순위 큐 선언
        for(int i = 0; i<scoville.length; i++){ // 우선순위 큐에 데이터 입력
            heap.add(scoville[i]);
        }
        while(heap.peek() < K){ // 스코빌 지수를 K 이상으로 만들때까지 반복
            if(heap.size() < 2) // 스코빌 지수가 1개 남고 K 이상이 되지 않을 경우
                return -1;
            int first = heap.poll();    // 가장 맵지 않은 음식의 스코빌
            int second = heap.poll();   // 두번째로 맵지 않은 음식의 스코빌
            int new_value = first + (second * 2);
            heap.add(new_value);    // 우선순위 큐에 데이터 삽입
            answer++;
        }
        return answer;
    }
}