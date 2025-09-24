import java.util.LinkedList;
import java.util.Queue;



public class Day17 {
    static class Node {
        int data;
        Node left, right;
        Node (int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class BinaryTree{
        static int index = -1;
        public static Node buildTree (int nodes[]) {
            index++;
            if(nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preOrder(Node root) {
        if( root == null ) {
            System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root){
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data + " ");
                if( currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int height(Node root){
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int countOfNodes(Node root){
        if(root == null) return 0;
        int leftCount = countOfNodes(root.left);
        int rightCount = countOfNodes(root.right);

        return (leftCount + rightCount) + 1;
    }

    public static int sumOfNodes(Node root) {
        if(root == null) return 0;

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        int treeSum = leftSum + rightSum + root.data;
        return treeSum;
    }

    static class Info {
        int diameter;
        int height;

        public Info(int diameter, int height){
            this.diameter = diameter;
            this.height = height;
        }
    }

    public static Info diameter(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diameter , rightInfo.diameter), leftInfo.height + rightInfo.height + 1);
        int ht = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(diam, ht);
    }


    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        System.out.println(root.data);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
        System.out.println(height(root));
        System.out.println(countOfNodes(root));
        System.out.println(sumOfNodes(root));

        System.out.println(diameter(root).diameter);
        System.out.println(diameter(root).height);
    }
}
