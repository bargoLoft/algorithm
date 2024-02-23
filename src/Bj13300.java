import java.io.*;
import java.util.*;

public class Bj13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] std = new int[2][7];

        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int grd = Integer.parseInt(st.nextToken());
            std[sex][grd]++;
        }

        int cnt = 0;

        for(int i=1;i<=6;i++){
            for(int j=0;j<2;j++){
                if(std[j][i] == 0) continue;
                cnt+=(std[j][i]-1) / K + 1;
            }
        }

        System.out.println(cnt);
    }
}
