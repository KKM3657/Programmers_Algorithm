class Solution {
    static int value;
    static int answer = 0;
    
    public static void dfs(int[] numbers, int target, int curr_num){
        
        // 리프 노드까지 탐색
        if(curr_num == numbers.length){
            // 타겟이면 정답 + 1
            if(value == target){
                answer++;
            }
            return;
        }
        
        // 값을 더한 경우 다음 노드로 이동, 리프 노드를 방문하면 원래 상태로 돌림
        value += numbers[curr_num];
        dfs(numbers, target, curr_num + 1);
        value -= numbers[curr_num];
        
        // 값을 뺀 경우 다음 노드로 이동, 리프 노드를 방문하면 원래 상태로 돌림
        value -= numbers[curr_num];
        dfs(numbers, target, curr_num + 1);
        value += numbers[curr_num];
        
        return;
        
    }
    
    public int solution(int[] numbers, int target) {
        
        int curr_num = 0;
        value = 0;
        dfs(numbers, target, curr_num);
        return answer;
    }
    
}