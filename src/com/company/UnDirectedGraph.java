package com.company;

public class UnDirectedGraph extends  Graph{
    public UnDirectedGraph(int v){
        super(v);
    }

    @Override
    public void addEdge(int u, int v) {
        super.addEdge(u, v);
        super.addEdge(v,u);
    }
}
