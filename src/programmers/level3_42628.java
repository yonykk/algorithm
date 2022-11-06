package programmers;

import java.util.*;

public class level3_42628 {

    static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> min = new PriorityQueue<>();

    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] answer = new int[2];
        for (String op : operations) {
            String[] arr = op.split(" ");
            if(arr[0].equals("I"))
                insert(Integer.parseInt(arr[1]));
            else
                if(arr[1].equals("1"))
                    deleteMax();
                else
                    deleteMin();

        }
        if(!max.isEmpty()){
            answer[0] = max.poll();
            answer[1] = min.poll();
        }
        System.out.println(answer[0]+" "+answer[1]);
    }

    public static void insert(int n){
        max.offer(n);
        min.offer(n);
    }
    public static void deleteMin(){
        if(min.isEmpty())
            return;
        int n = min.poll();
        max.remove(n);
    }
    public static void deleteMax(){
        if(max.isEmpty())
            return;
        int n = max.poll();
        min.remove(n);
    }
}
