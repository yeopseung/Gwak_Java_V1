import java.util.Scanner;

class Phone{
    String name;
    String tel;

    public Phone(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public void show(){
        System.out.println(name+"의 번호는 "+tel+" 입니다");
    }
}

public class PhoneBook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String tel;
        String target;
        boolean isEqual;
        int num;

        System.out.print("인원수 >>");
        num = scanner.nextInt();
        Phone[] phone = new Phone[num];

        for(int i=0 ; i<num;i++){
            System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력) >>");
            name = scanner.next();
            tel = scanner.next();
            phone[i] = new Phone(name,tel);
        }
        System.out.println("저장되었습니다...");

        while(true){
            isEqual = false;
            System.out.print("검색할 이름 >>");
            target = scanner.next();

            if(target.equals("그만"))
                break;

            for(int i=0; i<phone.length;i++){
                if(phone[i].name.equals(target)) {
                    phone[i].show();
                    isEqual = true;
                    break;
                }
            }

            if(!isEqual)
                System.out.println(target+"이 없습니다");
        }
    }
}
