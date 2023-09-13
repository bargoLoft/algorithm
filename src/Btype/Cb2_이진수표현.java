package Btype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cb2_이진수표현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1;t<=T;t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int ans = 1;

            for(int i=0;i<N;i++){
                if(M%2==0){
                    ans =0;
                    break;
                }
                M/=2;
            }

            if(ans == 1){
                System.out.printf("#%d ON",t);
            }
            else if(ans == 0){
                System.out.printf("#%d OFF",t);
            }
            System.out.println();
        }
    }
}
