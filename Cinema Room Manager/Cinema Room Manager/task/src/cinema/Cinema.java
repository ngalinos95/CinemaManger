package cinema;
import java.util.*;


public class Cinema {
    public static int ticketPrice=10;
    public static int profit;
    public static int income;
    public static int userInput=10;
    public static double purchasedTickets=0;
    public static boolean correctInput=false;
    public static void main(String[] args) {

        //Input 2 values- number of Rows=nRows
        //Number of seats=nSeats
        System.out.println("Enter the number of rows:");
        Scanner sc=new Scanner(System.in);
        int nRows=sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int nSeats=sc.nextInt();
        income=0;

        //Create an array 2D-matrix (seats x rows)
        String[][] seats = new String[nRows][nSeats];
        for (int y = 0; y < nRows; y++) {

            for (int x = 0; x < nSeats; x++) {
                seats[y][x] = "S";
            }
        }

        while(userInput!=0) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            userInput = sc.nextInt();


        //Calculating the maximum total income based on available seats
        if(nRows*nSeats<=60){
            ticketPrice=10;
            profit=ticketPrice*nRows*nSeats;
        }
        else{
            profit=(nRows/2*10+(nRows-nRows/2)*8)*nSeats;
        }


            if (userInput == 1) {
                //Print the table with correct axis and header
                System.out.println("Cinema:");
                System.out.print(" ");
                for (int x = 1; x < nSeats + 1; x++) {
                    System.out.print(" " + x);
                }
                System.out.println();
                for (int y = 0; y < nRows; y++) {
                    System.out.print(y + 1);
                    for (int x = 0; x < nSeats; x++) {
                        System.out.print(" " + seats[y][x]);
                    }
                    System.out.println();

                }
            } else if (userInput == 2) {
                correctInput=false;
                while(correctInput==false){
                //input of the chosen seat
                try{
                System.out.println("Enter a row number:");
                int rowNumber = sc.nextInt();
                System.out.println("Enter a seat number in that row:");
                int seatNumber = sc.nextInt();
                if (seatNumber>nSeats || seatNumber<0 || rowNumber<0 || rowNumber>nRows){
                        throw new IllegalAccessException("Wrong input!");}
                if (seats[rowNumber-1][seatNumber-1] == "B") {
                    throw new IllegalAccessException("That ticket has already been purchased!");}
                //Calculate and the print the ticket price
                    correctInput=true;
                    purchasedTickets++;
                if (nRows * nSeats < 60) {
                    ticketPrice = 10;
                } else if (rowNumber <= nRows / 2) {
                    ticketPrice = 10;

                } else {
                    ticketPrice = 8;

                }
                income =income+ticketPrice;
                System.out.println("Ticket price: $" + ticketPrice);

                seats[rowNumber - 1][seatNumber - 1] = "B";
                }
                catch (Exception e){System.out.println(e.getMessage());
                    }
                }
            } else if (userInput == 0) {
                sc.close();
                break;
            }else if (userInput==3) {
                double percentage= purchasedTickets/(nRows*nSeats)*100;

                System.out.println("Number of purchased tickets: "+(int)purchasedTickets);
                System.out.printf("Percentage: %,.2f",percentage);
                System.out.print("%");
                System.out.println();
                System.out.println("Current income: $"+income);
                System.out.println("Total income: $"+profit);

                }
            }
        }


    }
