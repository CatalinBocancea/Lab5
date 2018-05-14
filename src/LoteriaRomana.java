import java.util.Random;

public class LoteriaRomana {

    static int MIN = 0;
    static int MAX = 6;

    public static void main(String[] args) {

        int[] agencyTicket = generateSixRandomNumbers();
        int[] myTicket = generateSixRandomNumbers();

        int contor = 1;
        int guessed = compare(agencyTicket, myTicket);
        int optiune = SkeletonJava.readIntGUI("Cate numere doriti sa ghiciti?");

        while (guessed < optiune) {
            myTicket = generateSixRandomNumbers();
            contor++;
            System.out.println(contor);
            guessed = compare(agencyTicket, myTicket);
        }

        System.out.println("We have a winner!");
        System.out.println("Bilet agentie:");
        printTicket(agencyTicket);
        System.out.println("Bilet personal:");
        printTicket(myTicket);

        SkeletonJava.printGUI("Ati nimerit " + optiune + " numere dupa " + contor + " incercari!");

        if(guessed == 6 && contor <= 1000000)
            System.out.println("LUCKY BASTARD");

    }

    static int[] generateSixRandomNumbers() {

        int[] ticket = new int[MAX];

        for (int i = MIN; i < MAX; i++) {
            ticket[i] = new Random().nextInt(49) + 1;
        }

        bubbleSort(ticket);

        for(int i = MIN; i < MAX; i++) {
            for(int j = MIN + 1; j < MAX; j++) {
                if (ticket[j - 1] == ticket[j]) {
                    ticket[j] = new Random().nextInt(49) + 1;
                    bubbleSort(ticket);
                }
            }
        }

        return ticket;
    }

    static void bubbleSort(int[] array) {

        int n = array.length;
        int temp = 0;

        for (int i = MIN; i < MAX; i++) {
            for (int j = MIN + 1; j < MAX; j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    static int compare(int[] ticket1, int[] ticket2) {

        int found = 0;

        for(int i = MIN; i < MAX; i++) {
            for(int j = MIN; j < MAX; j++) {
                if (ticket1[i] == ticket2[j])
                    found++;
            }
        }

        return found;
    }

    static void printTicket(int[] ticket) {

        for (int j = MIN; j < MAX; j++) {
            System.out.print(ticket[j] + " : ");
        }

        System.out.println();
    }
}
