import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

class Philosopher extends Thread {
  private Chopstick left, right;
  private Random random;
  private int thinkCount;
  private int numCycles; // number of cycles ; condition if 0, number of cycles goes forever
  private int thinkingTime; //maximum thinking time in milliseconds 
  private int eatingTime; //maximum eating time  in milliseconds
  private int pID; //philosopherID unique to philosopher
  private int rightHandIndex; // condition if 0, all philosophers right handed + try grabbing right chopstick first ;; //condition if 1, even right handed + odd left handed 


  public Philosopher(Chopstick left, Chopstick right, int numCycles, int thinkingTime, int eatingTime, int rightHandIndex, int pID) {
    this.left = left; 
    this.right = right;
    random = new Random();
    
    this.numCycles = numCycles; 
    this.thinkingTime = thinkingTime; 
    this.eatingTime = eatingTime; 
    this.rightHandIndex = rightHandIndex;
    this.pID = pID; 
    

    if (numCycles == 0){
      thinkCount = Integer.MAX_VALUE; // condition for 0 cycle goes forever
    }
  }

  public void run() {
    String fileOutput = "Trace.txt";
    
    try {
      //Case A: rightHandIndex == 0, 
      //all philosophers are right handed 
      //try grabbing right chopsticks first

      if (this.rightHandIndex == 0){
        while (thinkCount < numCycles){
          ++thinkCount;
        }
        if (thinkCount % 10 == 0){
          System.out.println("Philosopher " + pID + " has thought " + thinkCount + " times");
          int tt = random.nextInt(this.thinkingTime);
          System.out.println("Philosopher " + pID + " thinks for " + thinkingTime + " units");
          Thread.sleep(thinkingTime); 
          
          // The philosopher thinks for the given designated time. 
          
          System.out.println("Philosopher" + pID + "wants right chopstick.");
          
          //The philosopher, since right handed first goes for right hand.
          synchronized(right){
            System.out.println("Philosopher" + pID + "has right chopstick.");
            System.out.println("Philosopher" + pID + "wants left chopstick.");
            synchronized(left){
              System.out.println("Philosopher" + pID + "has left chopstick.");
              int et = random.nextInt(eatingTime);
              System.out.println("Philosopher" + pID + "eats for" + et + "units." );
              
              //Once the philosopher has both the chopsticks, they are ready to start eating 
              Thread.sleep(eatingTime);
            }
            System.out.println("Philosopher" + pID + "releases left chopstick.");
          }
            System.out.println("Philosopher" + pID + "releases right chopstick.");
          }
        }


      // Case B: rightHandIndex == 1,
      // even number of philosophers are right handed 
      // odd number of philosophers are left handed  

      else{
        // Case B1: provided the philosopher is right handed, 
        // same as before 

        if (pID % 2 == 0 ){
          while (thinkCount < numCycles){
            ++thinkCount;
          }
          if (thinkCount % 10 == 0){
            System.out.println("Philosopher " + pID + " has thought " + thinkCount + " times");
            int tt = random.nextInt(thinkingTime);
            System.out.println("Philosopher " + pID + " thinks for " + thinkingTime + " units");
            Thread.sleep(thinkingTime); 
            
            // The philosopher thinks for the given designated time. 
            
            System.out.println("Philosopher" + pID + "wants right chopstick.");
            
            //The philosopher, since right handed first goes for right hand.
            synchronized(right){
              System.out.println("Philosopher" + this.pID + "has right chopstick.");
              System.out.println("Philosopher" + this.pID + "wants left chopstick.");
              synchronized(left){
                System.out.println("Philosopher" + this.pID + "has left chopstick.");
                int et = random.nextInt(eatingTime);
                System.out.println("Philosopher" + this.pID + "eats for" + eatingTime + "units." );
                
                //Once the philosopher has both the chopsticks, they are ready to start eating 
                Thread.sleep(eatingTime);
              }
              System.out.println("Philosopher" + this.pID + "releases left chopstick.");
            }
              System.out.println("Philosopher" + this.pID + "releases right chopstick.");
            }
        }

        // Case B2: provided the philosopher is left handed, 
        //grabs left chopstick first and then right chopstick

        else{
          while (thinkCount < numCycles){
            ++thinkCount;
          }
          if (thinkCount % 10 == 0){
            System.out.println("Philosopher " + pID + " has thought " + thinkCount + " times");
            int tt = random.nextInt(thinkingTime);
            System.out.println("Philosopher " + pID + " thinks for " + thinkingTime + " units");
            Thread.sleep(thinkingTime); 
            
            // The philosopher thinks for the given designated time. 
            
            System.out.println("Philosopher" + pID + "wants left chopstick.");
            
            //The philosopher, since left handed now, they first go for left hand chopstick.
            synchronized(left){
              System.out.println("Philosopher" + pID + "has left chopstick.");
              System.out.println("Philosopher" + pID + "wants right chopstick.");
              synchronized(right){
                System.out.println("Philosopher" + pID + "has right chopstick.");
                int et = random.nextInt(eatingTime);
                System.out.println("Philosopher" + pID + "eats for" + eatingTime + "units." );
                
                //Once the philosopher has both the chopsticks, they are ready to start eating 
                Thread.sleep(eatingTime);
              }
              System.out.println("Philosopher" + pID + "releases right chopstick.");
            }
              System.out.println("Philosopher" + pID + "releases left chopstick.");
            }
        }

      }
      }
    catch(InterruptedException e) {

    }

  }
}