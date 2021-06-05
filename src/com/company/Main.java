package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        ArrayList<UnDirectedGraph> graphs = new ArrayList<UnDirectedGraph>();
        ArrayList<FireCase> fireCases = new ArrayList<FireCase>();
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
            boolean newCase =  true;
            int i = 0;
            while (true){
                String line = bufferedReader.readLine();
                if(line == null) {
                    break;
                }
                if(newCase){
                    if(line.trim().length()>1){
                        System.out.println("Input file formet is incorrect");
                        fireCases.clear();
                        break;
                    }
                    int fire = Integer.valueOf(line.trim());
                    fireCases.add(new FireCase(fire));
                    newCase = false;
                    continue;
                }
                String []corners = line.trim().split(" ");
                if(corners.length !=2){
                    System.out.println("Input file formet is incorrect");
                    fireCases.clear();
                    break;
                }
                int corner1 = Integer.valueOf(String.valueOf(corners[0].charAt(0)));
                int corner2 = Integer.valueOf(String.valueOf(corners[1].charAt(0)));
                if(corner1 == 0 && corner2 == 0){
                    newCase = true;
                    i++;
                    continue;
                }
                fireCases.get(i).addPath(corner1,corner2);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file wasn't found");
        }catch (IOException e){
            e.printStackTrace();
        }
        for (int i = 0;i<fireCases.size();i++){
            System.out.println("Case"+ (i+1));
            fireCases.get(i).printPaths();
            System.out.println("-----------------------------");
        }
    }
}
