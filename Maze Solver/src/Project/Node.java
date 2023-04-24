/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

/**
 *
 * @author DELL
 */
public class Node {
    int x,y;
    
    Node parent;
    
    Node(int x, int y, Node parent){
        this.x = x;
        this.y = y;
        this.parent = parent;
    }
}
