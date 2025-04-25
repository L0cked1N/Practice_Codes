import java.util.List;
import java.util.ArrayList;
//process that we will do to check if a graph is a valid tree
//-> traverse from root and then check if it does not have a cycle.
// no cycle and no back edge basically but that will make a cycle itself. 
//validate a graph tree 
// traverse all if the traversal count reaches the number of nodes then treu
// find cycles if cycles found then it is false
// cycles find karke ussi mai counter dal dena
//IMPORTANT : all in 1 indexed array 
public class GraphValidTree {
    @SuppressWarnings("unchecked")
    public static List<Integer>[] buildgraph(int n , int[][] edges){
        List<Integer>[] graph = new ArrayList[n+1];
        
        for ( int i = 0 ; i < graph.length; i++) graph[i] = new ArrayList<>();
        
        //undirected graph
        for ( int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        return graph;
    }
    
    // these are all dfs based solutions

    public static boolean dfs(List<Integer>[] graph,int[] visited,int currnode,int parent){
        visited[currnode] = 1;
        for ( int i = 0; i < graph[currnode].size();i++){
            int nextnode = graph[currnode].get(i);
            if ( nextnode == parent) continue;
            if ( visited[nextnode] == 1)return false;
            if(!dfs(graph, visited, nextnode, currnode))return false;
        }
        return true;
    }
    public static void main ( String args[]){
        int n = 5;
        int[][] edges = {{1,2},{1,3},{1,4},{2,5}};
        int[] visit = new int[n+1];
        //for ( int i = 0 ; i < visit.length;i++) visit[i] = 0;
        List<Integer>[] graph = buildgraph(n, edges);
        System.out.println(dfs(graph, visit, 1, -1));
        for ( int i = 1; i < visit.length;i++){
            if ( visit[i] == 0 ) {
                System.out.println("false");
                break;
            }
        }
    }   
}
