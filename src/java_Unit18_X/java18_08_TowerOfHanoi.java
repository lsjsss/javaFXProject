package java_Unit18_X;

import java.util.Scanner;

public class java18_08_TowerOfHanoi {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = input.nextInt();
        // Find the solution recursively
        System.out.println("The moves are:");
        moveDisks(n, 'A', 'B', 'C');
    }

    /**
     * The method for finding the solution to move n disks
     * from fromTower to toTower with auxTower
     */
    public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
        // Stopping condition
        if (n == 1) {
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
        } else {
            moveDisks(n - 1, fromTower, auxTower, toTower);
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
            moveDisks(n - 1, auxTower, toTower, fromTower);
        }
    }
}