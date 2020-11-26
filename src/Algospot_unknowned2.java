import java.util.ArrayList;
import java.util.Scanner;


public class Algospot_unknowned2 {

    public static String[][] board= {
            {"U", "R", "L", "P", "M"},
            {"X", "P", "R", "E", "T"},
            {"G", "I", "A", "E", "T"},
            {"X", "T", "N", "Z", "Y"},
            {"X", "O", "Q", "R", "S"}
    };
    public static int currentX = 0;
    public static int currentY = 0;


    public static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static boolean flag = false;

    public static boolean hasWord(int x, int y, String word, String[][] board){
        if (x<0 || x>4 || y<0 || y>4) return false;
        if(!word.substring(0,1).equals(board[x][y])) return false;
        else{
            if(word.length()==1) {
                flag= true;
                return true;
            }
            for(int i=0; i<8; i++){
                    hasWord(x+dx[i], y+dy[i], word.substring(1), board);

            }


        }

        return false;
    }

    public static void findXY(String target, String[][] board){

        boolean findFlag = false;
        flag=false;

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(board[i][j].equals(target.substring(0,1))){
                        currentX = i;
                        currentY = j;
                        hasWord(currentX, currentY, target, board);
                        findFlag=true;
                }
            }
        }
            if(findFlag && flag) System.out.println(target+" YES");
            else System.out.println(target+"NO");

    }




    public static ArrayList<Integer> recursivePickNum (int num, ArrayList<Integer> list, int restNum){
        if(restNum==0){
            System.out.print("[");
            //print list
            for(int i=0; i< list.size(); i++){
                if(i==list.size()-1){
                    System.out.print(list.get(i)+"]");
                    System.out.println();
                }else{
                    System.out.print(list.get(i)+",");
                }
            }
            return list;
        }else{
            int smallistNum;
            if(list.isEmpty()) smallistNum=1;
            else smallistNum=list.get(list.size()-1)+1;
            for(int next=smallistNum; next <= num; next++){
                list.add(next);
                restNum=restNum-1;
                recursivePickNum(num, list, restNum);
                restNum++;
                list.remove(list.size()-1);
            }

            return null;

        }

    }

    public static void main(String[] args) {

        String testBoard[][] = new String[5][5];

        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();
        int wordCount;
        int x=0;
        int y=0;
        String line;


        if(testCase>50) return ;
        else{

            for(int i=0; i<testCase; i++){
                for(int j=0; j<5; j++){
                    line = sc.next();
                    testBoard[j][0]=line.substring(0,1);
                    testBoard[j][1]=line.substring(1,2);
                    testBoard[j][2]=line.substring(2,3);
                    testBoard[j][3]=line.substring(3,4);
                    testBoard[j][4]=line.substring(4);
                }
                wordCount =sc.nextInt();
                if(wordCount<1 || wordCount>10) return;
                else{
                   for(int j=0; j<wordCount; j++){
                       String target = sc.next();
                       if(target.length()<1 || target.length()>10) return;
                       else{
                           findXY(target, testBoard);

                       }

                   }




                }





            }
        }





    }
}
