import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe uma cadeia de números inteiros separados por espaço:");

        String[] inputs = sc.nextLine().split(" ");
        int[] pages = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            pages[i] = Integer.parseInt(inputs[i]);
        }

        System.out.println("Informe o número de páginas (frames):");
        int frames  = sc.nextInt();

        Algorithms output = new Algorithms(pages, frames);
        output.fifo();
        System.out.println(output);
    }
}
