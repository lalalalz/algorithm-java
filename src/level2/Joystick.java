package level2;

public class Joystick {

    private char from = 'A';

    public int solution(String name) {
        int movedCounts = 0;

        for (int i = 0; i < name.length(); i++) {
            movedCounts += moveToLeastPath(name.charAt(i));
        }

        return movedCounts;
    }

    private int moveToLeastPath(char to) {
        if(to == 'A') return 0;

        int defaultDirection = moveDefaultDirection(from, to);
        int nonDefaultDirection = moveNonDefaultDirection(from, to);
        from = to;

        return defaultDirection > nonDefaultDirection ?
                nonDefaultDirection : defaultDirection;
    }

    private int moveCursor()

    private int moveNonDefaultDirection(char from, char to) {
        if(from > to) return to - ('Z' - from);
        return (from - 'A') + ('Z' - to);
    }

    private int moveDefaultDirection(char from, char to) {
        return Math.abs(from - to);
    }
}

