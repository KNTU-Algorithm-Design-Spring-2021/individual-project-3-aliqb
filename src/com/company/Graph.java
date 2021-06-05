package com.company;

import java.util.ArrayList;

public class Graph {
    private int v;
    private ArrayList[] adjacentList;
    public Graph(int v){
        this.v = v;
        this.adjacentList = new ArrayList[v];
        for(int i = 0;i<v;i++){
            this.adjacentList[i] = new ArrayList<Integer>();
        }
    }
    public void addEdge(int u,int v){
        this.adjacentList[u].add(v);
    }
    public ArrayList<ArrayList> findPaths(int source,int destination){
        boolean []visited = new boolean[this.v];
        ArrayList<ArrayList> paths = new ArrayList<>();
        ArrayList<Integer> currentPath = new ArrayList<>();
        currentPath.add(source);
        findPathsWithDfs(source,destination,visited,currentPath,paths);
        return paths;
    }
    public void findPathsWithDfs(int source,int destination,boolean []visited,ArrayList currentPath,ArrayList<ArrayList> paths){
        if(source == destination){
            paths.add((ArrayList) currentPath.clone());
            return;
        }
        visited[source] = true;
        for(int i=0 ; i<this.adjacentList[source].size();i++){
            int vertex = (int) this.adjacentList[source].get(i);
            if(!visited[vertex]){
                currentPath.add(vertex);
                findPathsWithDfs(vertex,destination,visited,currentPath,paths);
                currentPath.remove(currentPath.size()-1);
            }
        }
        visited[source] = false;
    }

}
