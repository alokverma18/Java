package BinaryTree;

import java.util.*;

public class BinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    static int idx=-1;
    public Node buildPreOrder(int[] nodes){
        idx++;
        if(nodes[idx]==-1){
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildPreOrder(nodes);
        newNode.right = buildPreOrder(nodes);
        return newNode;        
    }

    public void preOrder(Node root){
        if(root==null){
            //System.out.print("-1 ");
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void levelOrder(Node root){
        if(root==null){
            System.out.println();
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            System.out.print(temp.data + " ");
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
    }

    public void levelOrder2(Node root){
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

    public int height(Node root){
        if(root==null){
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l,r)+1;
    }

    public int count(Node root){
        if(root==null){
            return 0;
        }
        int l = count(root.left);
        int r = count(root.right);
        return l+r+1;
    }

    public int sum(Node root){
        if(root==null){
            return 0;
        }
        int l = sum(root.left);
        int r = sum(root.right);
        return l+r+root.data;
    }

    public int diameter2(Node root){
        if(root==null){
            return 0;
        }
        int l = diameter2(root.left);
        int r = diameter2(root.right);

        return Math.max(Math.max(l, r), height(root.left)+height(root.right)+1);
    }

    public class Info {
        int diameter;
        int height;

        Info(int d, int h){
            this.diameter = d;
            this.height = h;
        }
    }

    public Info diameter(Node root){
        if(root==null){
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height+rightInfo.height+1);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(diameter, height);
    }

    public boolean isIdentical(Node node, Node subroot){
        if(node==null && subroot==null){
            return true;
        } else if(node==null || subroot==null || node.data!=subroot.data){
            return false;
        }

        if(!isIdentical(node.left, subroot.left)){
            return false;
        }
        if(!isIdentical(node.right, subroot.right)){
            return false;
        }
        return true;
    }
    public boolean isSubtree(Node root, Node subroot){
        if(root==null){
            return false;
        }
        if(root.data == subroot.data){
            if(isIdentical(root, subroot)){
                return true;
            }
        }
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    public class TopInfo{
        int hd;
        Node node;

        TopInfo(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public void topView(Node root){

        Queue<TopInfo> q = new LinkedList<>(); 
        HashMap<Integer, Node> map = new HashMap<>();
        int min=0, max=0;

        q.add(new TopInfo(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            TopInfo curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
    
                if(curr.node.left!=null){
                    q.add(new TopInfo(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right!=null){
                    q.add(new TopInfo(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }
        for(int i=min; i<=max; i++){
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public void kthLevel(Node root, int l, int level){
        if(root==null){
            return;
        } else if(level==l){
            System.out.print(root.data + " ");
            return;
        } 
        kthLevel(root.left, l+1, level);
        kthLevel(root.right, l+1, level);
    }

    public boolean getPath(Node root, int n, ArrayList<Node> path){

        if(root==null){
            return false;
        }

        path.add(root);

        if(root.data == n){
            return true;
        }

        boolean left = getPath(root.left, n, path);
        boolean right = getPath(root.right, n, path);

        if(left || right){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    public Node lca(Node root, int n1, int n2){

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i=0;
        for(; i<path1.size() && i<path2.size(); i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        Node lca =  path1.get(i-1);
        return lca;
    }

    public Node lca2(Node root, int n1, int n2){
        if(root==null || root.data==n1 || root.data==n2){
            return root;
        }

        Node left = lca2(root.left, n1, n2);
        Node right = lca2(root.right, n1, n2);

        if(left==null){
            return right;
        } else if (right==null){
            return left;
        }
        return root;
    }

    public int lcaDistance(Node root, int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int left = lcaDistance(root.left, n);
        int right = lcaDistance(root.right, n);

        if(left==-1 && right==-1){
            return -1;
        } else if(left==-1){
            return right+1;
        } else {
            return left+1;
        }
    }
    public int minDistance(Node root, int n1, int n2){
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDistance(lca, n1);
        int dist2 = lcaDistance(lca, n2);
        return dist1+dist2;

    }

    public int kthAncestor(Node root, int n, int k){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int left = kthAncestor(root.left, n, k);
        int right = kthAncestor(root.right, n, k);

        if(left==-1 && right==-1){
            return -1;
        }
        int max = Math.max(left, right);
        if(max+1==k){
            System.out.println(root.data);
        }
        return max+1;
    }

    public int transform(Node root){
        if(root==null){
            return 0;
        }
        int left = transform(root.left);
        int right = transform(root.right);

        int data = root.data;

        int newLeft = root.left==null ? 0 : root.left.data;
        int newRight = root.right==null ? 0 : root.right.data;
          
        root.data = left+newLeft + right+newRight;

        return data;
    }

    // Largest BST in a BT

    public static class InfoBST{
        boolean bst;
        int size;
        int min;
        int max;

        InfoBST(boolean bst, int size, int min, int max){
            this.bst = bst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static int maxSize = 0;
    public static Node rootOfLargestBST;

    public static InfoBST largestBST(Node root){
        
        if(root==null){
            return new InfoBST(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        InfoBST left = largestBST(root.left);
        InfoBST right = largestBST(root.right);

        int size = left.size+right.size+1;
        int min = Math.min(Math.min(left.min, right.min), root.data);
        int max = Math.max(Math.max(left.max, right.max), root.data);
        
        if(root.data<=left.max || root.data>=right.min){
            return new InfoBST(false, size, min, max);
        }
        if(left.bst && right.bst){
            if(size>maxSize){
                maxSize = size;
                rootOfLargestBST = root;
            }
            return new InfoBST(true, size, min, max);
        }
        
        return new InfoBST(false, size, min, max);
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
              / \   \
             4   5   6

        */
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildPreOrder(nodes);

        /*
            2
           / \
          4   5

        */

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        
        System.out.print("\nInorder : ");
        tree.preOrder(root);
        
        System.out.print("\nLevel Order : ");
        tree.levelOrder(root);
        

        System.out.println("\nHeight : " + tree.height(root));

        System.out.println("Count : " + tree.count(root));

        System.out.println("Sum : " + tree.sum(root));

        System.out.println("Diameter : " + tree.diameter(root).diameter);

        System.out.println(tree.isSubtree(root, subRoot));

        tree.topView(root);

        tree.kthLevel(root, 1, 3);

        System.out.println();

        System.out.println(tree.lca(root,  2, 1).data);  
        System.out.println(tree.lca2(root, 2, 1).data);  
        
        System.out.println(tree.minDistance(root, 4, 6));

        tree.kthAncestor(root, 6, 2);

        tree.levelOrder2(root);

        tree.transform(root);

        tree.levelOrder2(root);

        Node root2 = new Node(50);
        root2.left = new Node(30);
        root2.left.left = new Node(5);
        root2.left.right = new Node(20);

        root2.right = new Node(60);
        root2.right.left = new Node(45);
        root2.right.right = new Node(70);
        root2.right.right.left = new Node(65);
        root2.right.right.right = new Node(80);


        tree.inOrder(root2);

        // InfoBST info =  largestBST(root2);
        // System.out.println(maxSize);
        // System.out.println(rootOfLargestBST.data);

        

    }
}
