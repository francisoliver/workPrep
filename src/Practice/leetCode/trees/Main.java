package Practice.leetCode.trees;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sayHello();
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);

//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
//
//        priorityQueue.add(2);
//        priorityQueue.add(9);
//        priorityQueue.add(1);
//        priorityQueue.add(100);
//        priorityQueue.add(5);
//        priorityQueue.add(3);
//        priorityQueue.add(7);
//
//        System.out.println(priorityQueue);
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue);
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue.poll());
//        System.out.println(priorityQueue.poll());

        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.push();

        System.out.println(list);
        list.poll();
        System.out.println(list);

        System.out.println("My stack");
        Stack<Integer> stacks = new Stack<>();
        stacks.add(0);
        stacks.add(1);
        stacks.add(2);
        stacks.add(3);
        stacks.add(4);

        System.out.println(stacks);
        stacks.pop();
        System.out.println(stacks);



        
    }

}
