package BTTH1_21521842;

import java.util.ArrayList;
import java.util.List;

public class bai9 {
    private int numCitizens;
    private List<List<Integer>> graph;

    public bai9(int numCitizens) {
        this.numCitizens = numCitizens;
        this.graph = new ArrayList<>(numCitizens);
        for (int i = 0; i < numCitizens; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addContact(int citizen1, int citizen2) {
        graph.get(citizen1).add(citizen2);
        graph.get(citizen2).add(citizen1);
    }

    public List<Integer> traceTransmission(int startCitizen) {
        List<Integer> infectedCitizens = new ArrayList<>();
        boolean[] visited = new boolean[numCitizens];
        dfs(startCitizen, visited, infectedCitizens);
        return infectedCitizens;
    }

    private void dfs(int citizen, boolean[] visited, List<Integer> infectedCitizens) {
        visited[citizen] = true;
        infectedCitizens.add(citizen);
        for (int neighbor : graph.get(citizen)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, infectedCitizens);
            }
        }
    }

    public static void main(String[] args) {
        int numCitizens = 16;
        bai9 contactTracing = new bai9(numCitizens);
        // Add contacts
        contactTracing.addContact(0, 1);
        contactTracing.addContact(0, 2);
        contactTracing.addContact(1, 3);
        contactTracing.addContact(1, 4);
        contactTracing.addContact(2, 5);
        contactTracing.addContact(2, 6);
        contactTracing.addContact(3, 7);
        contactTracing.addContact(3, 8);
        contactTracing.addContact(4, 9);
        contactTracing.addContact(4, 10);
        contactTracing.addContact(5, 11);
        contactTracing.addContact(5, 12);
        contactTracing.addContact(6, 13);
        contactTracing.addContact(6, 14);
        contactTracing.addContact(7, 15);

        int startCitizen = 0;
        List<Integer> infectedCitizens = contactTracing.traceTransmission(startCitizen);
        System.out.println("Infected citizens: " + infectedCitizens);
    }
}
