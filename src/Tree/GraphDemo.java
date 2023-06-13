package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Graph{
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<> ();
    Graph(int v) {
        for (int i=0;i<v; i++) {
            adjList.add(new ArrayList<Integer>());
        }
    }
    public void addEdge (int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
    public void printAdjList() {
        for (int i=0; i<adjList.size(); i++){ // i vertex no
            System.out.println("Adj list of vertex " + i);
            for (int j = 0; j<adjList.get(i).size(); j++){
                System.out.println(" I "+ adjList.get(i).get(j));
            }
        }
    }
    public void bfs (int v) {
        int V = adjList.size();
        boolean[] visited=new boolean[V];
        visited[v]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(v);
        while (q.size()!=0){
            int vertex=q.remove();
            System.out.print(vertex+" ");
            for (int i=0;i<adjList.get(vertex).size();i++){
                int av=adjList.get(vertex).get(i);
                if(!visited[av]){
                    q.add(av);
                    visited[av]=true;
                }
            }
        }
    }
    public void dfs(int val){
        int V = adjList.size();
        boolean[] visited=new boolean[V];
        dfs(val,visited);
    }
    public void dfs(int v,boolean[] visited){
        visited[v]=true;
        System.out.print(v+" ");
        for (int i=0;i<adjList.get(v).size();i++){
            int av=adjList.get(v).get(i);
            if(!visited[av]){
                dfs(av,visited);
            }
        }
    }
}
public class GraphDemo {
    public static void main(String[] args) {
        Graph g = new Graph ( 5); //no of vertices is 5
        g.addEdge (0, 1);
        g.addEdge (2,  3);
        g.addEdge (1,  2);
        g.addEdge (3,  4);
        g.addEdge (0,  4);
        g.addEdge (1,  4);
        g.printAdjList();
        System.out.println();
        g.bfs (0);
        System.out.println();
        g.dfs(0);
    }
}
