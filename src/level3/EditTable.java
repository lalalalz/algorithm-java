package level3;

import java.util.Stack;

public class EditTable {
    public String solution(int n, int k, String[] cmd) {
        return getResultAfterEditTable(n, k, cmd);
    }

    private String getResultAfterEditTable(int n, int k, String[] commands) {
        Table table = new Table(n, k);

        for (String command : commands) {
            table.perform(command);
        }

        return compareSourceWithEditedOne(table);
    }

    private String compareSourceWithEditedOne(Table table) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < table.size; i++) {
            stringBuilder.append("O");
        }

        while (!table.performed.empty()) {
            int index = table.performed.pop().intValue();
            stringBuilder.insert(index, "X");
        }

        return stringBuilder.toString();
    }

    public static class Table {
        private int size;
        private int current;
        private Stack<Integer> performed;

        public Table(int size, int current) {
            this.size = size;
            this.current = current;
            this.performed = new Stack<>();
        }

        public void perform(String command) {
            char cmd = command.charAt(0);

            if (cmd == 'U') current -= Integer.valueOf(command.substring(2));;
            if (cmd == 'D') current += Integer.valueOf(command.substring(2));;
            if (cmd == 'C') delete();
            if (cmd == 'Z') restore();
        }

        private void delete() {
            performed.push(current);
            size--;
            if (current == size) current--;
        }

        private void restore() {
            int removedOne = performed.pop();
            if(removedOne <= current) current++;
            size++;
        }
    }
}
