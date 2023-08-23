import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 줄기세포 배양.
// priorityQueue!!
// compareTo..!!
// reverseOrder..!!!!!
public class Swea5653 {
    static class Cell implements Comparable<Cell> {
        int x;
        int y;
        int level;
        int life;

        public Cell(int x, int y, int level, int hp) {
            this.x = x;
            this.y = y;
            this.level = level; // 3
            this.life = hp; // 6 -> 6 5 4 3 2 1 0
        }

        @Override
        public int compareTo(Cell target) {
            // 양수 -> 바꿈.
            // this, target 순서대로.
            // 내림차순.
            return (this.level - target.level) * -1;
        }
    }
    //저는 1초마다 해서 그냥 생명력 쌘 애가 먼저..

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Cell[][] map = new Cell[N + 400][M + 400];

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            PriorityQueue<Cell> q = new PriorityQueue<>(); // reverseorder.......

            // 초기 세팅.
            for (int i = 0; i < N + 400; i++) {
                for (int j = 0; j < M + 400; j++) {
                    map[i][j] = new Cell(i, j, -1, -1);
                }
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if (tmp != 0) {
                        map[i + 200][j + 200] = new Cell(i, j, tmp, tmp * 2);
                        // 초기 세팅 세포들 전부 큐에 삽입.
                        q.offer(map[i + 200][j + 200]);
                    }
                }
            }

            // 현재 큐 크기만큼만 한 사이클씩 돌려준다.
            for (int i = 1; i <= K; i++) {
                Queue<Cell> tmp = new ArrayDeque<>();
                while (!q.isEmpty()) {
                    Cell c = q.poll(); // compareTo에 의해 높은 생명력 바이러스 부터 출력.
                    c.life--;

                    // 번식
                    if (c.life == c.level - 1) {
                        for (int d = 0; d < 4; d++) {
                            int nx = c.x + dx[d];
                            int ny = c.y + dy[d];
                            // 셀이 비어 있다면
                            if (map[nx + 200][ny + 200].level == -1) {
                                // 새로운 세포 복제.
                                Cell newCell = new Cell(nx, ny, c.level, c.level * 2);
                                map[nx + 200][ny + 200] = newCell;
                                tmp.offer(newCell);
                            }
                        }
                    }

                    // 수명이 남았다면 다시 큐에 삽입.
                    if (c.life >= 1) {
                        tmp.offer(c);
                    }
                }
                // 임시큐 항목들을 우선 순위 큐로 이동.
                while (!tmp.isEmpty()) {
                    q.offer(tmp.poll());
                }
            }
            System.out.printf("#%d %d\n", t, q.size());
        }
    }
}
