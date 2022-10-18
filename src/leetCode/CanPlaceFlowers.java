package leetCode;

public class CanPlaceFlowers {

    private static final int PLANTED = 1;

    public boolean canPlaceFlowers(int[] flowerbed, int flowers) {
        boolean[] plantedPlace = generatePlantedPlace(flowerbed);
        return canPlantedFlowers(plantedPlace, flowers);
    }

    private boolean canPlantedFlowers(boolean[] plantedPlace, int flowers) {
        int planted = 0;

        for (int i = 0; i < plantedPlace.length; i++) {
            if (!plantedPlace[i]) {
                planted++;
                set(plantedPlace, i);
            }
        }

        return flowers == planted;
    }

    private boolean[] generatePlantedPlace(int[] flowerbed) {
        boolean[] plantedPlace = new boolean[flowerbed.length];

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == PLANTED) {
                set(plantedPlace, i);
            }
        }

        return plantedPlace;
    }

    private void set(boolean[] plantedPlace, int i) {
        int n = plantedPlace.length;

        plantedPlace[i] = true;
        if(i - 1 >= 0) plantedPlace[i - 1] = true;
        if(i + 1 <  n) plantedPlace[i + 1] = true;
    }
}
