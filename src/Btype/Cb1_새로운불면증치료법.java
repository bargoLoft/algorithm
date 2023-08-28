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
            int N = Integer.parseInt(st.nextToken());
            int binaryCheck = 0;
            while(binaryCheck != (1 << 10) - 1){
                int tmp = N;
                while(tmp!=0){
                    binaryCheck &= 1 << N % 10;
                }
            }
        }
    }
}
