import java.util.Random;

class Philosopher extends Thread {
  private Chopstick left, right;
  private Random random;
  private int thinkCount;
  public int numCycles; // number of cycles ; condition if 0, number of cycles goes forever
  public int thinkingTime; //maximum thinking time in milliseconds 
  public int eatingTime; //maximum eating time  in milliseconds
  public int philsopherID; //philosopherID unique to philosopher
  public int rightHandIndex; // condition if 0, all philosophers right handed + try grabbing right chopstick first ;; //condition if 1, even right handed + odd left handed 


  public Philosopher(Chopstick left, Chopstick right, int numCycles, int thinkingTime, int eatingTime, int philosopherID, int rightHandIndex) {
    this.left = left; 
    this.right = right;
    random = new Random();
    
    this.numCycles = numCycles; 
    this.thinkingTime = thinkingTime; 
    this.eatingTime = eatingTime; 
    this.philosopherID = philosopherID; 
    this.rightHandIndex = rightHandIndex;

    if (numCycles == 0){
      thinkCount = Integer.MAX_VALUE; // condition for 0 cycle goes forever
    }
  }

  public void run() {
    try {
      //Case A: rightHandIndex == 0, 
      //all philosophers are right handed 
      //try grabbing right chopsticks first

      if (this.rightHandIndex == 0){
        while (thinkCount < numCycles){
          ++thinkCount;
        }
        if (thinkCount % 10 == 0){
          System.out.println("Philosopher " + this.philosopherID + " has thought " + this.thinkCount + " times");
          int tt = nextInt(this.thinkingTime);
          System.out.println("Philosopher " + this.philosopherID + " thinks for " + tt + " units");
          Thread.sleep(tt); 
          
          // The philosopher thinks for the given designated time. 
          
          System.out.println("Philosopher" + this.philosopherID + "wants right chopstick.");
          
          //The philosopher, since right handed first goes for right hand.
          synchronized(right){
            System.out.println("Philosopher" + this.philosopherID + "has right chopstick.");
            System.out.println("Philosopher" + this.philosopherID + "wants left chopstick.");
            synchronized(left){
              System.out.println("Philosopher" + this.philosopherID + "has left chopstick.");
              int et = nextInt(eatingTime);
              System.out.println("Philosopher" + this.philosopherID + "eats for" + et + "units." );
              
              //Once the philosopher has both the chopsticks, they are ready to start eating 
              Thread.sleep(et);
            }
            System.out.println("Philosopher" + this.philosopherID + "releases left chopstick.");
          }
            System.out.println("Philosopher" + this.philosopherID + "releases right chopstick.");
          }
        }


      // Case B: rightHandIndex == 1,
      // even number of philosophers are right handed 
      // odd number of philosophers are left handed  

      else{
        // Case B1: provided the philosopher is right handed, 
        // same as before 

        if (philosopherID % 2 == 0 ){
          while (thinkCount < cycles){
            ++thinkCount;
          }
          if (thinkCount % 10 == 0){
            System.out.println("Philosopher " + this.philosopherID + " has thought " + this.thinkCount + " times");
            int tt = nextInt(thinkTime);
            System.out.println("Philosopher " + this.philosopherID + " thinks for " + tt + " units");
            Thread.sleep(tt); 
            
            // The philosopher thinks for the given designated time. 
            
            System.out.println("Philosopher" + this.philosopherID + "wants right chopstick.");
            
            //The philosopher, since right handed first goes for right hand.
            synchronized(right){
              System.out.println("Philosopher" + this.philosopherID + "has right chopstick.");
              System.out.println("Philosopher" + this.philosopherID + "wants left chopstick.");
              synchronized(left){
                System.out.println("Philosopher" + this.philosopherID + "has left chopstick.");
                int et = nextInt(eatingTime);
                System.out.println("Philosopher" + this.philosopherID + "eats for" + et + "units." );
                
                //Once the philosopher has both the chopsticks, they are ready to start eating 
                Thread.sleep(et);
              }
              System.out.println("Philosopher" + this.philosopherID + "releases left chopstick.");
            }
              System.out.println("Philosopher" + this.philosopherID + "releases right chopstick.");
            }
        }

        // Case B2: provided the philosopher is left handed, 
        //grabs left chopstick first and then right chopstick

        else{
          while (thinkCount < cycles){
            ++thinkCount;
          }
          if (thinkCount % 10 == 0){
            System.out.println("Philosopher " + this.philosopherID + " has thought " + thinkCount + " times");
            int tt = nextInt(thinkTime);
            System.out.println("Philosopher " + this.philosopherID + " thinks for " + tt + " units");
            Thread.sleep(tt); 
            
            // The philosopher thinks for the given designated time. 
            
            System.out.println("Philosopher" + this.philosopherID + "wants left chopstick.");
            
            //The philosopher, since left handed now, they first go for left hand chopstick.
            synchronized(left){
              System.out.println("Philosopher" + this.philosopherID + "has left chopstick.");
              System.out.println("Philosopher" + this.philosopherID + "wants right chopstick.");
              synchronized(right){
                System.out.println("Philosopher" + this.philosopherID + "has right chopstick.");
                int et = nextInt(eatingTime);
                System.out.println("Philosopher" + this.philosopherID + "eats for" + et + "units." );
                
                //Once the philosopher has both the chopsticks, they are ready to start eating 
                Thread.sleep(et);
              }
              System.out.println("Philosopher" + this.philosopherID + "releases right chopstick.");
            }
              System.out.println("Philosopher" + this.philosopherID + "releases left chopstick.");
            }
        }

      }
      }
    catch(InterruptedException e) {

    }
  }
}