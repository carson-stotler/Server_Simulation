/***
 * @author Carson Stotler
 * @version 0.1
 * Date of Creation: Oct. 13, 2022
 * Last Date Modified: Oct. 18, 2022
 * Assignment: HW 4
 * Simulating a movie theater line with customers and servers
 */

import java.util.ArrayList;

public class ServerList{
    //data member
    private ArrayList<Server> list;

    /***
     * 1-arg Constuctor
     * @param servers int representing number of servers
     * Initializes list to be filled with "servers" amount of new servers
     */
    public ServerList(int servers){
        this.list = new ArrayList<Server>(servers);
        for ( int i = 0; i < servers; i++ ){
            Server serv = new Server();
            list.add(serv);
        }
    }

    /***
	 * Method to return index of the first free server -- -1 if all are busy
	 * no param
	 * @return int representing index of first free server
	 */
    public int getFreeServer(){
        for ( int i = 0; i < list.size(); i++ ){
            if ( list.get(i).isFree() ){
                return i;
            }
        }
        return -1;
    }

    /***
	 * void method to set a server to busy 
	 * @param i int index of server
     * @param c Customer of currentCustomer for the now Busy server
     * @param serviceTime int representing the new serviceTime for the server
	 * no return
	 */
    public void setServerBusy(int i, Customer c, int serviceTime){
        list.get(i).setCurrentCustomer(c);
        list.get(i).setServiceTime(serviceTime);
        
    }

    /***
	 * void method to update (decrement) service time for each busy server
	 * no param
	 * no return
	 */
    public void updateServiceTime(){
        // System.out.println("here");
        for ( int i = 0; i < list.size(); i++ ){
            if ( list.get(i).isFree() == false ){
                list.get(i).decrementServiceTime();
            }
        }
    }

    /***
	 * Method to return amount of busy servers in list
	 * no param
	 * @return int of amount of busy servers
	 */
    public int getBusyServers(){
        int count = 0;
        for ( int i = 0; i < list.size(); i++ ){
            if ( !list.get(i).isFree() ){
                count++;
            }
        }
        return count;
    }

    /***
     * Method toString to return a formatted String of ServerList information
     * no parameters
     * @return String of formatted ServerList information 
     */
    @Override
    public String toString(){
        String out = "";
        for ( Server s : list ){
            out += s.toString() + "\n";
        }
        return out;
    }
}