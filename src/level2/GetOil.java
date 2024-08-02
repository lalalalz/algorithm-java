package level2;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetOil {

    private List<Oil> oils = new ArrayList<>();
    private static final int OIL = 1;
    private static final int CHECKED = 0;

    public int solution(int[][] landInfo) {
        int answer = 0;

        // 0. 지도를 생성
        Land land = new Land(landInfo);

        // 1. 오일 정보를 획득
        checkOilOn(land);

        // 2. 가장 시추하기 좋은 곳 찾기
        for (int place = 0; place < land.width; place++) {
            int boring = boring(place);
            answer = Math.max(answer, boring);
        }

        return answer;
    }

    private void checkOilOn(final Land land) {
        for (int height = 0; height < land.getHeight(); height++) {
            for (int width = 0; width < land.getWidth(); width++) {
                if (land.getLandInfo()[height][width] == OIL) {
                    Oil oil = new Oil();
                    checkOilInfo(oil, height, width, land);
                    oils.add(oil);
                }
            }
        }
    }

    private void checkOilInfo(final Oil oil, int height, int width, final Land land) {
        if (height >= land.getHeight() || width >= land.getWidth() || height < 0 || width < 0) {
            return;
        }

        if(land.getLandInfo()[height][width] != OIL) {
            return;
        }

        oil.addOil(width);
        land.getLandInfo()[height][width] = CHECKED;

        checkOilInfo(oil, height, width + 1, land);
        checkOilInfo(oil, height + 1, width, land);
        checkOilInfo(oil, height, width - 1, land);
        checkOilInfo(oil, height - 1, width, land);
    }

    private int boring(final int place) {
        return oils.stream()
                .filter(oil -> oil.hasOil(place))
                .mapToInt(Oil::getAmount)
                .sum();
    }

    public static class Land {

        private int[][] landInfo;
        private int height;
        private int width;

        public Land(int[][] landInfo) {
            this.landInfo = landInfo;
            this.height = landInfo.length;
            this.width = landInfo[0].length;
        }

        public int[][] getLandInfo() {
            return landInfo;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }
    }


    public static class Oil {
        private int amount;
        private Set<Integer> places;

        public Oil() {
            this.places = new HashSet<>();
        }

        public void addOil(final int place) {
            this.amount++;
            this.places.add(place);
        }

        public boolean hasOil(final int place) {
            return this.places.contains(place);
        }

        public int getAmount() {
            return this.amount;
        }
    }
}
