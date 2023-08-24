import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= 10; t++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken()); // 입력 값 길이
            int start = Integer.parseInt(st.nextToken()); // 시작 번호

            ArrayList<Integer>[] al = new ArrayList[101]; // 최대 사람수 100
            int[] isVisited = new int[101]; // 방문 체크 배열

            // 객체 초기화.
            for (int i = 0; i <= 100; i++) {
                al[i] = new ArrayList();
            }

            // 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < length / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                al[from].add(to);
            }

            // 큐에 집어 넣기. 싸이클 체크용 임시 큐.
            Queue<Integer> q = new ArrayDeque<>();
            Queue<Integer> tmp = new ArrayDeque<>();

            q.add(start); // 시작

            while (!q.isEmpty()) {
                int qSize = q.size(); // 현재 사이클의 크기.
                int max = 0; // 현재 사이클의 최대 값
                // 큐 크기 만큼 돌아준다.
                for (int i = 0; i < qSize; i++) {
                    int now = q.poll();
                    if (now > max) max = now; // 최대값 갱신.
                    // 다음 간선 전화걸기.
                    for (int n : al[now]) {
                        if (isVisited[n] == 0) {
                            tmp.add(n);
                            isVisited[n] = 1;
                        }
                    }
                }
                // 임시 큐에 아무것도 없다면 마지막 사이클.
                if (tmp.isEmpty()) {
                    System.out.printf("#%d %d\n", t, max); // 출력하고 종료.
                    break;
                } else {
                    // 없다면 임시 큐에서 옮겨서 다음 사이클 개시.
                    while (!tmp.isEmpty()) {
                        q.add(tmp.poll());
                    }
                }
            }
        }
    }
}
