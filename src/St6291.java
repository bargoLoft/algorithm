import java.io.*;
import java.util.*;
// 강의실 배정

// 그리디 문제. 클래스 정렬..! 을 알아야 함. 이거 중요.
// 오름차순은 this - o
public class St6291 {
    static class Node implements Comparable<Node>{
        int str;
        int end;

        public Node(int str, int end) {
            this.str = str;
            this.end = end;
        }

        public int compareTo(Node o){
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        Node[] lectures = new Node[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Node(str,end);
        }

        Arrays.sort(lectures);

        int cnt = 0;
        int curTime = 0;

        for(Node lecture : lectures){
            if(lecture.str < curTime) continue;

            cnt++;
            curTime = lecture.end;
        }

        System.out.println(cnt);
    }
}
