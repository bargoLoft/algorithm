import java.io.*;
import java.util.*;

public class Bj1244 {

    // 스위치 켜고 끄기
    static int click(int n){
        if(n==0)
            return 1;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] swt = new int[N]; // 스위치 배열

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            swt[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] stdGen = new int[n]; // 학생 성별 배열
        int[] stdNum = new int[n]; // 학생 넘버 배열

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            stdGen[i] = Integer.parseInt(st.nextToken());
            stdNum[i] =  Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++){
            if(stdGen[i] == 1){
                //남자 - 배수 키고 끄기.
                for(int j=stdNum[i]-1;j<N;j+=stdNum[i]){
                    swt[j] = click(swt[j]);
                }
            } else{
                //여자 - 자기 중심으로 키고 끄기.
                for(int j=0;j<N/2;j++){
                    int srcF = stdNum[i]-j-1; // 자기 기준 j칸 앞
                    int srcB = stdNum[i]+j-1; // 자기 기준 j칸 뒤

                    if(srcF >=0 && srcB < N && swt[srcF] ==swt[srcB]){
                        swt[srcF] = click(swt[srcF]);
                        if(j!=0) // 0일때는 한 번만 실행하기 위해.
                            swt[srcB] = click(swt[srcB]);
                    } else{
                        break;
                    }
                }
            }
        }

        for(int onOff: swt){
            System.out.println(onOff);
        }
    }
}
