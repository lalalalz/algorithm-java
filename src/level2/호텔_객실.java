package level2;

public class 호텔_객실 {

    public static final int CLEANING_TIME = 10;
    public static final int DAY_MINUTES = 1441;

    public static void main(String[] args) {
        호텔_객실 호텔_객실 = new 호텔_객실();
        int solution = 호텔_객실.solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}});
        System.out.println("solution = " + solution);
    }

    public int solution(String[][] bookTime) {
        int[] timeOverlapGraph = new int[DAY_MINUTES];

        for (int i = 0; i < bookTime.length; i++) {
            int startTime = parseTimeString(bookTime[i][0]);
            int endTime = parseTimeString(bookTime[i][1]) + CLEANING_TIME;
            drawTimeOverlapGraph(startTime, endTime, timeOverlapGraph);
        }

        return getNecessaryRoomCount(timeOverlapGraph);
    }

    private void drawTimeOverlapGraph(int startTime, int endTime, int[] timeOverlapGraph) {
        for (int j = startTime; j < endTime; j++) {
            timeOverlapGraph[j] += 1;
        }
    }

    private int getNecessaryRoomCount(int[] timeOverlapGraph) {
        int necessaryRoomCount = 0;

        for (int i = 0; i < DAY_MINUTES; i++) {
            necessaryRoomCount = Math.max(necessaryRoomCount, timeOverlapGraph[i]);
        }

        return necessaryRoomCount;
    }

    public int parseTimeString(String time) {
        String[] splitString = time.split(":");
        return Integer.parseInt(splitString[0]) * 60 + Integer.parseInt(splitString[1]);
    }

}
