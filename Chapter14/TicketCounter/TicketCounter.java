import java.util.*;
import jsjf.QueueADT;
import jsjf.CircularArrayQueue;

/**
 * TicketCounter demonstrates the use of a queue for simulating a line of customers.
 *
 * @author Xiaomeng Cao
 * @version 4.0
 */
public class TicketCounter    
{
    private final static int PROCESS = 120;
    private final static int MAX_CASHIERS = 10;
    private final static int NUM_CUSTOMERS = 100;

    public static void main(String[] args) 
    {
        // create customer instantiation, customerQueue, cashier times, 
        // total time, average time, departure time and starting time.
        Customer customer;
        CircularArrayQueue<Customer> customerQueue = new CircularArrayQueue<Customer>();
        int[] cashierTime = new int[MAX_CASHIERS];	
        int totalTime, averageTime, departs, start;

        // run the simulation for various number of cashiers 
        for (int cashiers = 0; cashiers < MAX_CASHIERS; cashiers++)
        { 
            // set each cashiers time to zero initially
            for (int count = 0; count < cashiers; count++)
                cashierTime[count] = 0;

            // load customer queue 
            for (int count = 1; count <= NUM_CUSTOMERS; count++)
                customerQueue.enqueue(new Customer(count * 15));

            totalTime = 0;

            // process all customers in the queue until the queue is empty
            while (!(customerQueue.isEmpty())) 
            {
                // start with 1 cashier and increment by 1 each time through this for loop
                for (int count = 0; count <= cashiers; count++)
                {
                    // if the queue is not empty
                    if (!(customerQueue.isEmpty()))
                    {
                        // remove a customer from the front of the queue
                        customer = customerQueue.dequeue();
                        
                        // determine the starting time for each customer by choosing
                        // the current time:  customer's time or cashier's time.
                        if (customer.getArrivalTime() > cashierTime[count])
						    start = customer.getArrivalTime();
                        else
                            start = cashierTime[count]; 
                            
                        // add the processing time to the starting time
                        departs = start + PROCESS;
						
                        // create the departure time for the customer
                        customer.setDepartureTime(departs);
					    
                        // create the cashier's time
                        cashierTime[count] = departs;
                        
                        // update the total time
                        totalTime += customer.totalTime();
                    }
                }
            }

            // output results for this simulation 
            averageTime = totalTime / NUM_CUSTOMERS;
            System.out.println("Number of cashiers: " + (cashiers + 1));
            System.out.println("Average time: " + averageTime + "\n");
        }
    }
}

/*
Number of cashiers: 1
Average time: 5317

Number of cashiers: 2
Average time: 2325

Number of cashiers: 3
Average time: 1332

Number of cashiers: 4
Average time: 840

Number of cashiers: 5
Average time: 547

Number of cashiers: 6
Average time: 355

Number of cashiers: 7
Average time: 219

Number of cashiers: 8
Average time: 120

Number of cashiers: 9
Average time: 120

Number of cashiers: 10
Average time: 120
*/