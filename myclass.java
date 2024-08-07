import java.util.Scanner; 
interface Transport { 
void adjustGear(int gearChange); 
void increaseSpeed(int increment); 
void reduceSpeed(int decrement); 
void showStatus(); 
} 
class Scooter implements Transport { 
private int currentGear; 
private int velocity; 
final int topSpeed = 60; 
@Override 
public void adjustGear(int gearChange) { 
if (gearChange > 0) { 
currentGear = gearChange; 
} else  
{ 
System.out.println("Invalid gear input."); 
} 
} 
@Override 
public void reduceSpeed(int decrement) { 
velocity -= decrement; 
if (velocity < 0) velocity = 0; 
} 
@Override 
public void increaseSpeed(int increment) { 
if (velocity + increment <= topSpeed) { 
velocity += increment; 
} else { 
System.out.println("Exceeded Scooter's maximum speed of " + 
topSpeed); 
} 
} 
@Override 
public void showStatus() { 
System.out.println("Scooter's speed: " + velocity + "km/h, Gear: " + 
currentGear); 
} 
} 
public class Main { 
public static void main(String[] args) { 
Scanner scanner = new Scanner(System.in); 
Scooter scooter = new Scooter(); 
while (true) { 
System.out.println("\nOptions:"); 
System.out.println("1. Change Gear"); 
System.out.println("2. Accelerate"); 
System.out.println("3. Brake"); 
System.out.println("4. Display Status"); 
System.out.println("5. Exit\n"); 
System.out.print("Select an action: "); 
int action = scanner.nextInt(); 
            switch (action) { 
                case 1: 
                    System.out.print("Enter new gear: "); 
                    int newGear = scanner.nextInt(); 
                    scooter.adjustGear(newGear); 
                    break; 
                case 2: 
                    System.out.print("Enter acceleration amount: "); 
                    int speedIncrease = scanner.nextInt(); 
                    scooter.increaseSpeed(speedIncrease); 
                    break; 
                case 3: 
                    System.out.print("Enter deceleration amount: "); 
                    int speedDecrease = scanner.nextInt(); 
                    scooter.reduceSpeed(speedDecrease); 
                    break; 
                case 4: 
                    scooter.showStatus(); 
                    break; 
                case 5: 
                    System.out.println("Program terminated."); 
                    System.exit(0); 
                    break; 
                default: 
                    System.out.println("Invalid option. Please try again."); 
            } 
        } 
    } 
}