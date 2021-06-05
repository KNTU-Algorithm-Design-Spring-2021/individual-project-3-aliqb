package com.company;

import com.company.Graph;
import com.company.UnDirectedGraph;

import java.util.ArrayList;

public class FireCase {
    private int fire;
    private UnDirectedGraph cornersGraph;
    public FireCase(int fire){
        this.fire = fire;
        this.cornersGraph = new UnDirectedGraph(21);
    }
    public void addPath(int corner1,int corner2){
        this.cornersGraph.addEdge(corner1,corner2);
    }
    public void printPaths(){
        ArrayList<ArrayList> paths = this.cornersGraph.findPaths(1,fire);
        for(int i=0;i<paths.size();i++){
            ArrayList path = paths.get(i);
            for(int j=0;j<path.size();j++){
                System.out.print(path.get(j)+" ");
            }
            System.out.println("");
            if(i == paths.size()-1){
                System.out.println("There are "+paths.size()+" path from fire station fo fire place");
            }
        }
    }
}
