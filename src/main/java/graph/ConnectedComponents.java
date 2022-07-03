package graph;

import java.util.*;

public class ConnectedComponents {
    public static int countComponents(int n, int[][] edges) {
        if(n==0){
            return 1;
        }
        // Build graph
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }
        for (int i= 0; i < edges.length; i++){
            int parent = edges[i][0];
            int child = edges[i][1];
            adjList[parent].add(child);
            adjList[child].add(parent);
        }
        int components = 0;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++){
            if(visited[i] == 0){
                components++;
                bfs(i, adjList, visited);
            }
        }
        return components;
    }
    public static void bfs(int root, List<Integer>[] adjList, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited[root] = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 0; i < adjList[node].size(); i++){
                Integer child = adjList[node].get(i);
                if (visited[child] == 0){
                    visited[child] = 1;
                    queue.offer(child);
                }
            }
        }
    }
    public static void main(String[] args) {
        // [[0,1],[1,2],[3,4]]
        int[][] edges = new int[3][2];
        edges[0][0]=0;
        edges[0][1]=1;
        edges[1][0]=1;
        edges[1][1]=2;
        edges[2][0]=3;
        edges[2][1]=4;
        System.out.println(countComponents(5, edges));
    }
}
