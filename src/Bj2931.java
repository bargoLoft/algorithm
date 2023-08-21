import java.io.*;
import java.util.*;
// 가스관.
// 반례 지옥. 정올에 테케 있음.
// M과 Z가 붙어있을 경우 있음. MZ 주변 블록이 하나만 있음. M과 Z는 블록이 아님.
public class Bj2931 {
    static class Tile {
        int i;
        int j;

        int[] rdlt = new int[4];
        char block;

        public Tile() {
            super();
        }

        public Tile(int i, int j, int[] rdlt,char b) {
            super();
            this.i = i;
            this.j = j;
            this.rdlt = rdlt;
            this.block = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Tile M = new Tile();
        Tile Z = new Tile();
        int eraseX = -1;
        int eraseY = -1;
        char eraseB = 'x';

        Tile[][] map = new Tile[R][C];
        int[][] isVisited = new int[R][C];

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        char[] block = {'|','-','+','1','2','3','4'};
        int[][] rdltCase = {
                {0,1,0,1},
                {1,0,1,0},
                {1,1,1,1},
                {1,1,0,0},
                {1,0,0,1},
                {0,0,1,1},
                {0,1,1,0},
        };

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                // 도면 입력.
                char tmp = s.charAt(j);
                int[] rdlt = new int[4];
                Tile t = new Tile();

                switch (tmp) {
                    case 'M':
                        M.i = i;
                        M.j = j;
                        rdlt[0] = 0;
                        rdlt[1] = 0;
                        rdlt[2] = 0;
                        rdlt[3] = 0;
                        M.rdlt = rdlt;
                        t.block = 'M';
                        break;
                    case 'Z':
                        Z.i = i;
                        Z.j = j;
                        rdlt[0] = 0;
                        rdlt[1] = 0;
                        rdlt[2] = 0;
                        rdlt[3] = 0;
                        Z.rdlt = rdlt;
                        t.block = 'Z';
                        break;
                    case '|':
                        rdlt[1] = 1;
                        rdlt[3] = 1;
                        t.block = '|';
                        break;
                    case '-':
                        rdlt[0] = 1;
                        rdlt[2] = 1;
                        t.block = '-';
                        break;
                    case '+':
                        rdlt[0] = 1;
                        rdlt[1] = 1;
                        rdlt[2] = 1;
                        rdlt[3] = 1;
                        t.block = '+';
                        break;
                    case '1':
                        rdlt[0] = 1;
                        rdlt[1] = 1;
                        t.block = '1';
                        break;
                    case '2':
                        rdlt[0] = 1;
                        rdlt[3] = 1;
                        t.block = '2';
                        break;
                    case '3':
                        rdlt[2] = 1;
                        rdlt[3] = 1;
                        t.block = '3';
                        break;
                    case '4':
                        rdlt[1] = 1;
                        rdlt[2] = 1;
                        t.block = '4';
                        break;
                    case '.':
                        t.block = '.';
                        break;
                }

                t.i = i;
                t.j = j;
                t.rdlt = rdlt;

                map[i][j] = t;
            }
        }

        Queue<Tile> q = new ArrayDeque<>();
        q.add(map[M.i][M.j]);
        isVisited[M.i][M.j] = 1;

        while (!q.isEmpty()) {
            Tile now = q.poll();

            // 유치원 도착하면 종료.
            if (now.i == Z.i && now.j == Z.j) {
                break;
            }
            // 갔는데 빈 땅이면. 지운 땅.
            if (now.block=='.') {
                for (int i = 0; i < 4; i++) {
                    if (now.i + dx[i] < 0 || now.i + dx[i] >= R || now.j + dy[i] < 0 || now.j + dy[i] >= C) {
                        continue;
                    }
//                    if(isVisited[now.i + dx[i]][now.j + dy[i]]==true){
//                        continue;
//                    }
                    if (map[now.i + dx[i]][now.j + dy[i]].rdlt[(i + 2) % 4] == 1) {
                        now.rdlt[i] = 1;
                    }
                }
                char tmpBlock = '.';
                for(int i=0;i<7;i++){
                    int cnt =0 ;
                    for( int j=0;j<4;j++){
                        if(rdltCase[i][j] == now.rdlt[j]){
                            cnt++;
                        }
                    }
                    if(cnt == 4){
                        tmpBlock = block[i];
                        break;
                    }
                }
                // 만약 초기값이면 맞는 블럭이 없는 경우
                if(tmpBlock == '.'){
                    for(int i=0;i<4;i++){
                        now.rdlt[i] = 0;
                    }
                } else{
                    eraseB = tmpBlock;
                    eraseX = now.i;
                    eraseY = now.j;
                }
            }
            for (int i = 0; i < 4; i++) {
                if (now.i + dx[i] < 0 || now.i + dx[i] >= R || now.j + dy[i] < 0 || now.j + dy[i] >= C) {
                    continue;
                }

                // 뚫려 있다면
                if (now.rdlt[i] == 1) {
                    // + 라면 직진.
                    int reverse = (i+2)%4;

                    // 방문하지 않았다면 q에 추가하고 방문.
                    // +는 직진만 가능.
                    if (isVisited[now.i + dx[i]][now.j + dy[i]] == 0
                            ||(now.block == '+' && (isVisited[now.i+dx[reverse]][now.j+dy[reverse]]==1) && isVisited[now.i + dx[i]][now.j + dy[i]] == 0)) {
                        q.add(map[now.i + dx[i]][now.j + dy[i]]);
                        isVisited[now.i + dx[i]][now.j + dy[i]]++;
                    }
                }
                if( now.block == 'M' && map[now.i + dx[i]][now.j + dy[i]].block != '.' && map[now.i + dx[i]][now.j + dy[i]].block != 'Z'){
                    q.add(map[now.i + dx[i]][now.j + dy[i]]);
                    isVisited[now.i + dx[i]][now.j + dy[i]]++;
                }
            }

        }

        System.out.printf("%d %d %c", eraseX+1, eraseY+1, eraseB);
    }
}

