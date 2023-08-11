import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
// 회의실 배정.
public class Bj1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] meetings = new int[N][2];
        int meeting = 0; // 미팅이 열린 횟수

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        // comparator, lambda 사용
        Arrays.sort(meetings, (o1, o2) -> {
            if(o1[1] == o2[1]){ // 만약 끝나는 시간이 같다면
                return o1[0] - o2[0]; // 시작시간 기준으로 오름차순
            }
            return o1[1] - o2[1]; // 오름차순.
        });

        // 끝나는 시간 기준으로 삽입정렬. 하면 시간 초과.
//       for(int idx = 1;idx <N;idx++){
//           int tmpStart = meetings[idx][0];
//           int tmpEnd = meetings[idx][1];
//           int aux = idx - 1;
//           while((aux>=0) && (meetings[aux][1]>tmpEnd)){
//               meetings[aux+1][0] = meetings[aux][0];
//               meetings[aux+1][1] = meetings[aux][1];
//               aux--;
//           }
//           meetings[aux+1][0] = tmpStart;
//           meetings[aux+1][1] = tmpEnd;
//       }
//       for(int i=0;i<N;i++){
//           System.out.printf("%d %d",meetings[i][0],meetings[i][1]);
//           System.out.println();
//       }

       int end = 0; // 끝나는 시간.
       for(int i=0;i<N;i++){
           // 시작시간이 끝나는 시간보다 같거나 크면 진행시켜!
           if(meetings[i][0]>=end){
               meeting++; // 회의 수 + 1
               end = meetings[i][1]; // 끝나는 시간 최신화.
           }
       }
       System.out.println(meeting);
    }
}
