import java.io.*;
import java.util.*;
// 카드셔플.
// while(str<end) 기법 사용
public class Bj10804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] card = new int[21];
        int[][] swap = new int[10][2];

        // 입력
        for(int i=1;i<=20;i++){
            card[i] = i;
        }

        for(int i=0;i<10;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            swap[i][0] = Integer.parseInt(st.nextToken());
            swap[i][1] = Integer.parseInt(st.nextToken());
        }

        // 셔플
        for(int i=0;i<10;i++){
            int str = swap[i][0];
            int end = swap[i][1];

            while(str<end){
                int tmp = card[str];
                card[str] = card[end];
                card[end] = tmp;
                str++; end--;
            }
        }

        for(int i=1;i<=20;i++){
            System.out.print(card[i]+" ");
        }

    }
}
