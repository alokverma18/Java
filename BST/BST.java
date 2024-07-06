package BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BST {
    class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }

    public Node insert(Node root, int val){
        if(root==null){
            return new Node(val);
        }
        if(val<root.data){
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public void inOrder(Node root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public void inOrder(Node root, ArrayList<Integer> arr){
        if(root==null)
            return;
        inOrder(root.left, arr);
        arr.add(root.data);
        inOrder(root.right, arr);
    }

    public void levelOrder(Node root){
        if(root==null){
            System.out.println();
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if(temp==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(temp.data + " ");
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
        }
    }

    public boolean search(Node root, int val){
        if(root==null){
            return false;
        }
        if(root.data==val){
            return true;
        }
        if(val<root.data){
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    public Node findInorderSuccessor(Node root){
        while (root.left!=null) {
            root = root.left;
        }
        return root;
    }
    public Node delete(Node root, int val){
        if(root==null){
            return null;
        }

        if(val<root.data){
            root.left = delete(root.left, val);
        } else if(val>root.data) {
            root.right = delete(root.right, val);
        }
        else{
            //leaf
            if(root.left==null && root.right==null){
                return null;
            }
            //single child
            if(root.left==null){
                return root.right;
            } else if(root.right==null){
                return root.left;
            }
            //both 
            Node inOrderSuccessorNode = findInorderSuccessor(root.right);
            root.data = inOrderSuccessorNode.data;
            root.right = delete(root.right, inOrderSuccessorNode.data);
        }
        return root;
    }

    public void printInRange(Node root, int n1, int n2){
        if(root==null){
            return;
        }
        if(root.data>=n1 && root.data<=n2){
            printInRange(root.left, n1, n2);
            System.out.print(root.data + " ");
            printInRange(root.right, n1, n2);
        } else if (root.data<n1){
            printInRange(root.right, n1, n2);
        } else {
            printInRange(root.left, n1, n2);
        }
    }

    public void rootToLeaf(Node root, ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            System.out.println(path);
        }
        rootToLeaf(root.left, path);
        rootToLeaf(root.right, path);
        path.remove(path.size()-1);
    }

    public boolean isValidBST(Node root, Node min, Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }
        if(max!=null && root.data>=max.data){
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public Node mirror(Node root){
        if(root==null){
            return root;
        }
        Node left = mirror(root.left);
        Node right = mirror(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public Node balancedBST(ArrayList<Integer> arr, int l, int r){
        if(l>r){
            return null;
        }
        int mid = l+(r-l)/2;
        Node root = new Node(arr.get(mid));
        root.left = balancedBST(arr, l, mid-1);
        root.right = balancedBST(arr, mid+1, r);
        return root;
    }

    public Node balanceBST(Node root){
        ArrayList<Integer> sorted = new ArrayList<>();
        inOrder(root, sorted);
        return balancedBST(sorted, 0, sorted.size()-1);
    }


    // for largest bst in a bt

    public class Info{
        boolean bst;
        int size;
        int min;
        int max;

        Info(boolean bst, int size, int min, int max){
            this.bst = bst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    static int maxSize;
    static Node rootOfLargestBST;

    // check in BinaryTree.java
    public Info largestBST(Node root){
        
        if(root==null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info left = largestBST(root.left);
        Info right = largestBST(root.right);

        int size = left.size+right.size+1;
        int min = Math.min(Math.min(left.min, right.min), root.data);
        int max = Math.max(Math.max(left.max, right.max), root.data);
        
        if(root.data<=left.max || root.data>=right.min){
            return new Info(false, size, min, max);
        }
        if(left.bst && right.bst){
            if(size>maxSize){
                maxSize = size;
                rootOfLargestBST = root;
            }
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }

    public Node mergeBST(Node root1, Node root2){
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        inOrder(root1, arr1);
        inOrder(root2, arr2);
        ArrayList<Integer> f = new ArrayList<>();
        int i=0, j=0;
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)<arr2.get(j)){
                f.add(arr1.get(i));
                i++;
            } else {
                f.add(arr2.get(j));
                j++;
            }
        }
        while(i<arr1.size()){
            f.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()){
            f.add(arr2.get(j));
            j++;
        }

        return balancedBST(f, 0, f.size()-1);
    
        // Node root = null;
        // for (int k = 0; k < f.size(); k++) {
        //     root = insert(root, f.get(k));
        // }
        
        // return root;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        Node root = null;

        int values[] = {4, 1, 7, 2, 6, 0, 9};

        for (int i = 0; i < values.length; i++) {
            root = tree.insert(root, values[i]);
        }

        tree.inOrder(root);
        System.out.println();

        System.out.println(tree.search(root, 4));

        //tree.delete(root, 1);

        tree.inOrder(root);

        System.out.println();
        tree.printInRange(root, 1, 9);
        System.out.println();
        

        tree.rootToLeaf(root, new ArrayList<>());

        System.out.println(tree.isValidBST(root, null, null));

        root = tree.mirror(root);


        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(5);
        arr.add(6);
        arr.add(8);
        arr.add(10);
        arr.add(11);
        arr.add(12);

        Node root2 = tree.balancedBST(arr, 0, arr.size()-1);
        tree.levelOrder(root2);
        System.out.println();

        /*
                           8
                          / \
                         6   10
                        /     \
                       5       11
                      /         \
                     3          12
         */
        Node root3 = null;
        int val[] = {8, 6, 10, 5, 11, 3, 12};
        for (int i = 0; i < val.length; i++) {
            root3 = tree.insert(root3, val[i]);
        }
        tree.levelOrder(root3);

        root3 = tree.balanceBST(root3);
        tree.levelOrder(root3);

        Node r1 = null;

        int v1[] = {2, 1, 4};

        for (int i = 0; i < v1.length; i++) {
            r1 = tree.insert(r1, v1[i]);
        }

        Node r2 = null;

        int v2[] = {9, 3, 12};

        for (int i = 0; i < v2.length; i++) {
            r2 = tree.insert(r2, v2[i]);
        }

        Node root4 = tree.mergeBST(r1, r2);
        tree.levelOrder(root4);
        tree.inOrder(root4);
        
    }
}
