import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj19621 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] meetings = new int[N+1][3];


        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작
            meetings[i][1] = Integer.parseInt(st.nextToken()); // 끝
            meetings[i][2] = Integer.parseInt(st.nextToken()); // 인원
        }

        meetings[N][2] = 0;

        int isComport = 1; // 편안한 지
        int difSum = 0; // 그동안의 차이.
        int peopleCount = 0; // 미팅의 참가한 사람 수

        for(int i=0;i<(N+1)/2;i++){
            // 편한 상태
            if(isComport == 1){
                // 여전히 편-안
                if(meetings[2*i][2]>=meetings[2*i+1][2]){
                   peopleCount+= meetings[2*i][2];
                }
                // 앗! 불편해졌다
                else{
                    peopleCount+=meetings[2*i+1][2];
                    difSum += meetings[2*i+1][2]-meetings[2*i][2]; // 차이를 기록
                    isComport = 0;
                }
            }
            // 불편한 상태
            else if (isComport == 0){
                if(meetings[2*i][2]>=meetings[2*i+1][2]){
                    // 앗.. 충돌..!
                    if(meetings[2*i][2]-meetings[2*i+1][2] >= difSum){
                        peopleCount-=difSum; // 그동안 차이를 빼주고
                        peopleCount+=meetings[2*i][2]; // 불편함에서 해방시켜준 친구 넣어주고
                        difSum = 0; // 차이 초기화.
                        isComport = 1; // 편안
                    }
                    // 여전히 불편
                    else{
                        peopleCount+=meetings[2*i+1][2];
                        difSum += meetings[2*i+1][2]-meetings[2*i][2]; // 그나마 줄어든 차이
                    }
                } else{
                    // 여전히 불편
                    peopleCount+=meetings[2*i+1][2];
                    difSum += meetings[2*i+1][2]-meetings[2*i][2]; // 차이를 기록
                }
            }
        }
        System.out.println(peopleCount);

    }
}
