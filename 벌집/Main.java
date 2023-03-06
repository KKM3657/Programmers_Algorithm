import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long input = sc.nextLong();
        // 1인 경우
        if(input == 1){
            System.out.println(1);
            System.exit(0);
        }

        long value = 1, idx = 1;
        do{
            value = value + (6 * idx);  // 규칙 -> 차이가 6의 배수 만큼 증가함 
            idx++;
        }while(value < input);
        System.out.print(idx);
    }
}