// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.util.HashMap;
import java.io.*;

    class Node
    {
        int data;
        Node left,right;
        Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
    }
		
public class GFG2
{
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void inorder(Node root)
	{
	    if(root==null)
	    return;
	    inorder(root.left);
	    System.out.print(root.data);
	    inorder(root.right);
	}
     /* Drier program to test above functions */
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    GFG g = new GFG();
			
			    ArrayList<Integer> res = g.zigZagTraversal(root) ;
			    for (int i = 0; i < res.size (); i++)
			        System.out.print (res.get (i) + " ");
			    System. out. println();  
    			
                t--;
            
        }
	}
}// } Driver Code Ends


//User function Template for Java

/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    
	    if(root == null)
	        return null;
	        
	    ArrayList<Integer> outer = new ArrayList<Integer>();   
	    
	    // Using two stacks to solve this question
	    
	    Stack<Node> currentLevel = new Stack<>();
	    Stack<Node> nextLevel = new Stack<>();
	    
	    // keeping tracks of level to move from Left to right or vice verse
	    boolean leftToRight = true;
	    
	    currentLevel.push(root);
	    
	    while( !currentLevel.isEmpty() ){
	        
	        Node child = currentLevel.pop();
	        outer.add(child.data);
	        
	        if(leftToRight){
	            
	            if(child.left != null)
	                nextLevel.push(child.left);
	                
	            if(child.right != null)
	                nextLevel.push(child.right);     
	            
	        } else {
	            
	            if(child.right != null)
	                nextLevel.push(child.right); 
	            
	            if(child.left != null)
	                nextLevel.push(child.left);
	            
	        }
	        
	        
	        // swapping both the stacks and changing the levels
	        if(currentLevel.isEmpty()){
	            
	            leftToRight = !leftToRight;
	            Stack temp = currentLevel;
	            currentLevel = nextLevel;
	            nextLevel = temp;
	            
	        }
	        
	        
	    }
	    
	    return outer;
	    
	}
}