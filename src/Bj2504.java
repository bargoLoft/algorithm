import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bj2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> s = new Stack<>();
        int result = 0;
        int temp = 1;

        for(int i=0; i<input.length();i++){
            char ch = input.charAt(i);

            if(ch == '('){
                // 스택에 넣고 *2
                s.push(ch);
                temp *= 2;
            } else if(ch == '['){
                // 스택에 넣고 *3
                s.push(ch);
                temp *= 3;
            } else if(ch == ')'){
                // 스택이 비었거나 짝이 안 맞으면 땡
                if(s.isEmpty() || s.peek() != '('){
                    System.out.println(0);
                    return;
                }
                // 바로 앞이 짝이면 임시값을 결과에 더하기.
                if(input.charAt(i-1)=='('){
                    result+=temp;
                }
                // 바로 앞이 짝이 아니면 그냥 빼고 괄호를 벗긴다.
                s.pop();
                temp/=2;
            } else if(ch == ']'){
                // ')' 와 동일
                if(s.isEmpty() || s.peek() != '['){
                    System.out.println(0);
                    return;
                }
                if(input.charAt(i-1)=='['){
                    result+=temp;
                }
                s.pop();
                temp/=3;
            }
        }

        // 스택이 안 비었으면 땡!
        if(!s.isEmpty()){
            System.out.println(0);
        } else{
            System.out.println(result);
        }
    }
}
