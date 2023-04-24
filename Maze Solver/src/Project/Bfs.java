/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
/**
 *
 * @author DELL
 */
public class Bfs {
    // Below arrays detail all four possible movements from a cell
    private static int[] row = { -1, 0, 0, 1 };
    private static int[] col = { 0, -1, 1, 0 };
 
    // The function returns false if (x, y) is not a valid position
    private static boolean isValid(int x, int y, int m, int n) {
        return (x >= 0 && x < m) && (y >= 0 && y < n);
    }
    public static void findPath(Node node, List<Integer> path){ 
        if(node != null){
            findPath(node.parent, path);
            path.add(node.x);
            path.add(node.y);
        }
    }
    public static boolean searchPath(int[][] maze, int x, int y, List<Integer> path){
       Queue<Node> q = new ArrayDeque<>();
        Node src = new Node(x, y, null);
        q.add(src);
        
        while (!q.isEmpty())
        {
            // dequeue front node and process it
            Node curr = q.poll();
            int i = curr.x, j = curr.y;
 
            // return if the destination is found
            if(maze[i][j] == 9) {
                findPath(curr, path);
                return true;
            }
            maze[i][j] = 2;
            // check all four possible movements from the current cell
            // and recur for each valid movement
            for (int d = 0; d < 4; d++)
            {
                // get next position coordinates using the value of the current cell
                x = i + row[d];
                y = j + col[d];
 
                // check if it is possible to go to the next position
                // from the current position
                if (isValid(x, y, maze.length, maze[0].length)){
                    // construct the next cell node
                    Node next = new Node(x, y, curr);
 
                        // enqueue it and mark it as visited
                       if(maze[next.x][next.y] == 0 || maze[next.x][next.y] == 9){
                           q.add(next);
                       }
                }
            }
        }
        return false;
    }
}
