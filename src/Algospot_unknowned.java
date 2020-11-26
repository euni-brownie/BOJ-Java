import java.util.Collections;
import java.util.Scanner;
public class Algospot_unknowned {

    static int[] number;
    static int[] dp;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //input testCase
        int testCase = input.nextInt();
        input.nextLine();
        if(testCase<1 || testCase>100000 ) return;
        number = new int[testCase];
        dp = new int[testCase];
        for(int i=0; i<testCase; i++){
            number[i]=input.nextInt();
            if(number[i]<-1000 || number[i]>1000) return;
        }
            System.out.println( bottomUp(testCase));

    }

    static int bottomUp(int num){
        dp[0]=number[0];
        int max = dp[0];
        for(int i=1; i<num; i++){
            if(dp[i-1]+number[i]>number[i]) dp[i]=dp[i-1]+number[i];
            else dp[i]=number[i];
        }
        for(int i=0; i<num; i++){
            if(dp[i]>max) max=dp[i];
        }

        return max;
    }

}
