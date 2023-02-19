package Traversal;

/**
 * @author: Xingweicheng
 * @description: 二叉树测试类
 * @date: 2023/2/19 15:45
 */
public class TreeTest {
    public static void main(String[] args) {
        //构建二叉树
        int[] nums=new int[]{2,3,7,6,8};
        //构建二叉树
        BinaryTree tree=new BinaryTree(nums,0);
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
        System.out.println();
        tree.preOrder(tree.root);
    }
}
