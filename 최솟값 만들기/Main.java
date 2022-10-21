import java.util.Arrays;
class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A); // 오름차순 정렬
        Arrays.sort(B); // 오름차순 정렬
        int answer = 0;
        // Two Point 이용, i는 최소 지점, j는 최대 지점
        for(int i = 0, j = A.length-1; i <= j; i++, j--){
            if(i == j){ // i와 j가 만나는 경우
                answer += (A[i] * B[i]);
                break;
            }
            answer += ((A[i] * B[j]) + (A[j] * B[i]));
        }
        return answer;
    }
}