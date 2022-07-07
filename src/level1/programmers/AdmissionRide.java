package level1.programmers;

public class AdmissionRide {

    public long solution(int priceSource, int money, int count) {
        long answer;
        long neededMoney = 0;
        int price = priceSource;

        for (int i = 0; i < count; i++) {
            neededMoney += price;
            price += priceSource;
        }

        if(money - neededMoney >= 0) answer = 0;
        else                         answer = neededMoney - money;

        return answer;
    }
}
