import java.util.ArrayList;

public class Main {

    private static void testCTOR() {
        Rocket u1Rocket = new U1();
        System.out.println(u1Rocket);

        Rocket u2Rocket = new U2();
        System.out.println(u2Rocket);
    }

    private static void testRunSimulation(RocketType type) {
        ItemLoader items1 = new ItemLoader("phase-1.txt");
        ItemLoader items2 = new ItemLoader("phase-2.txt");
        Simulation simulation = new Simulation();
        int cost = 0;

        if (type == RocketType.U1) {
            ArrayList<U1> rockets = Simulation.loadU1(items1.loadItems());
            cost = simulation.runSimulation(rockets);
            System.out.println("cost = " + cost);

            rockets = Simulation.loadU1(items2.loadItems());
            cost += simulation.runSimulation(rockets);
            System.out.println("cost = " + cost);
        } else {
            ArrayList<U2> rockets = Simulation.loadU2(items1.loadItems());
            cost = simulation.runSimulation(rockets);
            System.out.println("cost = " + cost);

            rockets = Simulation.loadU2(items2.loadItems());
            cost += simulation.runSimulation(rockets);
            System.out.println("cost = " + cost);
        }

        System.out.println(simulation);
    }

    public static void main(String[] args) {
        testRunSimulation(RocketType.U1);
        testRunSimulation(RocketType.U2);
    }
}
