import java.io.*;
import java.util.*;
// 나이순 정렬

// 커스텀 클래스 정렬 정복하기
public class Bj10814 {
    static class Member implements Comparable<Member>{
        int id;
        int age;
        String name;

        public Member(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        public int compareTo(Member m){
            if(this.age < m.age) return -1;
            else if(this.age == m.age){
                if(this.id < m.id) return -1;
            }

            return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        Member[] members = new Member[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members[i] = new Member(i,age,name);
        }

        Arrays.sort(members);

        for(int i=0;i<N;i++){
            Member m = members[i];
            sb.append(m.age+" "+m.name+"\n");
        }

        System.out.println(sb);
    }
}
