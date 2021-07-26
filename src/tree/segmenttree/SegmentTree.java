package tree.segmenttree;

import tree.heap.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Legend
 * @data by on 18-6-21.
 * @description
 */
public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i=0;i < arr.length;i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4*arr.length];
        buildSegmentTree(0, 0, data.length-1);
    }

    // 在treeIndex位置创建索引为[l..r]区间的线段树
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l==r) {
            tree[treeIndex] = data[r];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l+(r-l)/2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid+1, r);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index<0 || index>=data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }

    // 返回区间[queryL..queryR]的值
    public E query(int queryL, int queryR) {
        if (queryL<0||queryL>=data.length || queryR<0||queryR>=data.length
                || queryL>queryR) {
            throw new IllegalArgumentException("Index is Illegal.");
        }
        return query(0, 0, data.length-1, queryL, queryR);
    }

    // 在以treeIndex为根的线段树中[l..r]范围内, 搜索区间[queryL..queryR]的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l==queryL && r==queryR) {
            return tree[treeIndex];
        }
        int mid = l+(r-l)/2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        // 要查找的区间只在左子树或右子树
        if (queryL>=mid+1) {
            return query(rightTreeIndex, mid+1, r, queryL, queryR);
        } else if (queryR<=mid) {
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }

        // 要查找的区间在左、右子树各占一部分
        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid+1, r, mid+1, queryR);
        return merger.merge(leftResult, rightResult);
    }

    private int leftChild(int index) {
        return index*2+1;
    }

    private int rightChild(int index) {
        return index*2+2;
    }

    //　将Index位置的值更新为e
    public void set(int index, E e) {
        if (index<0 || index>=data.length) {
            throw new IllegalArgumentException("Index is Illegal.");
        }
        data[index] = e;
        set(0, 0, data.length-1, index, e);
    }

    // 在以treeIndex为根的线段树中更新index的值为0
    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l==r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l+(r-l)/2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index>=mid+1) {
            set(rightTreeIndex, mid+1, r, index, e);
        } else {
            set(leftTreeIndex, l, mid, index, e);
        }
        // 索引为index的值更新后,父亲节点也需要进行更新
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i=0;i<tree.length;i++) {
            if (tree[i]!=null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }
            if (i != tree.length-1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
