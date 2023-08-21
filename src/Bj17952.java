import java.io.*;
import java.util.*;

public class Bj17952 {
    // 업무
    static class Work{
        int score; // 점수
        int time; // 남은 시간

        public Work() {
            super();
        }

        public Work(int score, int time) {
            super();
            this.score = score;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 전체 업무 시간 N
        Work[] work = new Work[N]; // 매분 할일을 저장하는 배열 work
        int totalScore = 0; // 김삼성씨 업무 평가 점수.


        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            Work tmp = new Work(0,0);
            // 업무가 주어진 지 판단.
            int amIWork =  Integer.parseInt(st.nextToken());
            if(amIWork == 0) {
                // 업무 없으면 다음으로.
                work[i] = tmp;
                continue;
            }

            // 업무 있으면 정보 기입하기.
            tmp.score = Integer.parseInt(st.nextToken());
            tmp.time = Integer.parseInt(st.nextToken());
            work[i] = tmp;
        }

        // 후입선출 Stack.
        Stack<Work> s = new Stack<>();

        for(int i=0;i<N;i++) {
            Work newWork = work[i];
            // 새로 온 업무가 있다면
            if(newWork.score!=0) {
                s.add(newWork); // 새로들어온 업무 넣기
            }

            // 할 일이 없으면 월급루팡.
            if(s.isEmpty()) {
                continue;
            }

            // 할 일 꺼내기
            Work now = s.pop();
            now.time--; // 일하기

            // 일 마쳤으면. 점수 더하기.
            if(now.time == 0) {
                totalScore+=now.score;
            } else {
                // 다 못했으면 도로 집어 넣기.
                s.add(now);
            }
        }

        // 출력.
        System.out.println(totalScore);

    }
}
