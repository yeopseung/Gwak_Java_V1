import java.util.Scanner;

class Dictionary{
    private static String[] kor = {"사랑", "아기", "돈", "미래", "희망"};
    private static String[] eng = {"love", "baby", "money", "future", "hope"};

    public static String kor2Eng(String word){
        //word 와 같은 단어가 kor[i] 에 있을 경우 eng[i] 리턴
        for(int i=0; i<kor.length; i++){
            if(word.equals(kor[i]))
                return eng[i];
        }
        return null;
    }
}

public class DicApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word;
        String result;

        System.out.println("한영 단어 검색 프로그램입니다.");
        while(true){

            //검색할 단어 입력
            System.out.print("한글 단어?");
            word = scanner.next();

            //종료
            if(word.equals("그만"))
                break;


            result = Dictionary.kor2Eng(word);

            //검색결과 출력
            if(result !=null)
                System.out.println(word+"은 "+result);
            else
                System.out.println(word+"는 저의 사전에 없습니다");
        }

    }
}
