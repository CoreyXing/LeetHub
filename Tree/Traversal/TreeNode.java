package Traversal;

/**
 * @author: Xingweicheng
 * @description: 二叉树节点类
 * @date: 2023/2/19 15:12
 */
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }


}
