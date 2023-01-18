/***
 * @author Carson Stotler
 * @version 0.1
 * Date of Creation: Oct. 13, 2022
 * Last Date Modified: Oct. 18, 2022
 * Assignment: HW 4
 * Simulating a movie theater line with customers and servers
 */

public class Server {
    // data members
    private Customer currentCustomer;
    private boolean status;
    private int serviceTime;

    /***
     * no-arg Constuctor
     * no paramateres
     * Initializes status to be true, and servicTime to be 0
     */
    public Server(){
        this.currentCustomer = null;
        this.status = true;
        this.serviceTime = 0;
    }

    /***
	 * boolean method to see if a server is free
	 * no param
	 * @return boolean - true if free, false if busy
	 */
    public boolean isFree(){
        if ( serviceTime == 0){
            setFree();
            return true;
        } else {
            setBusy();
            return false;
            }
    }

    /***
	 * void method to set a server busy -- set status to false
	 * no param
	 * no return
	 */
    public void setBusy(){
        this.status = false;
    }

    /***
	 * void method to set a server free -- set status to true
	 * no param
	 * no return
	 */
    public void setFree(){
        this.status = true;
    }

    /***
	 * Getter for the service time of a server
	 * no parameters
	 * @return	the value of the data member serviceTime
	 */
    public int getServiceTime(){
        return this.serviceTime;
    }

    /***
	 * Setter for the server's service time
	 * @param	sTime int representing a server's service time
	 * no return
	 */
    public void setServiceTime(int sTime){
        this.serviceTime = sTime;
    }

    /***
	 * void method to set a decrement service time by 1 for a server
	 * no param
	 * no return
	 */
    public void decrementServiceTime(){
        this.serviceTime = getServiceTime() - 1;
    }

    /***
	 * Setter for the server's current customer
	 * @param	c Customer representing a server's current customer
	 * no return
	 */
    public void setCurrentCustomer(Customer c){
        this.currentCustomer = c;
    }

    /***
	 * Getter for the current customer of a server
	 * no parameters
	 * @return	the value of the data member currentCustomer
	 */
    public Customer getCurrentCustomer(){
        return this.currentCustomer;
    }

    /***
     * Method toString to return a formatted String of Server information
     * no parameters
     * @return String of formatted Server information 
     */
    @Override
    public String toString(){
        String out = "";
        String freeBus = ";=";
        if ( status == true ){
            freeBus = "Free";
        } else { freeBus = "Busy"; }

        out += "Server is " + freeBus + ", and its Current Customer is " + getCurrentCustomer();
        return out;
    }
}