import java.util.Scanner;

public class BOJ_1924 {

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
            int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            int x, y, today;
            today = 0;
            x = sc.nextInt();
            y = sc.nextInt();
            //calculate month
            for(int i=0; i<x-1; i++){
                today += month[i];
            }
            today += y; //calculate day
            System.out.println(days[today%7]);

        }
}
