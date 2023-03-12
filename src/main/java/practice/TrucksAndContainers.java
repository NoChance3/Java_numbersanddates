package practice;

import java.util.Scanner;

public class TrucksAndContainers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int box = scanner.nextInt();

        TrucksAndContainers containers = new TrucksAndContainers(box);
        System.out.println(containers);

    }
        public TrucksAndContainers(int box) {
            this.box = box;
        }
        private static final int BOX_IN_CONTAINER = 27;
        private static final int CONTAINER_IN_TRUCK = 12;
        private final int box;
        private int container;
        private int truck;

        private int containerNeed() {
            container = box / BOX_IN_CONTAINER + (box % BOX_IN_CONTAINER == 0 ? 0 : 1);
            return container;
        }
        private int truckNeed() {
            truck = containerNeed() / CONTAINER_IN_TRUCK + (containerNeed() % CONTAINER_IN_TRUCK == 0 ? 0 : 1);
            return truck;
        }

        private String distribution() {
            int container = 0;
            int box = 0;
            int truck = 0;
            String distribution = "";
            for (int i = 0; i < this.box; i++) {
                box++;
                if (box % BOX_IN_CONTAINER == 1) {
                    container++;
                }
                if (container % CONTAINER_IN_TRUCK == 1 && box % BOX_IN_CONTAINER == 1){
                    truck++;
                    distribution = distribution.concat("Грузовик: ").concat(String.valueOf(truck)).concat("\n");
                }
                if (box % BOX_IN_CONTAINER == 1) {
                    distribution = distribution.concat("\tКонтейнер: ").concat(String.valueOf(container)).concat("\n");
                }
                distribution = distribution.concat("\t\tЯщик: ").concat(String.valueOf(box)).concat("\n");
            }
            return distribution;
        }

        public String toString() {
            return  distribution() +
                    "Необходимо:\n" +
                    "грузовиков - " + truckNeed() + " шт.\n" +
                    "контейнеров - " + containerNeed() + " шт.\n";
        }

    }


