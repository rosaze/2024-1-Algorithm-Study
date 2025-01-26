import java.util.Arrays;
import java.util.Scanner;
public class sort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] names = input.split("\n");
        StringBuilder result = new StringBuilder();

        // 문자 교체 수행
        for (int j = 0; j < names.length; j++) {
            String modifiedName = names[j].trim()
                    .replace('i', 'e')
                    .replace('e', 'i')
                    .replace('I', 'E')
                    .replace('E', 'I');
            result.append(modifiedName);
            if (j< names.length -1 ){
                result.append("\n");
            }
        }

        System.out.print(result.toString());
        sc.close(); // Scanner 닫기
    }
}