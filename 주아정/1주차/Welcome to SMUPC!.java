import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Welcome to SMUPC!
// https://www.acmicpc.net/problem/29699

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "WelcomeToSMUPC"; // 14
        int N = Integer.parseInt(br.readLine());

        int index = (N - 1) % str.length();

        System.out.println(str.charAt(index));
    }
}
