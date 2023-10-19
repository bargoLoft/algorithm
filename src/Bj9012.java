import java.io.*;
import java.util.*;
// 괄호

// 스택. 비었는 지 확인
public class Bj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for(int t=1;t<=T;t++){
            String s = br.readLine();
            Stack stack = new Stack();
            int VPS = 1;

            loop: for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                switch (c){
                    case '(':
                        stack.add(c);
                        break;
                    case ')':
                        if(stack.isEmpty()){
                            VPS = 0;
                            break loop;
                        } else{
                            if(stack.peek().equals('(')){
                                stack.pop();
                            } else{
                                VPS = 0;
                                break loop;
                            }
                        }
                        break;
                }
            }

            if(!stack.isEmpty()) VPS = 0;

            if(VPS == 1) System.out.println("YES");
            else System.out.println("NO");

        }


    }
}
