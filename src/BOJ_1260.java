import java.util.*;

public class BOJ_1260 {

    static LinkedList<Integer>[] adjList; //adjacency list
    static boolean visited[]; // checking visit node
    static int N ; // node
    static int M ; // edge
    static int V ; // start node
    public static void main(String[] args) {

        //input constant
        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();
        M= sc.nextInt();
        V= sc.nextInt();

        //initialize
        adjList=new LinkedList[N+1];
        for(int i=1; i<=N; i++){
            adjList[i] = new LinkedList<Integer>();
        }
        visited = new boolean[N+1];
        int v1, v2;

        //input graph
        for(int i=1; i<=M; i++){
            v1 = sc.nextInt();
            v2 = sc.nextInt();
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        for(int i=1; i<=N; i++){ //nodes may not be given in order, it can affect path
            Collections.sort(adjList[i]);
        }

        //print dfs result (there are two functions depending on the implementation method)
        dfs(V);
//        dfs_stack(V);

        //initialize visited
        visited = new boolean[N+1];
        //print bfs result
        bfs(V);

    }
    public static void bfs(int start){
        //queue
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start]=true;

        while(!queue.isEmpty()){        //check queue is empty

            int v = queue.poll();
            System.out.print(v+" ");

            //check adjacency list
            Iterator<Integer> iter = adjList[v].listIterator();
            while(iter.hasNext()){ // list item
                int w = iter.next();
                if(!visited[w]){ //not visited
                    queue.add(w);
                    visited[w]=true;
                }
            }

        }
    }

    public static void dfs(int start){
        visited[start]=true;
        int v = start;
        System.out.print(v+" ");


        Iterator<Integer> iter = adjList[v].listIterator();
        while(iter.hasNext()){
            int w = iter.next();
            if(!visited[w]){
                visited[w]=true;
                dfs(w);
            }
        }


    }

    public static void dfs_stack(int start){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start]=true;
        boolean flag ; // this will tell you that there are no more node which is composite path
        System.out.print(start+" ");

        while (!stack.empty()){
            int v = stack.peek();
            Iterator<Integer> iter = adjList[v].listIterator();
            flag = false;

            while (iter.hasNext()){
                int w = iter.next();
                if(!visited[w]){
                    stack.push(w);
                    System.out.print(w+" ");
                    visited[w]=true;
                    flag=true;
                    break;
                }
            }
            if(!flag)   stack.pop();
        }
    }


}
