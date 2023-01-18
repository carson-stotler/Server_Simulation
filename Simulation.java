/***
 * @author Carson Stotler
 * @version 0.1
 * Date of Creation: Oct. 13, 2022
 * Last Date Modified: Oct. 18, 2022
 * Assignment: HW 4
 * TEST CLASS -- Simulating a movie theater line with customers and servers
 */
import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayList;
import java.util.ListIterator;

public class Simulation{

    /***
     * Main Method
     * @param String[] args
     * Asks user for input on simulation parameters, then runs the simulation based on the parameters
        and outputs the results.
     */
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println();
        int count = 0; int totalWait = 0;

        System.out.println("Enter the simulation parameters: ");
        System.out.print("Simulation time in minutes : ");
        int timeMin = scan.nextInt(); scan.nextLine();
        System.out.print("Number of servers : ");
        int numServers = scan.nextInt(); scan.nextLine();
        System.out.print("Customer Arrival Rate (Customer/Hour) : ");
        int custRate = scan.nextInt(); scan.nextLine();
        System.out.println("Service time in minutes : 5");

        ServerList list = new ServerList(numServers);
        CustomerQueue line = new CustomerQueue();

        System.out.println();
        System.out.println("Simulation Started ... ");
        for ( int clock = 0; clock < timeMin; clock ++){
            // update the server list to decrement the service time of each busy server by one time unit - use updateServiceTime //
            // System.out.println(numServers);
            list.updateServiceTime();

            // If the line's queue is nonempty, increment the waiting time of each customer by one time unit - use incrementWaitingTime //
            if ( !line.isEmpty() ){
                line.updateWaitingTime();
            }


            // If a customer arrives, add the customer to the current queue. Generate a random number p between 0 and 1.
                // If p < (customer arrival rate (custRate) / 60 ), assume a new customer arrived, otherwise no customer arrived. //
            double p = Math.random();
            if ( p < (custRate/60.0) ) {
                Customer c = new Customer(count, clock, 0);
                line.addCustomer(c);
                count++;
                System.out.println(c);
            }
            

            
            // If a server is free and the customer queue is nonempty, remove a customer from the front of the queue and assign the customer
                // to the free server ( use getNextCustomer() to get the customer at the front of the queue, getFreeServer() to get the index
                    // of the first free server or -1 if all servers are busy, and setServerBusy() to assign a customer to a server ) //
            int free1 = list.getFreeServer();

            if ( (free1 > -1) && !line.isEmpty() ){
                totalWait += line.totalWaitingTime();
                Customer nextC = line.getNextCustomer();
                System.out.println("Customer " + nextC.getCustomerNo() + " assigned to server " + list.getFreeServer() );
                list.setServerBusy(free1, nextC, 5);
                
            }

        }

        System.out.println();
        System.out.println("The simulation run for " + timeMin + " minutes");
        System.out.println("Number of Servers: " + numServers);
        System.out.println("Average Service Time: 5" );
        System.out.println("Average Number of customers: " + custRate + " customers/hour");
        System.out.println();

        System.out.println("Total Number of Customers: " + count );
        System.out.println("Number of Customers Served: " + (count - line.size() - list.getBusyServers() ) );
        System.out.println("Number of Customers left in queue: " + line.size() );
        System.out.println("Number of Customers being served: " + list.getBusyServers() );
        System.out.println();


        System.out.println("Total Waiting Time: " + totalWait);
        System.out.printf("Average Waiting Time: %-4.2f\n", ( (double)totalWait / (count - line.size()) ) );

        scan.close();
    }
}