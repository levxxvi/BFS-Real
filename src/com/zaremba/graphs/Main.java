package com.zaremba.graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Node> graph;
    public static void main(String[] args) throws FileNotFoundException {
        setupTree();
        System.out.println(graph);
        BFS();
    }

    private static void BFS() {
        //Your code here.  Feel free to modify signature or add helper functions.
        /*
        for loop: for i < array.size
            start with node 1 (getKey(i))
            for loop: for i < # of points in node (getNodes())
                if loop (check if point is visited - isVisited(getNodes(i)) = false (?) )
                    add node to queue
            setVisited(true) (set node 1 as visited)
         */
        ArrayList<Integer> queue = new ArrayList<>();
        //for loop needs to check nodes according to the queue
        for(int i = 0; i < graph.size(); i++){
            int keyIndex = graph.get(i).getKey();
            System.out.println("keyIndex " + keyIndex);

            ArrayList<Integer> connectedNodes = (ArrayList<Integer>) graph.get(i).getNodes();
            System.out.println("connectedNodes " + connectedNodes);

            for(int j = 0; j < connectedNodes.size(); j++){
                int checkNode = connectedNodes.get(j);
                System.out.println("checkNode " + checkNode);

                if (!queue.contains(checkNode)){
                    queue.add(checkNode);
                }
            }
            
            System.out.println("queue " + queue);
            System.out.println("\n");
            //keyIndex = setVisited(true) (?)
        }
    }

    private static void setupTree() throws FileNotFoundException {
        graph = new ArrayList<>();
        Scanner scan = new Scanner(new File("tree.txt"));
        while(scan.hasNext()){
            String line = scan.nextLine();
            parseLine(line);
        }
    }

    private static void parseLine(String line) {
        String[] keys = line.split(" ");
        int key = Integer.parseInt(keys[0]);
        ArrayList<Integer> points = new ArrayList<>();
        for(int i = 1; i < keys.length;i++){
            points.add(Integer.parseInt(keys[i]));
        }
        graph.add(new Node(key, points));
    }
}
