import java.util.Scanner;

public class BOJ_11726 {
    static int[] DP ;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        DP = new int[num+1];
        System.out.println(top_down(num));
    }

    public static int top_down ( int num){
        if(num==0) return 0;
        if(num==1) return 1;
        if(num==2) return 2;

        if(DP[num]>0) return DP[num];

        DP[num]= top_down(num-1) + top_down(num-2);

        return DP[num];
    }
}
