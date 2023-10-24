import java.io.*;
import java.util.*;
// 균형 잡힌 세상

// 스택
// 비었는 지 확인..!
public class Bj4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(true){
            String s = br.readLine();
            Stack<Character> stack = new Stack();
            int balance = 1;

            if(s.equals(".")) break;

            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);

                if(c=='('||c=='[') stack.add(c);
                else if(c==')'){
                    if(stack.isEmpty()){
                        balance=0;
                        break;
                    }

                    if(stack.peek()=='(') stack.pop();
                    else if(stack.peek()=='['){
                        balance=0;
                        break;
                    }
                }
                else if(c==']'){
                    if(stack.isEmpty()){
                        balance=0;
                        break;
                    }

                    if(stack.peek()=='[') stack.pop();
                    else if(stack.peek()=='('){
                        balance=0;
                        break;
                    }
                } else{
                    continue;
                }
            }

            if(!stack.isEmpty()) balance = 0;

            if(balance == 1) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
