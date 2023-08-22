import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class DrivingSimulation_SidhuManbirSingh {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to the program\n");
        System.out.println("*********************************");
        System.out.println("CAR MILEAGE PROGRAM");
        System.out.println("*********************************");
        System.out.println();


        run();

    }

   
    public static externalFactor foreignFactor(CarInitiate car) throws FileNotFoundException {
        externalFactor foo = null;
        double weather = externalFactor.weatherW();
        double road = externalFactor.roadC();
        double traffic = externalFactor.trafficC(car);
        double wind = externalFactor.windC();
        foo = new externalFactor(car, road, weather, wind, traffic);
        

        return foo;
    }

    public static CarInitiate carinfo() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        System.out.println();
        System.out.println("Choose a Vehicle for the trip");
        System.out.println("1. Mercedes AMG One (2 seats)");
        System.out.println("2. Lamborghini Urus (5 seats)");
        System.out.println("3. Honda Civic (5 seats)");

        System.out.print("Enter the integer(1-3) to choose your car: ");
        choice = sc.nextInt();
        CarInitiate car = null;

        if (choice == 1) {

            System.out.println("********");
            System.out.println("You choosed the Mercedes AMG One");
            System.out.println("********");

            int cond = CarInitiate.carCondition();
            double cond2 = CarInitiate.engineRev(cond);

            car = new CarInitiate("Mercedes AMG One", 23.75, cond, cond2);

        } else if (choice == 2) {

            System.out.println("********");
            System.out.println("You choosed the Lamborghini Urus");
            System.out.println("********");

            int cond = CarInitiate.carCondition();
            double cond2 = CarInitiate.engineRev(cond);

            car = new CarInitiate("Lamborghini Urus", 20.70, cond, cond2);
        } else if (choice == 3) {

            System.out.println("********");
            System.out.println("You choosed the Honda Civic");
            System.out.println("********");

            int cond = CarInitiate.carCondition();
            double cond2 = CarInitiate.engineRev(cond);

            car = new CarInitiate("Honda Civic", 32.5, cond, cond2);
        } else {
            System.out.println("Invalid Choice");

        }
        return car;
    }
    public static void run() throws FileNotFoundException{
        int choice = 1;
        do {
            Scanner sc = new Scanner(System.in);

            PrintStream write = new PrintStream(new File("report.txt"));

            CarInitiate selected = carinfo();
            externalFactor selected1 = foreignFactor(selected);
            selected.gallon = selected.travel/selected.getMPG();
            System.out.println("*********************************");
            System.out.println("*********************************\n");
            System.out.println("Name of the car: " + selected.name);
            System.out.println("Car has travelled : " + selected.travel + " miles");
            System.out.println("Car has consumed around: " + String.format("%.2f", selected.gallon) + " gallons");
            System.out.println("So, the original mpg is " + String.format("%.2f", selected.og) + " mpg");
            System.out.println("So, the mpg is " + String.format("%.2f", selected.getMPG()) + " mpg");
            System.out.println();
            System.out.println("*********************************");
            System.out.println("************************************");

            write.println("*********************************");
            write.println("*********************************\n\n");
            write.println("Name of the car: " + selected.name);
            write.println("Car has travelled : " + selected.travel + " miles");
            write.println("Car has consumed around: " + String.format("%.2f", selected.gallon) + " gallons");
            write.println("So, the original mpg is " + String.format("%.2f", selected.og) + " mpg");
            write.println("So, the mpg is " + String.format("%.2f", selected.getMPG()) + " mpg");
            write.println();
            write.println("*********************************");
            write.println("************************************");
            System.out.print("Do you want to stop(Enter -1): ");
            choice = sc.nextInt();

        } while (choice != -1);
    }
}