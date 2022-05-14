import java.util.Scanner;

class Reservation{
    private static String[] S = new String[10];
    private static String[] A = new String[10];
    private static String[] B = new String[10];

    //행 단위 좌석ㅡ상태 출력 함수
    public static void print_line(String[] line){
        for(int i=0; i<line.length;i++){
            if(line[i]==null)
                System.out.print("--- ");
            else
                System.out.print(line[i]+" ");
        }
    }

    //현재 좌석 상태 출력 함수
    public static boolean print_cur_line(int line){
        //입력 line 에 맞는 좌석 출력
        switch (line){
            case 1:
                System.out.print("S>>");
                print_line(S);
                System.out.println();
                break;

            case 2:
                System.out.print("A>>");
                print_line(A);
                System.out.println();
                break;

            case 3:
                System.out.print("B>>");
                print_line(B);
                System.out.println();
                break;

            //그 외 좌석타입 입력 : 에러
            default:
                System.out.println("없는 좌석타입을 선택하였습니다.");
                return false;
        }
        return true;
    }

    //좌석 예약 함수
    public static void reserve(String name, int line, int num){
        num--;
        try {
            switch (line) {
                //비어있는 좌석일 경우 name 저장
                case 1:
                    if (S[num] == null)
                        S[num] = name;
                    else
                        System.out.println("이미 예약되어있는 좌석입니다");
                    break;

                case 2:
                    if (A[num] == null)
                        A[num] = name;
                    else
                        System.out.println("이미 예약되어있는 좌석입니다");
                    break;

                case 3:
                    if (B[num] == null)
                        B[num] = name;
                    else
                        System.out.println("이미 예약되어있는 좌석입니다");
                    break;

                //그 외 좌석타입 입력: 에러
                default:
                    System.out.println("없는 좌석타입을 선택하였습니다.");
                    break;
            }
        }
        catch (IndexOutOfBoundsException e){
            //1~10 범위에 벗어난 좌석을 선택했을 경우 : 에러
            System.out.println("없는 좌석을 선택하였습니다.");
        }
    }

    //전제 좌석 상태 조회 함수
    public static void search(){
        System.out.print("S>>");
        print_line(S);
        System.out.println();
        System.out.print("A>>");
        print_line(A);
        System.out.println();
        System.out.print("B>>");
        print_line(B);
        System.out.println();
        System.out.println("<<< 조회를 완료하였습니다. >>>");
    }

    //좌석 삭제 함수
    public static void cancel(String name, int line){
        switch (line){
            case 1:
                cancel_seat(S,name);
                break;

            case 2:
                cancel_seat(A,name);
                break;

            case 3:
                cancel_seat(B,name);
                break;
            //그 외 좌석타입 입력 : 에러
            default:
                System.out.println("없는 좌석타입을 선택하였습니다.");
                break;
        }
    }

    //name 에 맞는 좌석 삭제 함수
    public static void cancel_seat(String[] line, String name){
        boolean isExist = false;

        //line[i] 에 name 과 같은 이름이 있을 경우 삭제
        for(int i=0; i<line.length ; i++){
            if(line[i] !=null)
                if(line[i].equals(name)){
                    line[i] = null;
                    isExist = true;
                    break;
                }
        }

        //일치한 좌석이 없을 경우 : 에러
        if(!isExist){
            System.out.println("잘못된 좌석을 취소하였습니다.");
        }

    }
}

public class Question_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name;

        int num;
        int line;
        int input;

        System.out.println("명품콘서트홀 예약 시스템입니다");
        while(true){
            //메뉴 선택
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >>");
            input = scanner.nextInt();

            switch (input){
                //예약
                case 1:
                    System.out.print("좌석구분 S(1), A(2), B(3)>>");
                    line = scanner.nextInt();


                    if(!Reservation.print_cur_line(line))
                        break;      //예약을 실패했을 경우

                    System.out.print("이름 >>");
                    name = scanner.next();

                    System.out.print("번호 >>");
                    num = scanner.nextInt();

                    Reservation.reserve(name,line,num);
                    break;
                //조회
                case 2:
                    Reservation.search();
                    break;
                //취소
                case 3:
                    System.out.print("좌석 S:1, A:2, B:3 >>");
                    line = scanner.nextInt();
                    if(!Reservation.print_cur_line(line))
                        break;

                    System.out.print("이름 >>");
                    name = scanner.next();

                    Reservation.cancel(name,line);
                    break;
                //종료
                case 4:
                    return;


                //그 외 메뉴 선택 : 에러
                default:
                    System.out.println("없는 메뉴를 선택하였습니다.");
                    break;
            }
        }
    }
}
