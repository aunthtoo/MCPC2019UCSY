import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*Problem J: Meeting Point*/

public class J {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();

            ArrayList<Node>[] dataTable = new ArrayList[n];

            for (int i = 0; i < n; i++)
                dataTable[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int node1 = sc.nextInt(), node2 = sc.nextInt(), distance = sc.nextInt();
                dataTable[node1 - 1].add(new Node(node2 - 1, distance));
                dataTable[node2 - 1].add(new Node(node1 - 1, distance));
            }

            int[] kkSTP = new int[n], ttSTP = new int[n];
            Arrays.fill(kkSTP, Integer.MAX_VALUE);
            Arrays.fill(ttSTP, Integer.MAX_VALUE);
            boolean[] kkstpset = new boolean[n], ttstpset = new boolean[n];

            solveDijkstra(dataTable, kkSTP, kkstpset, 1);
            solveDijkstra(dataTable, ttSTP, ttstpset, n);

            for (int i = 0; i < k; i++) {
                int kkinmile = sc.nextInt(), ttinmile = sc.nextInt();

                int minwaitingtime = Integer.MAX_VALUE, idx = 0;

                for (int j = 0; j < n; j++) {

                    int kk = kkSTP[j] * kkinmile, tt = ttSTP[j] * ttinmile;

                    int temp;
                    if (kk > tt) {
                        temp = kk - tt;
                    } else {
                        temp = tt - kk;
                    }

                    if (temp < minwaitingtime) {
                        minwaitingtime = temp;
                        idx = j + 1;
                    }

                }

                System.out.println(idx + " " + minwaitingtime);
            }

        }

    }


    static void solveDijkstra(ArrayList<Node>[] dataTable, int[] stp, boolean[] stpset, int source) {

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new Node(source - 1, 0));
        stp[source - 1] = 0;

        while (!priorityQueue.isEmpty()) {

            Node top = priorityQueue.poll();

            stpset[top.id] = true;

            for (Node node : dataTable[top.id]) {
                int newdist = stp[top.id] + node.dist;

                if (!stpset[node.id] && newdist < stp[node.id]) {
                    priorityQueue.add(new Node(node.id, newdist));
                    stp[node.id] = newdist;
                }
            }
        }


    }

    static class Node implements Comparable<Node> {

        private int id, dist;

        public Node(int id, int dist) {
            super();
            this.id = id;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            if (this.dist < o.dist)
                return -1;
            else
                return 1;
        }
    }
}
