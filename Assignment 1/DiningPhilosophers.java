public class DiningPhilosophers {
//required arguments for DiningPhilosophers 

   private int np; //noOfPhilosophers
   private int nc; //noOfCycles
   private int tt; //thinkingTime
   private int et; //eatingTime
   private int rl; //rightLeftIndex

   //constructor for Dining Philosophers
   public DiningPhilosophers(int np, int nc, int tt, int et, int rl){
    this.np = np;
    this.nc = nc; 
    this.tt = tt; 
    this.et = et; 
    this.rl = rl;
   }

  public static void main(String[] args) throws InterruptedException {
   
    Philosopher[] philosophers = new Philosopher[5];
    Chopstick[] chopsticks = new Chopstick[5];
    DiningPhilosophers thePhilosophers = new DiningPhilosophers(5,2,8,12,0);
    //creating philosophers with a provided set of arguments 

    for (int i = 0; i < thePhilosophers.np; ++i)
      chopsticks[i] = new Chopstick(i);
    for (int i = 0; i < thePhilosophers.np; ++i) {
      philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i + 1) % 5], thePhilosophers.nc, thePhilosophers.tt, thePhilosophers.et, 
                                        thePhilosophers.rl, i);
                                        //initializing a philosopher with parameters to start the thought process and dining algorithms!
      philosophers[i].start();
    }
    for (int i = 0; i < 5; ++i)
      philosophers[i].join();
  }
}
