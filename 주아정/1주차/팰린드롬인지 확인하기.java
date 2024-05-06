import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ_10988
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        System.out.println(isPalindrome(word, 0, word.length()-1));
    }

    public static int isPalindrome(String word, int start, int end) { // 재귀적으로 구현
        if (start >= end) {
            return 1;
        } else if (word.charAt(start) == word.charAt(end))
            return isPalindrome(word, start+1, end-1);
        else return 0;
    }
}
