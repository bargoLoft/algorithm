import java.io.*;
import java.util.*;

// 영식 민쑤

public class Bj1267 {
    static int calY(int[] t){
        int b = 0; // 요금

        for(int i=0;i<t.length;i++){
            b+=(t[i]/30 * 10) + 10;
        }

        return b;
    }

    static int calM(int[] t){
        int b = 0; // 요금

        for(int i=0;i<t.length;i++){
            b+=(t[i]/60 * 15) + 15;
        }

        return b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[] times = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            times[i] = Integer.parseInt(st.nextToken());
        }

        int YCharge = calY(times);
        int MCharge = calM(times);

        if(YCharge<MCharge){
            System.out.printf("Y "+YCharge);
        } else if(YCharge>MCharge){
            System.out.printf("M "+MCharge);
        } else {
            System.out.println("Y M "+YCharge);
        }
    }
}
