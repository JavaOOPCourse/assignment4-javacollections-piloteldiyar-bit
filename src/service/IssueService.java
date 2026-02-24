package service;

import model.Issue;
import java.util.PriorityQueue;
import java.util.Iterator;

public class IssueService {

    private PriorityQueue<Issue> issues = new PriorityQueue<>();

    public void initializeIssues() {
        issues.add(new Issue("Failed exam appeal", 2));
        issues.add(new Issue("Scholarship deadline today", 1));
        issues.add(new Issue("Need course withdrawal", 3));
        issues.add(new Issue("Dormitory payment problem", 4));
        issues.add(new Issue("Wrong grade in transcript", 2));
    }

    public void showMostUrgent() {
        if (issues.isEmpty()) {
            System.out.println("No issues.");
            return;
        }
        System.out.println("Most urgent issue: " + issues.peek());
    }

    public void resolveIssues() {
        if (!issues.isEmpty()) {
            issues.poll();
        }
        if (!issues.isEmpty()) {
            issues.poll();
        }
    }

    public void printRemainingIssues() {
        if (issues.isEmpty()) {
            System.out.println("No remaining issues.");
            return;
        }

        Iterator<Issue> iterator = issues.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void addNewIssue(String description, int urgency) {
        issues.add(new Issue(description, urgency));
        System.out.println("Issue added.");
    }
}
