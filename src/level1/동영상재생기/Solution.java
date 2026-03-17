package level1.동영상재생기;

public class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int position = convertTimeToSecond(pos);
        int videoLength = convertTimeToSecond(video_len);
        int openingStart = convertTimeToSecond(op_start);
        int openingEnd = convertTimeToSecond(op_end);

        if (openingStart <= position && position <= openingEnd) {
            position = openingEnd;
        }

        for (String command : commands) {
            if (command.equals("prev")) {
                position -= 10;
            }
            else {
                position += 10;
            }

            if (position < 0) {
                position = 0;
            }
            else if (position > videoLength) {
                position = videoLength;
            }
            
            if (openingStart <= position && position <= openingEnd) {
                position = openingEnd;
            }
        }

        return convertSecondToTime(position);
    }

    private int convertTimeToSecond(String time) {
        String[] split = time.split(":");
        int minutes = Integer.parseInt(split[0]);
        int seconds = Integer.parseInt(split[1]);
        return minutes * 60 + seconds;
    }

    private String convertSecondToTime(int seconds) {
        int minutes = seconds / 60;
        int second = seconds % 60;
        return String.format("%02d:%02d", minutes, second);
    }
}
