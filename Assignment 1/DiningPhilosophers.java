public class DiningPhilosophers {

  public static void main(String[] args) throws InterruptedException {
   
    // arguments parsed through command line and its five arguments 
   int np = Integer.parseInt(args[0]); //noOfPhilosophers
   int nc = Integer.parseInt(args[1]); //noOfCycles
   int tt = Integer.parseInt(args(2)); //thinkingTime
   int et = Integer.parseInt(args[3]); //eatingTime
   int rl = Integer.parseInt(args[4]); //rightLeftIndex
   //int nf = np; //noOfForks = noOfPhilosophers

    Philosopher[] philosophers = new Philosopher[np];
    Chopstick[] chopsticks = new Chopstick[np];
    
    for (int i = 0; i < 5; ++i)
      chopsticks[i] = new Chopstick(i);
    for (int i = 0; i < 5; ++i) {
      philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i + 1) % 5]);
      philosophers[i].start();
    }
    for (int i = 0; i < 5; ++i)
      philosophers[i].join();
  }
}
