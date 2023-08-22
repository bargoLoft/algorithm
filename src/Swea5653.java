import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 줄기세포 배양.
public class Swea5653 {
    static class Cell implements Comparable<Cell> {
        int x;
        int y;
        int level;
        int life;

        public Cell(int x, int y, int level, int hp) {
            this.x = x;
            this.y = y;
            this.level = level;
            this.life = hp;
        }

        @Override
        public int compareTo(Cell target) {
            //target 이 어떤 대우를 받느냐?
            //타켓이 클 때(==큰 순서대로 뽑기) 양수 리턴.
            return this.level >= target.level ? 1 : -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Cell[][] map = new Cell[N + 300][M + 300];

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            PriorityQueue<Cell> q = new PriorityQueue<>(Collections.reverseOrder());

            // 초기 세팅.
            for (int i = 0; i < N + 300; i++) {
                for (int j = 0; j < M + 300; j++) {
                    map[i][j] = new Cell(i, j, -1, -1);
                }
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if (tmp != 0) {
                        map[i + 150][j + 150] = new Cell(i, j, tmp, tmp * 2);
                        // 초기 세팅 세포들 전부 큐에 삽입.
                        q.offer(map[i + 150][j + 150]);
                    }
                }
            }

            // for문 속 for문? 배양시간이 정해져 있다. 현재 큐 크기만큼만 한 사이클씩 돌려준다.
            for (int i = 1; i <= K; i++) {
                Queue<Cell> tmp = new ArrayDeque<>();
                while (!q.isEmpty()) {
                    Cell c = q.poll(); // compareTo에 의해 높은 생명력 바이러스 부터 출력.
                    c.life --;

                    if (c.life == c.level-1) {
                        // 번식
                        for (int d = 0; d < 4; d++) {
                            int nx = c.x + dx[d];
                            int ny = c.y + dy[d];
                            // 셀이 비어 있다면
                            if (map[nx + 150][ny + 150].level == -1) {
                                // 새로운 세포 복제.
                                Cell newCell = new Cell(nx, ny, c.level, c.level*2);
                                map[nx + 150][ny + 150] = newCell;
                                tmp.offer(newCell);
                            }
                        }
                        if(c.life!=0){
                            tmp.offer(c);
                        }
                    }

                    if(c.life>=1){
                        tmp.offer(c);
                    }
                }
                while (!tmp.isEmpty()) {
                    q.offer(tmp.poll());
                }
            }
            System.out.printf("#%d %d\n", t, q.size());
        }
    }
}
