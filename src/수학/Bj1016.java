package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 제곱 ㄴㄴ 수
// 틀림
public class Bj1016 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        ArrayList<Long> arr = new ArrayList<>((int) (max-min+1));
        ArrayList<Boolean> p = new ArrayList<>(1000001);

        // 에라토스테네스의 체로 1부터 100만 사이의 소수 구하기.
        p.add(false);
        p.add(false);
        for(int i=2;i<=1000000;i++){
            p.add(true);
        }

        for(int i=0;(i*i)<1000000;i++){
            if(p.get(i)){
                for(int j=i*i;j<=1000000;j+=i)
                    p.set(j,false);
            }
        }

        int cnt =0 ;

        //에라토스체로 구한 소수 가지고
//        for(int i=2;i<=Math.sqrt(max);i++){
//            if(p.get(i)==false)
//                continue;
//            for(int j=0;j<=(int)(max-min)+1;j++){
//                if(arr[j]%(i*i)==0)
//                    arr[j]=0;
//            }
//        }

        System.out.println(cnt);
    }



}
