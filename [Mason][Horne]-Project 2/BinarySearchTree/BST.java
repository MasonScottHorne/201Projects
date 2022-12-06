import java.sql.SQLOutput;

public class BST {
    // the below variable should keep track of the number of nodes in the BST. Must increment/decrement num_nodes appropriately in insert/delete and ArrayToTree.

    private int num_nodes;
    private TreeNode root;
    private int index;
    private class TreeNode {
        int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    //get the number of nodes
    public int getNumNodes() {
        return num_nodes;
    }
    //insert a node
    public boolean insert(int value) {
        TreeNode newNode = new TreeNode(value);
        //if root is null
        if (root == null) {
            root = newNode;
            return true;
        }
        TreeNode temp = root;
        //rearrange values to insert it
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }
    //search for it boolean if it is in it
    public boolean find(int value) {
        TreeNode temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }
    //delete the treenode that is specified traversing through the tre
    public TreeNode delete(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        if (value < root.value) {
            root.left = delete(root.left, value);
            return root;
        } else if (value > root.value) {
            root.right = delete(root.right, value);
            return root;
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode m = root.right;
                while (m.left != null) {
                    m = m.left;
                }
                root.value = m.value;
                root.right = delete(root.right, m.value);
                return root;
            }
        }


    }
    //array to tree method calling helper
    public void ArrayToTree(int array[]) {
        //error
        if (array.length == 0) {
            return;
        }
        ArrayToTree_helper(array, 0, array.length - 1);
    }


    // Part 2.
    //array to tree helper returning node and using recursion on left and right
    private TreeNode ArrayToTree_helper(int array[], int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(array[mid]);
        node.left = ArrayToTree_helper(array, low, mid - 1);
        node.right = ArrayToTree_helper(array, mid + 1, high);
        return node;
    }

    // Part 3.
    //preorder travesal arrangement
    public int[] preorder_traversal() {
        int[] sol = new int[num_nodes];
        preorder_helper(root, sol);
        index =0;
        return sol;
    }
    //using recursion here to help
    private void preorder_helper(TreeNode node, int[] array) {
        if (node == null) return;
        array[index++] =node.value;
        preorder_helper(node.left, array);
        preorder_helper(node.right, array);
    }
    //post order traversal method
    public int[] postorder_traversal(TreeNode node, int[]array){
        int[] sol = new int[num_nodes];
        postorder_helper(root, sol);
        index = 0;
        return sol;
    }
    //using recursion here to help
    private void postorder_helper(TreeNode node, int[] array){
        if(node==null) return;
        postorder_helper(node.left,array);
        postorder_helper(node.right,array);
        array[index++]=node.value;
    }
    //inorder traversal method arangement
    public int[] inorder_traversal(){
        int[] sol = new int[num_nodes];
        inorder_helper(root,sol);
        index=0;
        return sol;
    }
    //using recursion here to help
    private void inorder_helper(TreeNode node, int[] array){
        //checking
        if(node==null) return;
        inorder_helper(node.left,array);
        array[index++]=node.value;
        inorder_helper(node.right, array);
    }
//find min in tree searching left side
    public int findMin(TreeNode node, TreeNode curr){
     curr = node;
     while(curr.left!=null) {
         curr = curr.left;
     }
     return(curr.value);
    }
//find max in tree searching right side
    public int findMax(TreeNode node, TreeNode curr){
    curr = node;
    while(curr.right!=null) {
        curr = curr.right;
    }
    return(curr.value);
    }
}