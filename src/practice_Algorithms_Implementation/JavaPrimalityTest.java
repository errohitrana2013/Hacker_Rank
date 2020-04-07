package practice_Algorithms_Implementation;

import java.math.BigInteger;
import java.util.Scanner;

public class JavaPrimalityTest {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String n = scanner.nextLine();
        BigInteger a = new BigInteger(n);
        scanner.close();
        System.out.println(a.isProbablePrime(10) ? "prime" : "not prime");
    }
}
