package service;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ActionHistoryService {

    private ArrayDeque<String> actions = new ArrayDeque<>();

    public void initializeActions() {
        actions.add("Submitted Assignment");
        actions.add("Dropped Course");
        actions.add("Registered Course");
        actions.add("Updated Profile");
    }

    public void undoLastAction() {
        if (!actions.isEmpty()) {
            String removed = actions.removeLast();
            System.out.println("Undone action: " + removed);
        } else {
            System.out.println("No actions to undo.");
        }
    }

    public void addRequestedTranscript() {
        actions.add("Requested Transcript");
    }

    public void showFirstAndLast() {
        if (actions.isEmpty()) {
            System.out.println("No action history.");
            return;
        }
        System.out.println("First action: " + actions.getFirst());
        System.out.println("Last action: " + actions.getLast());
    }

    public void printHistory() {
        if (actions.isEmpty()) {
            System.out.println("No actions in history.");
            return;
        }

        Iterator<String> iterator = actions.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
