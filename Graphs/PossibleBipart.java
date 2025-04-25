import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PossibleBipart {

    @SuppressWarnings("unchecked")
    public static ArrayList<Integer>[] generategraph ( int[][] nodes, int n){
        // n will be the number of nodes
        ArrayList<Integer>[] graph = new ArrayList[n];
        for ( int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>();
        }

        for ( int i = 0; i < nodes.length;i++){
            graph[nodes[i][0]-1].add(nodes[i][1]);
        }

        return graph;
    }
    public static boolean bipartite (ArrayList<Integer>[] graph ){
        //assuming no self edges and all edges are acounnted for once
        Set<Integer> seta = new HashSet<>();
        Set<Integer> setb = new HashSet<>();
        for ( int i = 0 ; i < graph.length; i++){
            if (seta.contains(i+1)){
                for ( int j = 0 ; j < graph[i].size();j++){
                    if (graph[i].get(j) == 0)continue;
                    setb.add(graph[i].get(j));
                    }
            }
            else {
                for ( int j = 0 ; j < graph[i].size();j++){
                    if (graph[i].get(j) == 0)continue;
                    seta.add(graph[i].get(j));
                    setb.add(i+1);
                }
            }
        }
        System.out.println(seta);
        System.out.println(setb);
        for ( int i = 0;i<graph.length;i++){
            if (seta.contains(i+1) && setb.contains(i+1))return false;
        }
        if (seta.size()+setb.size()==graph.length) return true;
        else return true;
    }
    public static void main ( String agrs[]){
        int n = 4;
        int dislikes[][] = {{1,2},{1,3},{2,3}};
        boolean sol = bipartite(generategraph(dislikes, n));
        System.out.println(sol);
    }
}
