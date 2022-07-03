package level1.programmers;

import java.util.*;

public class BadClient {

    HashMap<String, Integer> warnCounts = new HashMap<>();
    HashMap<String, List<String>> accuserList = new HashMap<>(); // 고발당한 사람, 고발한 사람들
    HashMap<String, Integer> mailList = new HashMap<>();
    Set<String> reports = new HashSet<>();

    public int[] solution(String[] id_list, String[] report, int k) {

        init(id_list, report);
        makeComplaint();
        sendMail(id_list, k);
        return getAnswer(id_list);
    }

    private int[] getAnswer(String[] id_list) {
        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            answer[i] = mailList.get(user);
        }

        return answer;
    }

    private void sendMail(String[] id_list, int k) {
        for (String user : id_list) {
            if (warnCounts.get(user) > k) {
                for (String accuser : accuserList.get(user)) {
                    mailList.put(accuser, mailList.get(accuser) + 1);
                }
            }
        }
    }

    private void init(String[] id_list, String[] reportSource) {

        for (String report : reportSource) {
            reports.add(report);
        }

        for (String user : id_list) {
            mailList.put(user, 0);
            warnCounts.put(user, 0);
            accuserList.put(user, new ArrayList<>());
        }
    }

    private void makeComplaint() {
        for (String report : reports) {
            String accuser = report.split(" ")[0]; // 고발자
            String accused = report.split(" ")[1]; // 피고발자

            warnCounts.put(accused, warnCounts.get(accused) + 1);
            accuserList.get(accused).add(accuser);
        }
    }
}
