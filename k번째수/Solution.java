class Solution {
    // 교환
    public void swap(int[] arr, int a_index, int b_index){
        int temp = arr[a_index];
        arr[a_index] = arr[b_index];
        arr[b_index] = temp;
    }
    // pivot으로 나누기
    public int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }    
        }
        swap(arr, i+1, high);
        return i+1;
    }
    // 퀵소트 구현
    public void quick_sort(int[] arr, int low, int high){
        if(low < high){
            int pos = partition(arr, low, high);    // pivot 위치
            quick_sort(arr, low, pos-1);    // 앞부분
            quick_sort(arr, pos+1, high);   // 뒷부분
        }
    }
    // 구간에 해당하는 k번째 수 구하기
    public int find_k(int[] arr, int[] command){
        int first = command[0] - 1, end = command[1] - 1;
        int k = command[2];
        int[] new_array = new int[end-first+1];
        // 배열 생성 및 초기화
        for(int i = 0; i < end-first+1 ; i++){
            new_array[i] = arr[first + i];
        }
        quick_sort(new_array, 0, end-first);
        return new_array[k - 1];
    }
    public int[] solution(int[] array, int[][] commands) {
        int answer_num = commands.length;
        int[] answer = new int[answer_num];
        
        for(int i = 0; i < answer_num; i++){
            answer[i] = find_k(array, commands[i]);
        }
        return answer;
    }
}