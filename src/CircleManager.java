import java.util.Scanner;

class Circle {
    private double x, y;
    private int radius;

    //Circle 생성자
    public Circle(double x, double y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    //Circle 정보 출력 함수
    public void show() {
        System.out.println("("+x+","+y+")"+radius);
    }

    //Circle 면적 계산 함수
    public double calc_area(){
        return radius*radius*3.14;
    }
}


//CircleManager
public class CircleManager {

    public static void main (String[] args){
        double x, y;
        int radius;

        int index=-1;
        double largest=-1;
        double area;

        Scanner scanner = new Scanner(System.in);
        Circle[] c = new Circle[3];

        //x, y, radius 입력 및 Circle 객체 생성
        for(int i=0; i<c.length;i++){
            System.out.print("x, y, radius >>");
            x = scanner.nextDouble();
            y = scanner.nextDouble();
            radius = scanner.nextInt();
            c[i] = new Circle(x,y,radius);
        }


        //면적을 계산해 가장 큰 면적을 가지는 index 저장
        for(int i =0; i<c.length;i++){
            area = c[i].calc_area();
            if(area>=largest) {
                largest = area;
                index = i;
            }
        }


        //가장 면적이 큰 원 출력
        System.out.print("가장 면적이 큰 원은 ");
        c[index].show();

        scanner.close();
    }

}