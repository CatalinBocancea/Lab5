import java.util.Random;

public class LoteriaRomana {

    static int MIN = 0;
    static int MAX = 6;
    static int contor = 1;

    public static void main(String[] args) {

        int[] agencyTicket = generateSixRandomNumbers();
        int[] myTicket = generateSixRandomNumbers();

        int guessed = compare(agencyTicket, myTicket);
        int optiune = SkeletonJava.readIntGUI("Cate numere doriti sa ghiciti?");

        while (guessed < optiune) {
            myTicket = generateSixRandomNumbers();
            contor++;
            System.out.println(contor);
            guessed = compare(agencyTicket, myTicket);
        }

        System.out.println("Winner, Winner, Chicken Dinner!");
        System.out.println("Bilet agentie:");
        printTicket(agencyTicket);
        System.out.println("Bilet personal:");
        printTicket(myTicket);

        SkeletonJava.printGUI("Ati nimerit " + optiune + " numere dupa " + contor + " incercari!");
        calcul(optiune);

        if(guessed == MAX && contor <= 10000)
            System.out.println("LUCKY BASTARD");

    }

    static void calcul(int optiune) {

        double pret = SkeletonJava.readDoubleGUI("Care este pretul unei variante jucate?");

        switch(optiune) {

            case 1: double prize1 = SkeletonJava.readDoubleGUI("Care este premiul?");
                    double castig1 = prize1 - pret * contor;
                    if (castig1 >= 0)
                        SkeletonJava.printGUI("Castigati " + castig1 + " lei");
                    else
                        SkeletonJava.printGUI("Pierdeti " + castig1 * (-1) + " lei");
                    break;

            case 2: double prize2 = SkeletonJava.readDoubleGUI("Care este premiul?");
                    double castig2 = prize2 - pret * contor;
                    if (castig2 >= 0)
                        SkeletonJava.printGUI("Castigati " + castig2 + " lei");
                    else
                        SkeletonJava.printGUI("Pierdeti " + castig2 * (-1) + " lei");
                    break;

            case 3: double prize3 = SkeletonJava.readDoubleGUI("Care este premiul?");
                    double castig3 = prize3 - pret * contor;
                    if (castig3 >= 0)
                        SkeletonJava.printGUI("Castigati " + castig3 + " lei");
                    else
                        SkeletonJava.printGUI("Pierdeti " + castig3 * (-1) + " lei");
                    break;

            case 4: double prize4 = SkeletonJava.readDoubleGUI("Care este premiul?");
                    double castig4 = prize4 - pret * contor;
                    if (castig4 >= 0)
                        SkeletonJava.printGUI("Castigati " + castig4 + " lei");
                    else
                        SkeletonJava.printGUI("Pierdeti " + castig4 * (-1) + " lei");
                    break;

            case 5: double prize5 = SkeletonJava.readDoubleGUI("Care este premiul?");
                    double castig5 = prize5 - pret * contor;
                    if (castig5 >= 0)
                        SkeletonJava.printGUI("Castigati " + castig5 + " lei");
                    else
                        SkeletonJava.printGUI("Pierdeti " + castig5 * (-1) + " lei");
                    break;

            case 6: double prize6 = SkeletonJava.readDoubleGUI("Care este premiul?");
                    double castig6 = prize6 - pret * contor;
                    if (castig6 >= 0)
                        SkeletonJava.printGUI("Castigati " + castig6 + " lei");
                    else
                        SkeletonJava.printGUI("Pierdeti " + castig6 * (-1) + " lei");
                    break;
        }
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