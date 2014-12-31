package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import LeetCode.Node;

public class NodeTest {

  @Test
  public void nodeGraphSizeTest() {
    Node start, one, two, three, four, five;
    start = new Node();
    one = new Node();
    two = new Node();
    three = new Node();
    four = new Node();
    five = new Node();
    
    start.neighbors.add(one);
    start.neighbors.add(two);
    start.neighbors.add(three);
    two.neighbors.add(start);
    two.neighbors.add(three);
    two.neighbors.add(two);
    three.neighbors.add(four);
    three.neighbors.add(five);
    
    assertEquals(6, start.graphSize());
  }
  
  @Test
  public void nodeCloneTest() {
    Node start, one, two, three, four, five;
    start = new Node();
    one = new Node();
    two = new Node();
    three = new Node();
    four = new Node();
    five = new Node();
    
    start.neighbors.add(one);
    start.neighbors.add(two);
    start.neighbors.add(three);
    two.neighbors.add(start);
    two.neighbors.add(three);
    two.neighbors.add(two);
    three.neighbors.add(four);
    three.neighbors.add(five);
    
    Node copy = start.clone();

    assertEquals(start.neighbors.size(), copy.neighbors.size());
    assertEquals(start.graphSize(), copy.graphSize());
    //Due to a lack of distinguishing information about the graphs (IE labels), it is hard to test further.
  }
}
