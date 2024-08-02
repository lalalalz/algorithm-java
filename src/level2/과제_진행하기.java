package level2;

import java.util.*;
import java.util.stream.Collectors;

public class 과제_진행하기 {

    private List<String> finishedTasks = new ArrayList<>();
    private Stack<Task> delayedTasks = new Stack<>();
    private Stack<Task> tasks = new Stack<>();

    public static void main(String[] args) {
        과제_진행하기 solution = new 과제_진행하기();
        String[][] plans = {{"korean", "11:40", "30"},{"english", "12:10", "20"},{"math", "12:30", "40"}};
        String[] result = solution.solution(plans);

        for (String subject : result) {
            System.out.println("subject = " + subject);
        }
    }
    public String[] solution(String[][] plans) {
        tasks.addAll(Arrays.stream(plans)
                .map(plan -> new Task(plan[0], parseTimeString(plan[1]), parseTimeString(plan[2])))
                .sorted(Comparator.comparing(Task::getLastRunTime, (x, y) -> y - x))
                .collect(Collectors.toList()));

        while (!tasks.isEmpty()) {
            Task current = tasks.pop();
            int afterLastRunTime = tasks.isEmpty() ? 24 * 60 * 60 : tasks.peek().getLastRunTime();

            if (current.getEndTime() <= afterLastRunTime) {
                runDelayedTask(current, afterLastRunTime);
                finishedTasks.add(current.getName());
            }
            else {
                current.setLastTime(current.getEndTime() - afterLastRunTime);
                current.setLastRunTime(afterLastRunTime);
                delayedTasks.push(current);
            }
        }

        finishedTasks.addAll(delayedTasks
                .stream()
                .sorted(Comparator.comparing(Task::getLastRunTime, (x, y) -> y - x))
                .map(Task::getName)
                .collect(Collectors.toList())
        );
        return finishedTasks.toArray(new String[plans.length]);
    }

    private void runDelayedTask(Task current, int afterLastRunTime) {
        int remainTime = current.getEndTime() - afterLastRunTime;

        while (!delayedTasks.isEmpty() && remainTime > 0) {
            Task delayedTask = delayedTasks.pop();

            if (remainTime >= delayedTask.getLastTime()) {
                finishedTasks.add(delayedTask.getName());
                remainTime = remainTime - delayedTask.getLastTime();
            }
            else {
                delayedTask.setLastTime(delayedTask.getLastTime() - remainTime);
                delayedTask.setLastRunTime(afterLastRunTime);
                remainTime = 0;
            }
        }
    }

    private int parseTimeString(String time) {
        String[] split = time.split(":");

        if (split.length > 1) {
            return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }

        return Integer.parseInt(split[0]);
    }

    public static class Task {
        private String name;
        private int lastRunTime;
        private int lastTime;

        public Task(String name, int lastRunTime, int lastTime) {
            this.name = name;
            this.lastRunTime = lastRunTime;
            this.lastTime = lastTime;
        }

        public void setLastRunTime(int lastRunTime) {
            this.lastRunTime = lastRunTime;
        }

        public void setLastTime(int lastTime) {
            this.lastTime = lastTime;
        }

        public String getName() {
            return name;
        }

        public int getLastRunTime() {
            return lastRunTime;
        }

        public int getLastTime() {
            return lastTime;
        }

        public int getEndTime() {
            return lastRunTime + lastTime;
        }
    }
}