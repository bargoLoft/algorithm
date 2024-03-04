import java.io.*;
import java.util.*;

public class Bj13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 트럭의 수
        int W = Integer.parseInt(st.nextToken()); // 다리의 길이
        int L = Integer.parseInt(st.nextToken()); // 다리의 최대 하중
        ArrayDeque<Integer> trucks = new ArrayDeque<>();
        int[] bridge = new int[W+2];
        int currentL = 0;

        // 트럭 무게 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            trucks.add(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        // 트럭 Queue가 안 비어있을 동안.
        while(!trucks.isEmpty()){
            // 다리 탈출

            for(int i=W;i>=1;i--){
                // 앞 자리가 비었으면 이동
                if(bridge[i]!=0 && bridge[i+1]==0){
                    bridge[i+1] = bridge[i];
                    bridge[i]=0;
                    // 마지막이였으면 다리 무게 감소
                    if(i==W){
                        currentL-=bridge[i+1];
                        bridge[i+1] = 0;
                    }
                }
            }
            // 진입로가 비어있고 무게가 초과 안 하면 다리 진입
            if(bridge[1]==0 && currentL+trucks.peek()<=L){
                bridge[1] = trucks.pop();
                currentL+= bridge[1];
            }
            time++;
//            System.out.println(time);
//            for(int i : bridge){
//                System.out.printf(i+" ");
//            }
//            System.out.println();
        }
        time+=W;

        System.out.println(time);


    }
}
