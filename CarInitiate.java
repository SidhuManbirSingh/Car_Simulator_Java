import java.io.FileNotFoundException;
import java.util.Scanner;

public class CarInitiate {
    String name;
    double mpg;
    int tire;
    double eng;
    double og;
    double gallon;
    double travel;

    CarInitiate() {

    }

    CarInitiate(String name, double mpg, int tire, double eng) {
        this.name = name;
        this.mpg = mpg;
        this.tire = tire;
        this.eng = eng;
        System.out.println();
        og = this.mpg;
        double qual = (this.tire + this.eng) / 25;
        System.out.println("The car's original mpg is " + og);
        System.out.println("\nThe car's condition have effected the MPG by: " + qual);
        this.mpg -= qual;

    }

    public double getMPG() {
        return mpg;
    }

    public void setMPG(double add) {
        this.mpg = add;
    }

    public void updateMPG(double add) {
        this.mpg = this.mpg - add;
    }

    public static int carCondition() throws FileNotFoundException {

        int i = 0;
        double usage = 0;

        Scanner sc = new Scanner(System.in);

        System.out.print("\nHow old is the car?(in years): ");
        usage = sc.nextDouble();
        System.out.println();
        if (usage >= 6) {
            System.out.println("Tires are used for a considerable period and are in bad shape.");

            i = 50;

        } else if (usage < 6 && usage > 4) {
            System.out.println("Tires are used for a considerable period.");
            i = 35;

        } else if (usage <= 4 && usage > 2) {
            System.out.println("Tires has been used but are not in bad shape.");

            i = 25;

        } else {
            System.out.println("New like tire.");
            i = 10;
        }
        System.out.println();
        return i;
    }

    public static double engineRev(int i) throws FileNotFoundException {

        double j = 0;
        switch (i) {
            case 50:
                j = i * 2.0;
                System.out.println("The engine is very old");

                break;
            case 35:
                j = i * 1.2;
                System.out.println("The engine is old");

                break;
            case 25:
                j = i * 0.8;
                System.out.println("The engine is in workable phase.");

                break;
            case 10:
                j = i * 0.7;
                System.out.println("The engine is new");

                break;
            default:
                System.out.println("Invalid");

                break;
        }
        return j;
    }
}
