import java.io.FileNotFoundException;
import java.util.*;

public class externalFactor {

    double road;
    double weather;
    double wind;
    double traffic;
    

    externalFactor() {
        System.out.println("Welcome to external factor effecting the car's mpg\n");
    }

    externalFactor(CarInitiate car, double roadC, double weatherW, double wind, double trafficT) throws FileNotFoundException {
        System.out.println();
        double effect = 0;
        effect = roadC + weatherW + wind + trafficT;
        effect = effect * 0.7;
        System.out.println("The effect of the foreign factor on mpg is " + String.format("%.2f", effect) + " mpg");
        car.updateMPG(effect);
        System.out.println();
    }
    public static double weatherW() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Enter the weather condition: ");
        System.out.println("1. Bright Day");
        System.out.println("2. Rainy/Snowy Day");
        System.out.println("3. Cloudy Day");

        int choice = sc.nextInt();
        double weather = 0;

        if (choice == 1) {
            System.out.println("You choosed the bright day");
            weather = 0.3;
        } else if (choice == 2) {
            System.out.println("You choosed the rainy/snowy day");
            weather = 0.5;
        } else if (choice == 3) {
            System.out.println("You choosed the cloudy day");
            weather = 0.1;
        } else {
            System.out.println("Invalid");
        }

        return weather;
    }

    public static double roadC() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter the road condition: ");
        System.out.println("1. Smooth Road but has few potholes");
        System.out.println("2. Road inside a pothole");
        System.out.println("3. Smooth Road");

        int choice = sc.nextInt();
        double road = 0;

        if (choice == 1) {
            System.out.println("You choosed the Smooth Road but has few potholes");

            road = 0.5;
        } else if (choice == 2) {
            System.out.println("You choosed the road inside a potholes");
            road = 1.0;
        } else if (choice == 3) {
            System.out.println("You choosed the smooth road");

            road = 0.1;
        } else {
            System.out.println("Invalid");
        }

        return road;
    }

    public static double windC() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        
        System.out.println();
        System.out.println("Enter the direction of the wind: ");
        System.out.println("1. Mostly in the direction of the moving car");
        System.out.println("2. Car is moving in the opposite direction of the wind");
        System.out.println("3. The wind is moving in the sideways direction of the car");
        int choice = sc.nextInt();

        double wind = 0;
        if (choice == 1) {
            System.out.println("You choose the wind direction to be same as car");
            wind = -2.0;
        } else if (choice == 2) {
            System.out.println("You choose the wind direction to be opposite of car");

            wind = 1.0;
        } else if (choice == 3) {
            System.out.println("You choose the wind direction to be sideways as car");

            wind = 0.5;
        } else {
            System.out.println("Invalid");
        }

        return wind;
    }

    public static double trafficC(CarInitiate car) throws FileNotFoundException {
        double effect = 0;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.println();
        System.out.println("Enter the city you want to travel: ");
        System.out.println("1. Chillawack");
        System.out.println("2. Brampton");
        System.out.println("3. New York");
        int cityChoice = sc.nextInt();
        switch (cityChoice) {
            case 1:
                effect = 0.01;
                System.out.println("Chillawack is a quiet place, so it will be easy to drive.");

                break;
            case 2:
                effect = 1.1;
                System.out.println("Brampton is a place of dodge challenger, so you know.");
                break;
            case 3:
                effect = 0.5;
                System.out.println("New York is a place with good management but have a lot of traffic.");
                break;
        }
        System.out.println();
        System.out.println("Enter the number of miles you are going to travel: ");
        double mile = sc.nextDouble();
        car.travel = mile;
        double i = 0;
        double light;
        int totalRed = 0;
        int totalYellow = 0;
        int totalGreen = 0;

        while (i <= mile) {
            System.out.println();
            light = rand.nextInt(3) + 1;
            double increment = rand.nextInt(2 ) + 0;
            if (light == 1) {
                System.out.println("Red light\n");
                System.out.println("This caused you a small amount of more fuel at " + i + " mile");
                totalRed++;
                effect += 0.1;
            } else if (light == 2) {
                System.out.println("Yellow Light\n");
                System.out.println("This caused you a little amount of more fuel at " + i + " mile");
                totalYellow++;
                effect += 0.1;
            } else if (light == 3) {
                System.out.println("Green light\n");
                System.out.println("Here you saved a small amount of fuel at " + i + " mile");
                totalGreen++;
                effect -= 0.1;
            }
            i = i + increment;
        }

        System.out.println();
        System.out.println("Car have goon through " + totalRed + " red lights");
        System.out.println("Car have goon through " + totalYellow + " yellow lights");
        System.out.println("Car have goon through " + totalGreen + " green lights");


        return effect;
    }
}
