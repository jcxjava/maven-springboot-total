package com.jiangcx.pojo;

public class BiTree {

    private int data;
    private BiTree lTree;
    private BiTree rTree;

    public BiTree(int data) {
        this.data = data;
    }

    public void add(BiTree t){
        if(t == null){
            return;
        }
        if(t.data < this.data){
            if(lTree == null){
                lTree = t;
            }else {
                lTree.add(t);
            }
        }else {
            if(rTree == null){
                rTree = t;
            }else {
                rTree.add(t);
            }
        }
    }


    public void travel(){
        if(lTree != null){
            lTree.travel();
        }
        System.out.print(data + " ");
        if(rTree != null){
            rTree.travel();
        }
    }
    public static void main(String[] args){
        BiTree tree = new BiTree(29);
        tree.add(new BiTree(34));
        tree.add(new BiTree(12));
        tree.add(new BiTree(1));
        tree.add(new BiTree(97));
        tree.add(new BiTree(90));
        tree.add(new BiTree(65));
        tree.add(new BiTree(43));
        tree.add(new BiTree(55));
        tree.add(new BiTree(79));
        tree.add(new BiTree(12));
        tree.add(new BiTree(78));

        tree.travel();

    }
}
