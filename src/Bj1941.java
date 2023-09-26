import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 소문난 칠공주
// dps(...) + 인접한 지 체크.
//
public class Bj1941 {
    static int[] student;
    static int[] isVisited;
    static int[] princess7;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int cnt;
    static int available;
    static int[] isVisited2;
    static void check(int num) {
        int x = num / 5;
        int y = num % 5;
        for(int d=0;d<4;d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            int nextNum = nx*5 + ny;
            if(nx<0||nx>=5||ny<0||ny>=5) continue;
            if(isVisited[nextNum] != 1) continue;
            if(isVisited2[nextNum] == 1) continue;
            available++;
            isVisited2[nextNum] = 1;
            check(nextNum);
        }
    }
    static void unite(int dep,int yeon){
        if(yeon >= 4) return;
        if(dep == 7){
            available = 1;
            isVisited2 = new int[25];
            isVisited2[princess7[0]] = 1;
            check(princess7[0]);
            if(available == 7) cnt++;
            return;
        }

        for(int i=0;i<25;i++){
            if(isVisited[i] == 1) continue;
            if(dep!=0 && princess7[dep-1] > i) continue;
            // not 이다솜이 4명이 되면 out.

            isVisited[i] = 1;
            princess7[dep] = i;
            if(student[i] == 'Y') unite(dep+1,yeon+1);
            else unite(dep+1,yeon);
            isVisited[i] = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        student = new int[25];
        princess7 = new int[7];
        isVisited = new int[25];
        cnt = 0;

        for(int i=0;i<5;i++){
            String s = br.readLine();
            for(int j=0;j<5;j++){
                student[5*i+j] = s.charAt(j);
            }
        }

        unite(0,0);

        System.out.println(cnt);
    }
}
