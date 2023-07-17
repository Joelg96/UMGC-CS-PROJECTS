/*
 * Joel Goode CMSC 350 11/28/22
 * Whether the binary tree is balanced
 * Whether the binary tree is full
 * height
 * inorder traversal of the above tree
 */

import java.util.EmptyStackException;
import java.util.Stack;

public class BinaryTree {

    Node parentNode, childNode; 

    // Constructor - Takes the string and turns it into an array based on parenthesis.
    public BinaryTree(String input) throws InvalidTreeSyntax {
        Stack<Node> nodeStack = new Stack<>();
        String[] inputArray = input.substring(1, input.length()-1)
                //and split the String into a arr of strings, retain the parenthesis.
                .split("(?<=\\()|(?=\\()|(?<=\\))|(?=\\))");
        parentNode = new Node(inputArray[0]); 

        for (int i = 1; i < inputArray.length - 1; i++){
            // Check if child. if not, add.
            if (inputArray[i].equals("(")){ nodeStack.push(parentNode);

                if (childNode != null){ 
                    parentNode = childNode; 
                }

                // Add current parent to stack.
            }else if(inputArray[i].equals(")")){
                try { 
                    childNode = parentNode; parentNode = nodeStack.pop();
                } catch (EmptyStackException emptyStack){ 
                    throw new InvalidTreeSyntax("Error, Incorrect parenthesis!"); 
                }

            }else{ childNode = new Node(inputArray[i]);

                if (parentNode != null) { 
                    parentNode.addChild(childNode); 
                }
            }
        }
        if (this.recurNodes(parentNode) * 3 != input.length()) throw new InvalidTreeSyntax("Error, Incorrect Syntax");
    }

    // Determine if the absolute difference between branches is at most 1.
    public boolean isBalanced() { 
        return recurIsBalanced(this.parentNode); 
    }

    private boolean recurIsBalanced(Node root){
        if (root == null) {
            return true;
        }
        return (Math.abs(recurHeight(root.leftSide) - recurHeight(root.rightSide)) <= 1) &&
                (recurIsBalanced(root.leftSide) && recurIsBalanced(root.rightSide)); 
    }

    // Determine if a tree has the maximum nodes for the height or not.
    public boolean isFull() {
        return recurIsFull(this.parentNode, recurHeight(this.parentNode), 0); 
    }

    private boolean recurIsFull(Node root, int height, int index) {
        if (root == null){ 
            return true; 
        }
        if (root.leftSide == null && root.rightSide == null) {
             return (height == index + 1); 
            }
       
        if (root.leftSide == null || root.rightSide == null){
             return false;
            }
        return recurIsFull(root.leftSide, height, index+1) && recurIsFull(root.rightSide, height, index+1);
    }

    // Determine if every node in a tree has either 2 or 0 children.
    public boolean isProper() {
         return recurIsProper(this.parentNode); 
        }

    private boolean recurIsProper(Node root) {
        if(root == null) {
            return true;
        }
        return ((root.leftSide != null || root.rightSide == null) && (root.leftSide == null || root.rightSide != null))
                && (recurIsProper(root.leftSide) && recurIsProper(root.rightSide)); 
    }

    // Find the height of the binary tree, where the root node is 0.
    public int height() {
        return recurHeight(this.parentNode)-1; 
    }

    private int recurHeight(Node root) {
        return (root == null) ? 0 : 1 + Math.max(recurHeight(root.leftSide), recurHeight(root.rightSide));
    }
 
    // Find the total number of nodes in the binary tree.
    public int nodes() { 
        return recurNodes(this.parentNode); 
    }

    private int recurNodes(Node root) {
        return (root == null) ? 0 : 1 + recurNodes(root.leftSide) + recurNodes(root.rightSide);
    }
   
    // Display the info of the nodes in the binary tree in order.
    public String inOrder() {
        return recurInOrder(this.parentNode);
    }

    private String recurInOrder(Node root) {
        return (root == null) ? "" : "(" + recurInOrder(root.leftSide) + root.info + recurInOrder(root.rightSide) + ")";
    }

    @Override
    public String toString() { 
        return parentNode.toString(); 
    }

    //  Create nodes to be used in tree and methods to act on them.
    public static class Node {
        private String info;
        private Node leftSide;
        private Node rightSide;

        public Node(String info) {
             this.info = info; 
            }

        private void addChild(Node child) throws InvalidTreeSyntax {
            if (this.leftSide == null){ 
                this.setLeft(child); 
            }
            else if (this.rightSide == null){
                 this.setRight(child);
                }
            else{ 
                throw new InvalidTreeSyntax("Error, Nodes can only have 2 children!");
            } 
        }

        // Setters
        private void setLeft(Node newLeftSide) { 
            leftSide = newLeftSide; 
        }

        private void setRight(Node newRightSide) { 
            rightSide = newRightSide; 
        }

        @Override
        public String toString() {
             return toString(this); 
            }

        private static String toString(Node root) {
            return (root == null) ? "" : "(" + root.info + toString(root.leftSide) + toString(root.rightSide) + ")";
        }
    }
}