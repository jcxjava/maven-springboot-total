package com.jiangcx.pojo;

/**
 * 模拟二叉树，对二叉树进行排序
 */
public class Tree {
    private int data;
    //递归参数
    private Tree leftTree;
    private Tree rightTree;
    //节点构造器
    public Tree(int data){
        this.data = data;
    }

    /**
     * 添加树节点
     * @param newTree
     */
    public void add(Tree newTree){
        if(newTree == null){
            return;
        }
        if(newTree.data < this.data){
            if(leftTree==null){
                this.leftTree = newTree;
            }else {
                leftTree.add(newTree);
            }
        }else {
            if(rightTree==null){
                this.rightTree = newTree;
            }else {
                rightTree.add(newTree);
            }
        }
    }

    /**
     * 遍历树节点
     */
    public void travel(){
        if(leftTree != null){
            leftTree.travel();
        }
        System.out.print(data+" ");
        if(rightTree != null){
            rightTree.travel();
        }

    }
    public static void main(String[] args){
        Tree tree = new Tree(23);
        tree.add(new Tree(4));
        tree.add(new Tree(89));
        tree.add(new Tree(212));
        tree.add(new Tree(7));
        tree.add(new Tree(8));
        tree.add(new Tree(98));
        tree.add(new Tree(33));
        tree.travel();

    }
}
