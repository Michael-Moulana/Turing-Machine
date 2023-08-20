import java.util.Scanner;

public class TuringProgram {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("This Is A Turing Machine Program That Accepts L={0^(2^n); n>=0}\n");

        String action;
        
        do {
            int numberOfZeros;
            TuringMachine machine = null;
            
            do {
                System.out.print("To Start Processing, Enter The Number Of Zeros: ");
                numberOfZeros = input.nextInt();
                
                try {
                    machine = new TuringMachine(numberOfZeros);
                    machine.process();
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                    System.out.print("\nTry Again: ");
                }
            } while (machine == null);

            System.out.print("\nDo You Want To Try Another Input? (y/n): ");
            action = input.next();
            
            if (!action.equalsIgnoreCase("y")) {
                action = "n";
            }
            
            System.out.println("\n");
        } while (action.equalsIgnoreCase("y"));
        
        System.out.println("------------------ Exited ------------------");
    }
}