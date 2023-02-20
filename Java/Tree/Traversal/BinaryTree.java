package Traversal;

import java.security.PublicKey;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author: Xingweicheng
 * @description: 二叉树构建类
 * @date: 2023/2/19 15:28
 */
public class BinaryTree {

    public TreeNode root = null;

    public BinaryTree(int[] array, int index) {
        root = createBinaryTree(array, index);
    }

    private TreeNode createBinaryTree(int[] array, int index) {
        TreeNode treeNode = null;
        if (index < array.length) {
            treeNode = new TreeNode(array[index]);
            // 对于顺序存储的完全二叉树，如果某个节点的索引为index，其对应的左子树的索引为2*index+1，右子树为2*index+1
            treeNode.left = createBinaryTree(array, 2 * index + 1);
            treeNode.right = createBinaryTree(array, 2 * index + 2);
        }
        return treeNode;

    }

    private void showData(TreeNode node) {
        System.out.print(node.val+" ");
    }
    //递归遍历二叉树
    public void preOrder(TreeNode node){
        if (node != null){
            showData(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public void inOrder(TreeNode node){
        if(node !=null){
            inOrder(node.left);
            showData(node);
            inOrder(node.right);
        }
    }
    public void postOrder(TreeNode node){
        if(node !=null){
            postOrder(node.left);
            postOrder(node.right);
            showData(node);
        }
    }

    // 非递归遍历二叉树

    // 前序遍历
    public void noRecursionPreOrder(TreeNode node){
        Deque<TreeNode> stack=new ArrayDeque<>();
        if(node != null){
            stack.push(node);
            while(!stack.isEmpty()){
                node=stack.pop();
                showData(node);
                if(node.right != null)
                    stack.push(node.right);
                if(node.left != null)
                    stack.push(node.left);
            }
        }
    }
    //中序遍历
    public void noRecursionInOrder(TreeNode node){
        Deque<TreeNode> stack=new ArrayDeque<>();
        TreeNode p=node;
        while(p != null || !stack.isEmpty()){
            while(p !=null){
                stack.push(p);
                p=p.left;
            }
            if (stack.size()>0){
                p=stack.pop();
                showData(p);
                p=p.right;
            }
        }

    }


    //后序遍历 ,需要记录遍历过的节点
    public void noRecursionPostOrder(TreeNode node)
    {
        TreeNode pre=node;
        Stack<TreeNode> stack=new Stack<>();
        while(node!=null)
        {
            for(;node.left!=null;node=node.left)
            {
                stack.push(node);
            }
            while(node!=null&&(node.right==null||node.right==pre))
            {
                showData(node);
                pre=node;
                if(stack.empty()) return;
                node=stack.pop();
            }
            stack.push(node);
            node=node.right;
        }
    }


    //层次遍历
    public void levelOrder(TreeNode node){
        Deque<TreeNode> queue =new ArrayDeque<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            node=queue.poll();
            showData(node);
            if (node.left!=null)
                queue.offer(node.left);
            if(node.right!=null)
                queue.offer(node.right);
        }
    }


}
