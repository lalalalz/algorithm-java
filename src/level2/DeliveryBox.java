package level2;

import java.util.Stack;

public class DeliveryBox {

    private int container = 1;
    private Stack<Integer> assistContainer = new Stack<>();

    public int solution(int[] order) {
        return getCountOfDeliveryBox(order);
    }

    private int getCountOfDeliveryBox(int[] orders) {
        int loadBox = 0;

        for (int order : orders) {
            if (isOrderBoxInTopOfContainer(order)) {
                loadBox++;
                container++;
            }
            else if (isOrderBoxInContainer(order)) {
                moveBoxToAssistContainerUntilOrderBox(order);
                loadBox++;
                container++;
            }
            else if (isBoxInAssistContainer(order)) {
                takeBoxInAssistContainer();
                loadBox++;
            }
            else {
                break;
            }
        }

        return loadBox;
    }

    private boolean isOrderBoxInTopOfContainer(int order) {
        return order == container;
    }

    private boolean isOrderBoxInContainer(int order) {
        return order > container;
    }

    private void moveBoxToAssistContainerUntilOrderBox(int order) {
        while (container < order) {
            assistContainer.push(container);
            container++;
        }
    }

    private boolean isBoxInAssistContainer(int order) {
        return !assistContainer.empty() && assistContainer.peek() == order;
    }

    private void takeBoxInAssistContainer() {
        assistContainer.pop();
    }
}
