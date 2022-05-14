import java.util.Scanner;

class Reservation{
    private static String[] S = new String[10];
    private static String[] A = new String[10];
    private static String[] B = new String[10];


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

                default:
                    System.out.println("없는 좌석타입을 선택하였습니다.");
                    break;
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("없는 좌석을 선택하였습니다.");
        }
    }

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

            default:
                System.out.println("없는 좌석타입을 선택하였습니다.");
                break;
        }
    }

    public static void cancel_seat(String[] line, String name){
        boolean isExist = false;

        for(int i=0; i<line.length ; i++){
            if(line[i] !=null)
                if(line[i].equals(name)){
                    line[i] = null;
                    isExist = true;
                    break;
                }
        }

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
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >>");
            input = scanner.nextInt();

            switch (input){

                case 1:
                    System.out.print("좌석구분 S(1), A(2), B(3)>>");
                    line = scanner.nextInt();
                    if(!Reservation.print_cur_line(line))
                        break;

                    System.out.print("이름 >>");
                    name = scanner.next();

                    System.out.print("번호 >>");
                    num = scanner.nextInt();

                    Reservation.reserve(name,line,num);
                    break;

                case 2:
                    Reservation.search();
                    break;

                case 3:
                    System.out.print("좌석 S:1, A:2, B:3 >>");
                    line = scanner.nextInt();
                    if(!Reservation.print_cur_line(line))
                        break;

                    System.out.print("이름 >>");
                    name = scanner.next();

                    Reservation.cancel(name,line);
                    break;

                case 4:
                    return;

                default:
                    System.out.println("없는 메뉴를 선택하였습니다.");
                    break;
            }
        }
    }
}
