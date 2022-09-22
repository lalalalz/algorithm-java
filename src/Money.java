import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Money {

    public static void main(String[] args) {
        Receipt 성수우동 = new Receipt("성수우동", 28000);
        Receipt 방탈출 = new Receipt("방탈출", 60000);
        Receipt 빽다방 = new Receipt("빽다방", 10000);
        Receipt 스크린골프 = new Receipt("스크린골프", 60000 + 36000);
        Receipt 스타벅스 = new Receipt("스타벅스", 9000);
        Receipt 편의점 = new Receipt("한강 편의점", 10600);
        Receipt 닭강정 = new Receipt("한강 닭강정", 15000);

        User 신형철 = new User("신형철");
        신형철.use(성수우동);
        신형철.use(방탈출);
        신형철.use(빽다방);
        신형철.use(스크린골프);
        신형철.use(편의점);
        신형철.use(닭강정);

        User 남정우 = new User("남정우");
        남정우.use(성수우동);
        남정우.use(방탈출);
        남정우.use(빽다방);
        남정우.use(스크린골프);
        남정우.use(스타벅스);
        남정우.use(편의점);
        남정우.use(닭강정);

        User 최진수 = new User("최진수");
        최진수.use(성수우동);
        최진수.use(방탈출);
        최진수.use(스크린골프);
        최진수.use(빽다방);
        최진수.use(스타벅스);
        최진수.use(편의점);
        최진수.use(닭강정);

        신형철.printReceipts();
        남정우.printReceipts();
        최진수.printReceipts();
    }

    public static class Receipt {
        String title;
        int userCount;
        int amount;

        public Receipt(String title, int amount) {
            this.title = title;
            this.amount = amount;
        }

        public int calcMyAmount() {
            return amount / userCount;
        }

        @Override
        public String toString() {
            return "사용처 : " + title + "\n" +
                    "금액 : " + amount + "원";
        }
    }

    public static class User {
        List<Receipt> receipts = new ArrayList<>();
        String name;
        int amount = 0;

        public User(String name) {
            this.name = name;
        }

        public void use(Receipt receipt) {
            receipt.userCount++;
            receipts.add(receipt);
        }

        private void calcMyAmount() {
            for (Receipt receipt : receipts) {
                amount += receipt.calcMyAmount();
            }
        }

        public void printReceipts() {
            System.out.println("=====================" + name + "님의 카드 사용 내역서=====================");
            for (Receipt receipt : receipts) {
                System.out.println(receipt + " 중 " + receipt.calcMyAmount() + "원\n");
//                System.out.println("내가 내야할 돈 : " + receipt.calcMyAmount());
            }

            calcMyAmount();
            System.out.println(name + "님이 내셔야 할 총액 : " + amount);
            System.out.println("=====================" + name + "님의 카드 사용 내역서=====================");
        }
    }
}
