public class DiningPhilosophers {

  public static void main(String[] args) throws InterruptedException {
    //the idea is to take five arguments here as dining philosophers variables 
    //as specified in the question
    int np = Integer.parseInt(args[0]); //number of philosophers
    int nc = Integer.parseInt(args[1]); // number of cycles
    int tt = Integer.parseInt(args[2]); //maximum thinking time
    int et = Integer.parseInt(args[3]); //maximum eating time 
    int rl = Integer.parseInt(args[4]); //right hand left hand index

    Philosopher[] philosophers = new Philosopher[np];
    Chopstick[] chopsticks = new Chopstick[np];

    for (int i = 0; i < np; ++i)
      chopsticks[i] = new Chopstick(i);
    for (int i = 0; i < np; ++i) {
      philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i + 1) % np], tt, et, nc, i, rl);
                                        //initializing a philosopher with parameters to start the thought process and dining algorithms!
      philosophers[i].start();
    }
    for (int i = 0; i < 5; ++i)
      philosophers[i].join();
  }
}
