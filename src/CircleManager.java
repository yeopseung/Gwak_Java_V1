import java.util.Scanner;

class Circle {
    private double x, y;
    private int radius;

    public Circle(double x, double y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void show() {
        System.out.println("("+x+","+y+")"+radius);
    }

    public double calc_area(){
        return radius*radius*3.14;
    }
}


public class CircleManager {

    public static void main (String[] args){
        double x, y;
        int radius;

        int index=-1;
        double largest=-1;
        double area;

        Scanner scanner = new Scanner(System.in);
        Circle[] c = new Circle[3];

        for(int i=0; i<c.length;i++){
            System.out.print("x, y, radius >>");
            x = scanner.nextDouble();
            y = scanner.nextDouble();
            radius = scanner.nextInt();
            c[i] = new Circle(x,y,radius);
        }

        for(int i =0; i<c.length;i++){
            area = c[i].calc_area();
            if(area>=largest) {
                largest = area;
                index = i;
            }
        }

        System.out.print("가장 면적이 큰 원은 ");
        c[index].show();

        scanner.close();
    }

}