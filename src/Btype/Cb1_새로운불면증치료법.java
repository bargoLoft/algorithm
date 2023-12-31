package Btype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cb1_새로운불면증치료법 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1;t<=T;t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int binaryCheck = 0;
            int sheep = 0;
            while(binaryCheck != (1 << 10) - 1){
                sheep+=1;
                int tmp = N*sheep;
                while(tmp!=0){
                    binaryCheck |= 1 << (tmp % 10);
                    tmp/=10;
                }
            }
            System.out.printf("#%d %d\n",t,sheep*N);

        }
    }
}
