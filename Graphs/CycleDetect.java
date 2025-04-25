import java.util.ArrayList;
import java.util.List;

class CycleDetect {
    public static List<Integer>[] buildgraph( int n, int[][] edges){
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[n+1];
        for ( int i = 0 ; i < graph.length;i++)graph[i] = new ArrayList<>();

        //undirected graph
        for ( int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        return graph;
    }
    //flag true meaning cycle hai else nhi hai 
    public static Boolean dfs ( List<Integer>[] graph,int currnode, int parent, Integer[] Visited){
        // graph mai traversal start karenge fir 
        // then you go to every node and waha dfs lagao
        //if you visit an already visited node then flag = true 
        // jaise hi flag true nikla program terminates

        Visited[currnode] = 1;
        for ( int i = 0 ; i< graph[currnode].size();i++){
            int nextnode = graph[currnode].get(i);
            if ( nextnode == parent) continue;
            if ( Visited[nextnode] == 1){
                return true;
            }
            dfs(graph, nextnode, currnode, Visited);
        }
        return false;
    }
    public static void main (String args[]){
        int n = 7;
        int[][] edges = {{1,2},{2,5},{5,7},{7,6},{6,3},{3,1},{3,4}};

        List<Integer>[] graph = buildgraph(n, edges);
        Integer[] visited = new Integer[n+1];
        for ( int i = 0 ; i < visited.length; i++)visited[i] = 0;
        

        System.out.println(dfs(graph,1,-1,visited));

    }
}
