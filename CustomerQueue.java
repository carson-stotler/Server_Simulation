/***
 * @author Carson Stotler
 * @version 0.1
 * Date of Creation: Oct. 13, 2022
 * Last Date Modified: Oct. 18, 2022
 * Assignment: HW 4
 * Simulating a movie theater line with customers and servers
 */
import java.util.Queue;
// import java.util.Iterator;
import java.util.LinkedList;

public class CustomerQueue{
    //data members
    private Queue<Customer> customers;

    /***
     * no-arg Constuctor
     * no paramateres
     * Initializes customers Queue as a new LinkedList<Customer>
     */
    public CustomerQueue(){
        this.customers = new LinkedList<Customer>();
    }

    /***
	 * Method to return next Customer by using poll from queue
	 * no param
	 * @return Customer represents Customer on top of queue
	 */
    public Customer getNextCustomer(){
        return customers.poll();
    }

    /***
	 * void method to update waiting time for each customer still in queue - using incrementWaitingTime
	 * no param
	 * no return
	 */
    public void updateWaitingTime(){
        for ( Customer c: customers ){
            c.incrementWaitingTime();
        }
    }

    /***
	 * Method to return next Customer's waiting time - using peek
	 * no param
	 * @return int of waiting time of next customer
	 */
    public int totalWaitingTime(){
        return customers.peek().getWaitingTime();
    }

    /***
	 * void method to add a customer to customers by using offer
	 * @param c a Customer representing the new Customer being added
	 * no return
	 */
    public void addCustomer(Customer c){
        customers.offer(c);
    }

    /***
	 * Method to check if customers is empty by checking size
	 * no param
	 * @return boolean -- true if customers is empty, false if not
	 */
    public boolean isEmpty(){
        return (size() == 0); 
    }

    /***
	 * method to return size of customers, by using Queue's size method
	 * no param
	 * @return int customers.size();
	 */
    public int size(){
        return customers.size(); 
    }

    /***
     * Method toString to return a formatted String of CustomerQueue information
     * no parameters
     * @return String of formatted CustomerQueue information 
     */
    @Override
    public String toString(){
        String out = "";
        for ( Customer c : customers ){
            out += c.toString() + "\n";
        }
        return out;
    }

}