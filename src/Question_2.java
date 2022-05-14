import java.util.Scanner;

public class Question_2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("수학, 과학, 영어 순으로 3개의 정수 입력 >> ");
        int math = scanner.nextInt();
        int science = scanner.nextInt();
        int english = scanner.nextInt();
        Grade me = new Grade(math, science, english);
        System.out.println("평균은 "+me.average()); // average()는 평균을 계산하여 리턴

        scanner.close();
    }
}

class Grade{
    int math;
    int science;
    int english;

    //Grade 생성자
    public Grade(int math, int science, int english) {
        this.math = math;
        this.science = science;
        this.english = english;
    }

    //평균값을 구하는 함수
    public int average(){
        return (math+science+english)/3;
    }
}


