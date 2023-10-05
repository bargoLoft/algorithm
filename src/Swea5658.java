import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 보물상자 비밀번호
// for for for
// treeSet으로 자동 정렬(내림차순은 Collections.reverseOrder())
// set.Size() 사용시 실시간으로 줄어드는 거 조심. 미리 사이즈 구하고 그거 쓰기.
public class Swea5658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1;t<=T;t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            String s = br.readLine();
            Deque<Integer> q = new ArrayDeque();
            TreeSet set = new TreeSet(Collections.reverseOrder());

            for(int i=0;i<N;i++){
                int tmp = s.charAt(i);
                if('A'<=tmp && tmp<='F') tmp = tmp - 'A' + 10;
                else tmp = tmp - '0';
                q.add(tmp);
            }
            for(int k=0;k<N/4;k++){
                for(int j=0;j<4;j++){
                    int sum = 0;
                    for(int i=0;i<N/4;i++){
                        int tmp= q.pollLast();
                        sum += tmp * Math.pow(16,i);
                        q.addFirst(tmp);
                    }
                    set.add(sum);
                }
                q.addFirst(q.pollLast());
            }
            int size = set.size();
            for(int i=1;i<=size;i++){
                if(i==K){
                    System.out.printf("#%d %d\n",t,set.pollFirst());
                    break;
                }
                set.pollFirst();
            }
        }
    }
}
