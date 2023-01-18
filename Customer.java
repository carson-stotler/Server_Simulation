/***
 * @author Carson Stotler
 * @version 0.1
 * Date of Creation: Oct. 13, 2022
 * Last Date Modified: Oct. 18, 2022
 * Assignment: HW 4
 * Simulating a movie theater line with customers and servers
 */

public class Customer {
    // data members
    private int customerNo;
    private int arrivalTime;
    private int waitingTime;

    /***
     * 3-arg Constuctor
     * @param cn int representing the customerNo
     * @param at int representing the arrivalTime of customer
     * @param wt int representing the waitingTime of customer
     * initializes all data members to the local variables, respectively
     */
    public Customer(int cn, int at, int wt){
        this.customerNo = cn;
        this.arrivalTime = at;
        this.waitingTime = wt;
    }

    /***
	 * Getter for the customer number
	 * @param	no parameters
	 * @return	the value of the data member customerNo
	 */
    public int getCustomerNo(){
        return customerNo;
    }

    /***
	 * Getter for the arrival time of a customer
	 * @param	no parameters
	 * @return	the value of the data member arrivalTime
	 */
    public int getArrivalTime(){
        return arrivalTime;
    }

    /***
	 * Getter for the waiting time of a customer
	 * @param	no parameters
	 * @return	the value of the data member waitingTime
	 */
    public int getWaitingTime(){
        return waitingTime;
    }

    /***
	 * Setter for the customer number
	 * @param	cn int representing a customer's number
	 * no return
	 */
    public void setCustomerNo(int cn){
        this.customerNo = cn;
    }

    /***
	 * Setter for the customer arrival time
	 * @param	at int representing a customer's arrival time
	 * no return
	 */
    public void setArrivalTime(int at){
        this.arrivalTime = at;
    }

    /***
	 * Setter for the customer waiting time
	 * @param	wt int representing a customer's waiting time
	 * no return
	 */
    public void setWaitingTime(int wt){
        this.waitingTime = wt;
    }

    /***
	 * Void method to increment waiting time for a customer
	 * no param
	 * no return
	 */
    public void incrementWaitingTime(){
        setWaitingTime(getWaitingTime() + 1);
    }

    /***
     * Method toString to return a formatted String of Customer information
     * no parameters
     * @return String of formatted customer information 
     */
    @Override
    public String toString(){
        String out = "";
        out += "Customer number " + (getCustomerNo() + 1) + " arrived at time " + getArrivalTime() ;
        return out;
    }
}