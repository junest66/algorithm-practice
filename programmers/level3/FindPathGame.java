import java.util.*;

class Solution {
    static int[] left;
    static int[] right;
    static int rootA;
    static List<Integer> pre = new ArrayList<>();
    static List<Integer> post = new ArrayList<>();

    static class Pos implements Comparable<Pos> {
        int y, x, index;

        public Pos(int y, int x, int index) {
            this.y = y;
            this.x = x;
            this.index = index;
        }

        @Override
        public int compareTo(Pos other) {
            if(this.y == other.y) {
                return this.x - other.x;
            }
            return other.y - this.y;
        }

        @Override
        public String toString() {
            return "index= " + index;
        }
    }

    public int[][] solution(int[][] nodeinfo) {
        //1. 좌표로 이진 트리 구축
        //2. 전위 후위 탐색
        left = new int[nodeinfo.length + 1];
        right = new int[nodeinfo.length + 1];
        List<Pos> list = new ArrayList<>();
        for(int i = 0; i < nodeinfo.length; i++) {
            list.add(new Pos(nodeinfo[i][1], nodeinfo[i][0], i+1));
        }
        Collections.sort(list);
        func(list);
        preOrder(list.get(0).index);
        postOrder(list.get(0).index);
        return new int[][] {
                pre.stream().mapToInt(Integer::intValue).toArray(),
                post.stream().mapToInt(Integer::intValue).toArray()
        };
    }

    public void func(List<Pos> list) {
        if(list.isEmpty()) {
            return;
        }
        Pos root = list.get(0); // root
        List<Pos> leftTree = new ArrayList<>();
        List<Pos> rightTree = new ArrayList<>();
        for(int i = 1; i < list.size(); i++) {
            if(root.x < list.get(i).x) {
                rightTree.add(list.get(i));
            } else {
                leftTree.add(list.get(i));
            }
        }
        if(!leftTree.isEmpty()) {
            left[root.index] = leftTree.get(0).index;
            func(leftTree);
        }
        if(!rightTree.isEmpty()) {
            right[root.index] = rightTree.get(0).index;
            func(rightTree);
        }
    }

    public void preOrder(int root) {
        pre.add(root);
        if(left[root] != 0) {
            preOrder(left[root]);
        }
        if(right[root] != 0) {
            preOrder(right[root]);
        }
    }

    public void postOrder(int root) {
        if(left[root] != 0) {
            postOrder(left[root]);
        }
        if(right[root] != 0) {
            postOrder(right[root]);
        }
        post.add(root);
    }
}
