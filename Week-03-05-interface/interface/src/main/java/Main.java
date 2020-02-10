import transport.Aircraft;
import transport.Bus;
import transport.Car;
import transport.Train;
import transport.Transportation;

public class Main {
  public static void main(String[] args) {
    int totalMoney = 300;

    Transportation aircraft = new Aircraft();
    Transportation train = new Train();
    Transportation car = new Car();
    Transportation bus = new Bus();

    System.out.printf("Xiao Ming %s choose aircraft.\n", aircraft.isEnough(totalMoney) ? "can" : "cannot");
    System.out.printf("Xiao Ming %s choose train.\n", train.isEnough(totalMoney) ? "can" : "cannot");
    System.out.printf("Xiao Ming %s choose car.\n", car.isEnough(totalMoney) ? "can" : "cannot");
    System.out.printf("Xiao Ming %s choose bus.\n", bus.isEnough(totalMoney) ? "can" : "cannot");
  }
}
