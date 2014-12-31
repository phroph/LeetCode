package LeetCode;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

public class Node {
  public Vector<Node> neighbors;
  
  public Node() {
    neighbors = new Vector<>();
  }
  
  public Node clone() {
    Queue<Node> boundary = new LinkedList<>();
    Set<Node> visited = new HashSet<>();
    Hashtable<Node,Node> mapping = new Hashtable<>();
    
    boundary.add(this);
    
    while(!boundary.isEmpty()) {
      Node next = boundary.poll();
      Node newNode = new Node();     
      if(mapping.containsKey(next)) {
        newNode = mapping.get(next);
      } else {
        mapping.put(next, newNode);
      }
      
      for(Node cursor : next.neighbors) {
        if(!mapping.containsKey(cursor)) {
          Node cursorClone = new Node();
          mapping.put(cursor, cursorClone);
        }
        newNode.neighbors.addElement(mapping.get(cursor));
        
        if(!visited.contains(cursor)) {
          boundary.add(cursor);
        }
      }
      
      visited.add(next);
    }
    
    return mapping.get(this);
  }
  
  public int graphSize() {
    Queue<Node> boundary = new LinkedList<>();
    Set<Node> visited = new HashSet<>();
    
    boundary.add(this);
    
    while(!boundary.isEmpty()) {
      Node next = boundary.poll();
      
      for(Node cursor : next.neighbors) {
        if(!visited.contains(cursor)) {
          boundary.add(cursor);
        }
      }
      
      visited.add(next);
    }
    
    return visited.size();
  }
}
