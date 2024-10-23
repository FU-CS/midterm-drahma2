/*
 * This source file was generated by the Gradle 'init' task
 */
package midterm;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {


    private Node root;

    public CompleteBinaryTree() {
        this.root = null;

        
    }

    public CompleteBinaryTree(int data) {
        this.root = new Node(data);
    }

    public Node getRoot() {
        return root;
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }

        Node temp = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);

        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.left == null) {
                temp.left = new Node(data);
                break;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node(data);
                break;
            } else {
                queue.add(temp.right);
            }
        }
    }
    
    public void delete(int data) {
        if (root == null) {
            return;
        }

        Node temp = root;
        Node keyNode = null;
        Node lastNode = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);

        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.data == data) 
                keyNode = temp;

            if (temp.left != null) 
                queue.add(temp.left);

            if (temp.right != null) 
                queue.add(temp.right);

            lastNode = temp;
        }

        if (keyNode == null)
            return;

        keyNode.data = lastNode.data;
        deleteLastNode(lastNode);
    }

    private void deleteLastNode(Node lastNode) {
        Node temp = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);

        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.left == lastNode) {
                temp.left = null;
                break;
            } else if (temp.left != null)
                queue.add(temp.left);

            if (temp.right == lastNode) {
                temp.right = null;
                break;
            } else if (temp.right != null)
                queue.add(temp.right);
        }
    }


    public String toString() {
        return toString(root);
    }

    private String toString(Node root) {
        String str = "";
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            str += temp.data + " ";

            if (temp.left != null) 
                queue.add(temp.left);

            if (temp.right != null) 
                queue.add(temp.right);
        }
        return str;
    }

    public Boolean question1(){
        
        Queue<Node> queue = new LinkedList<>();
        Node data = root;
        

        if (this.root == null){
            return false;
        }
        while (!queue.isEmpty()){
            data.temp = new Node(data);
            if (this.data <= data.left && this.data <= data.right){
                return false;
            }
        }
        return true;
    }

    public CompleteBinaryTree question2(){
        //create the duplicate
        //iterate through the new cloned tree and find the root.
        // the cloned tree can be changed, so figure out how to make a second tree.
        // figure out how to change one tree without changing the original tree
        // 

        CompleteBinaryTree tree = new CompleteBinaryTree();
        CompleteBinaryTree cloned = CompleteBinaryTree(tree);
        if (cloned == tree){
            return cloned;
        }
        else{
            // find out if the root has changed, if it has, return the root.
            return this.cloned[0];
        }
        
        
    }

    public static void main(String[] args) {
        CompleteBinaryTree tree = new CompleteBinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        System.out.println(tree.toString());
    }
}
