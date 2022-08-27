package utility;

public class RunningTime {

    public void getRunningTime(Code code) {
        long now = System.currentTimeMillis();

        // 실행코드
        code.run();

        long runningTime = System.currentTimeMillis() - now;
        System.out.println("runningTime = " + runningTime + "ms");
    }

}
