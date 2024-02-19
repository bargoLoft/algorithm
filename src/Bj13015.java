import java.io.*;
import java.util.*;
// 별 찍기 - 23

// 절대값 Math.abs();
// 출력 끝의 공백은 출력 X
public class Bj13015 {
    // 별 찍기
    static void printStar(int N){
        for(int i=0;i<N;i++){
            System.out.printf("*");
        }
    }

    // 공백 찍기
    static void printSpace(int N){
        for(int i=0;i<N;i++){
            System.out.printf(" ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        for(int i=0;i<2*N-1;i++){
            // 첫줄 or 마지막 줄
            if(i==0 || i==2*N-2){
                // N개 만큼 별 찍기
                printStar(N);
                // 2*|N-i-1|-1 개 만큼 공백 찍기
                printSpace(2*Math.abs(N-i-1)-1);
                // N개 만큼 별 찍기
                printStar(N);
                System.out.println( );
            }
            // 가운데 줄
            else if(i==N-1){
                printSpace(N-1);
                printStar(1);
                printSpace(N-2);
                printStar(1);
                printSpace(N-2);
                printStar(1);
                //printSpace(N-1);
                System.out.println();
            }
            // 그 외
            else{
                // 0 1 2 3 4 3 2 1 0 y=-|x-4|+4
                printSpace((N-1)-Math.abs(i-(N-1)));
                printStar(1);
                printSpace(N-2);
                printStar(1);
                printSpace(2*Math.abs(N-i-1)-1);
                printStar(1);
                printSpace(N-2);
                printStar(1);
                //printSpace((N-1)-Math.abs(i-(N-1)));
                System.out.println();
            }
        }
    }
}
