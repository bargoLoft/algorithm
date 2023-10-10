package Practice;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static User user = new User();

    public static void main(String[] args) throws Exception {
        while(true){
            System.out.println("1 : 회원가입\n2 : 로그인\n3 : 종료");
            System.out.print(">>>>>> ");

            String n = in.nextLine();

            if(n.equals("1")) make_user();
            else if(n.equals("2")) login();
            else if(n.equals("3")) break;
            else if(n.equals("master")){
                System.out.println("관리자");
                user.get_DB();
            }
            else System.out.println("잘못 입력");
            System.out.println();
        }
    }

    // 회원가입
    static void make_user() throws Exception{
        System.out.print("아이디를 입력하시오\n>>>>> ");
        String id = in.nextLine();
        System.out.print("비밀번호를 입력하시오\n>>>>> ");
        String pass = in.nextLine();
        user.set_User(id,pass.getBytes());
        System.out.println("회원가입이 완료 되었습니다.\n");
    }

    // 로그인
    static void login() throws Exception{
        System.out.print("ID : ");
        String id = in.nextLine();
        System.out.print("PASSWORD : ");
        String pass = in.nextLine();

        user.get_User(id, pass.getBytes());
    }
}



/*
로그인 패스워드 검증 절차
1. 회원가입 시의 암호화
사용자가 회원가입 시 입력한 패스워드는 SHA-256 알고리즘을 통해 암호화됩니다. 이렇게 암호화 된 패스워드는 데이터베이스에 저장됩니다.
2. 로그인 시의 해시 값 추출
사용자가 로그인을 시도할 때, 입력한 패스워드는 다시 SHA-256 알고리즘을 통해 암호화 됩니다.
3. 저장된 패스워드의 조회
사용자가 입력한 아이디에 해당하는 패스워드의 해시 값이 데이터 베이스에서 조회됩니다.
4. 패스워드의 일치 여부 확인
사용자가 입력한 패스워드의 해시 값과 데이터 베이스에 저장된 해시 값이 일치하는 지 확인합니다. 일치하면 인증 성공.

기존 프로젝트의 비밀번호 확인 과정에서 해쉬화 한 값을 넘기고
회원가입시에도 비밀번호를 해시화 해서 DB에 저장한다. 이 두 로직만 변경하면 끝.

+ key stretching
해시 함수 여러번 수행하기.
사용자의 경우 일치 확인에 0.x초가 더 걸려도 문제가 없지만 브루트 포스로 무차별 대입하는 해커 입장에는 치명적.

+ salt
원문에 임의의 문자열을 덧붙이는 것. (소금친다)
회원가입 시 해시 과정에 무작위 salt를 생성 후 DB에 같이 저장.
유저가 로그인 시 비밀번호와 DB에 저장된 salt(각 회원의 고유한 값)과 같이 해시화 해서 검증.

솔트는 임의의 문자열이기에 Rainbow Table에 없을 가능성이 매우 높아진다.
물론 솔팅할 문자열이 간단하거나, 짧으면 큰 의미가 없어진다.
효과적인 방법을 구현하려면, 각 사용자별 고유의 솔트가 있어야하며 솔트의 길이는 32비트 이상이 되어야
추측하기 어렵다고 한다.
 */