import java.util.Scanner;

public class Algospot_Picnic {

    static boolean[][] areFriend = new boolean[10][10];

    //TODO : 재귀함수 구현
    static  int countPair(boolean[] taken, int peopleNum) {
        int firstpeople = -1;
        for(int i=0; i<taken.length; i++){
            if(!taken[i]){
                firstpeople=i;
                break;
            }
        }

        if(firstpeople==-1) return 1;
        int result = 0;

        for(int pairWith = firstpeople+1; pairWith<peopleNum; pairWith++){
            if(areFriend[firstpeople][pairWith]&& !taken[pairWith]){
                taken[pairWith]=true;
                taken[firstpeople]=true;
                result += countPair(taken, peopleNum);
                taken[pairWith]=false;
                taken[firstpeople]=false;
            }
        }


        return result;
    }


    public static void main(String[] args) {



        //입력 받기
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        if(testCase>50)
            System.exit(999);
        sc.nextLine();
        int peopleNum =0;
        int friendNum = 0;
        String tempLine ="";
        String fndInfoLine ="";
        int friend1;
        int friend2;
        for(int i=0; i<testCase; i++){

            tempLine = sc.nextLine();
            peopleNum = Integer.parseInt(tempLine.substring(0,1));
            friendNum = Integer.parseInt(tempLine.substring(2,3));

            if(peopleNum<2 || peopleNum >10)
                System.exit(999);

            if(friendNum<0 ||friendNum> (peopleNum*peopleNum-1)/2)
                System.exit(999);

            fndInfoLine =sc.nextLine();
            fndInfoLine =fndInfoLine.replaceAll("\\p{Z}","");

            //다음으로 짝 2명씩 받아와서 areFriend 2차원배열 초기화 하기
            for ( int j=0; j< fndInfoLine.length()/2; j++){
                int n = 2*j;
                if(fndInfoLine.substring(n,n+1).equals("0"))
                    friend1=0;
                else
                    friend1=Integer.parseInt(fndInfoLine.substring(n,n+1));

                if(fndInfoLine.substring(n+1,n+2).equals("0"))
                    friend2=0;
                else
                    friend2 =Integer.parseInt(fndInfoLine.substring(n+1,n+2));

               areFriend[friend1][friend2]=true;
               areFriend[friend2][friend1]=true;
            }

            //taken 초기화
            boolean[] taken = new boolean[peopleNum];
            for(int j=0; j<peopleNum; j++){
                taken[j] = false;
            }


            //TODO : 알고리즘 식 적용해서 예제 출력
            System.out.println(countPair(taken, peopleNum));

            //areFriend 초기화
            for(int j=0; j<10; j++){
                for(int k=0; k<10 ; k++){
                    areFriend[j][k]=false;
                }
            }


        }





    }
}
