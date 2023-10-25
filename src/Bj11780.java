import java.io.*;
import java.util.*;
//플로이드 2

//플로이드 워샬 알고리즘
//O(n^3)
public class Bj11780 {
    static int INF = 10000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        int map[][] = new int[N+1][N+1];
        List<Integer> root[][] = new List[N+1][N+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                map[i][j] = INF;
                if(i==j) map[i][j] = 0;

                root[i][j] = new ArrayList();
                root[i][j].add(j);
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(map[a][b] == INF || c < map[a][b])
                map[a][b] = c;
        }

        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(i==j) continue;
                    if(map[i][j] > map[i][k]+map[k][j]){
                        map[i][j] = map[i][k]+map[k][j];
                        root[i][j].add(0,k);
                    }
                }
            }
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(map[i][j] == INF) System.out.print(0+" ");
                else System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(map[i][j] == INF || map[i][j] == 0) System.out.print(0+" ");
                else{
                    System.out.print((root[i][j].size()+2+" "));
                    System.out.print(i+" ");
                    for(int k=0;k<root[i][j].size();k++){
                        System.out.print(root[i][j].get(k)+" ");
                    }
                    System.out.print(j+" ");
                }
                System.out.println();
            }
        }

    }
}
