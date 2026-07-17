public class FizzBuzz {

    private int n;
    private int current;

    private Semaphore number = new Semaphore(1);
    private Semaphore fizz = new Semaphore(0);
    private Semaphore buzz = new Semaphore(0);
    private Semaphore fizzBuzz = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
        current = 1;
    }

    private void next() {

        current++;

        if (current > n) {
            number.release();
            fizz.release();
            buzz.release();
            fizzBuzz.release();
            return;
        }

        if (current % 15 == 0) {
            fizzBuzz.release();
        } else if (current % 3 == 0) {
            fizz.release();
        } else if (current % 5 == 0) {
            buzz.release();
        } else {
            number.release();
        }
    }

    public void fizz(Runnable printFizz) throws InterruptedException {

        while (true) {
            fizz.acquire();

            if (current > n) {
                break;
            }

            printFizz.run();
            next();
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {

        while (true) {
            buzz.acquire();

            if (current > n) {
                break;
            }

            printBuzz.run();
            next();
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

        while (true) {
            fizzBuzz.acquire();

            if (current > n) {
                break;
            }

            printFizzBuzz.run();
            next();
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {

        while (true) {
            number.acquire();

            if (current > n) {
                break;
            }

            printNumber.accept(current);
            next();
        }
    }
}