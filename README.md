# Node
Data structure representing a tree. Based on this.

![image](https://user-images.githubusercontent.com/115718967/231436618-78129591-05c5-42dc-afcd-7297b127446d.png)

Node object has 3 parameters: 

  -int value
  
  -Node left
  
  -Node right
  
  
Node class constructor:

Node node = new Node(int value);


Class consist of methods:

  -find the maximum depth of a tree with a path to its deepest node(<b>findMaxLevel(), printMaxPath()</b>)
    
    #returns maximum depth
    System.out.println(node.findMaxLevel());
    #return path to deepest node
    System.out.println(node.findMaxPath());
  
  -check whether two trees have nodes with the same values (<b>check(nodeToCompare)</b>)
  
    #returns true/false
    System.out.println(node.check(nodeToCompare))
  
  -to find the number of leafs without children. (<b>numberOfLastLeafs()</b>)
  
    #returns number of nodes without children
    System.out.println(node.numberOfLastLeafs())
