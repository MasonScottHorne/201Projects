import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class GraphMatrix implements Graph{
    int[][] matrix;
    int countN;
    int countE;
    boolean[] visited;

    @Override
    //initialization of variables
    public void init(int n) {
        matrix = new int[n+1][n+1];
        countN = n;
        countE = 0;
        visited = new boolean[n];
    }

    @Override
    public int nodeCount() {
        return countN;
    }

    @Override
    //returning the edge count
    public int edgeCount() {
        return countE;
    }

    @Override
    //
    public void addEdge(int v, int w, int wgt) {
        if(matrix[v][w]==0){
            countE++;
        }
        matrix[v][w]=wgt;
    }

    @Override
    //getting the matrix weight
    public int getWeight(int v, int w) {
        return matrix[v][w];
    }

    @Override
    //setting weight and incrementing the edge count if it is 0 and if not assigning it to weight
    public void setWeight(int v, int w, int wgt) {
        if(matrix[v][w]==0){
            countE++;
        }
        matrix[v][w]=wgt;
    }

    @Override
    //decrementing edge count and setting the matrix to 0 if it does not follow if condition
    public void removeEdge(int v, int w) {
        if(matrix[v][w]!=0){
            countE--;
        }
        matrix[v][w]=0;
    }

    @Override
    //if it doesn't equal 0 return true and not return false
    public boolean hasEdge(int v, int w) {
        if(matrix[v][w]!=0){
            return true;
        }
        return false;
    }

    @Override
    //creating new ArrayList of integers
    public ArrayList<Integer> neighbors(int v) {
        ArrayList<Integer> neighborsAL = new ArrayList<Integer>();
        for (int i = 0; i <= countN; i++) {
            if (hasEdge(v, i)) {
                neighborsAL.add(i);
            }
        }
        return neighborsAL;
    }
    //iterate through count and set visited as false
    @Override
    public void resetVisited() {
        for(int i = 0; i<=countN;i++){
            visited[i]=false;
        }
    }

    @Override
    //Breadth First Traversal
    //Initializing a queue and an ArrayList and adding v to it and while queue is not empty poll first element and mark as visited and add
    //then return the ALIntegers
    public ArrayList<Integer> BFS(int v) {
        resetVisited();

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(v);

        ArrayList<Integer> ALIntegers = new ArrayList<Integer>();
        ALIntegers.add(v);

        while(queue.size()!=0){
            Integer current = queue.poll();
            //deepCopy
            ArrayList<Integer> neighAL = neighbors(current);
            for(int i =0; i<neighAL.size();i++){
                int neighbor = neighAL.get(i);
                if(!visited[neighbor]){
                    visited[neighbor]= true;
                    queue.add(neighbor);
                    ALIntegers.add(neighbor);
                }
            }
        }

        return ALIntegers;
    }
    //if it is reachable it has a path boolean logic
    @Override
    public boolean hasPath(int v, int w) {
        ArrayList<Integer> reachable = BFS(v);
        if(reachable.contains(w)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public ArrayList<Integer> topologicalSort() {
        ArrayList<Integer> topologicalSort = new ArrayList<>();
        LinkedList<Integer> queueSort = new LinkedList<>();
        int[] newCopyArray = new int[countN];
        //iterating to find the path
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(matrix[j][i]!=0) {
                    newCopyArray[i]++;
                }
                }
            }
        //find all vertexes
        for(int i = 0; i<newCopyArray.length;i++){
            if(newCopyArray[i] == 0){
                queueSort.add(i);
                visited[i] = true;
            }
        }
        int runner= 0;
        //
        while(!queueSort.isEmpty()){
            runner = queueSort.get(0);
            topologicalSort().add(queueSort.remove());
            for(int i = 0; i<matrix.length;i++){
                if(matrix[runner][i] != 0 && visited[i] == false){
                    queueSort.add(i);
                    visited[i] = true;
                }
            }
        }
        return topologicalSort;
    }
}