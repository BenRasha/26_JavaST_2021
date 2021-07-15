import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreImpl extends Thread {

    static final Logger semaphoreImplLogger = LogManager.getLogger(SemaphoreImpl.class.getName());

    int number;
    int id;
    Semaphore sem;
    int counter;
    Matrix matrix;

    SemaphoreImpl(Semaphore sem, int id, Matrix matrix) {
        this.sem = sem;
        this.matrix = matrix;
        this.id = id;
        this.number = 1 + new Random().nextInt(10);
        this.counter = this.id;
    }

    public void changeElement(Matrix matrix) throws MatrixException, InterruptedException {
        int size = matrix.getHorizontalSize();
        while (this.counter < size) {
            if (matrix.getValue(this.counter, this.counter) == 0) {
                System.out.println("Thread " + id + " trying to change matrix [" + (this.counter + 1) + "]["
                + (this.counter + 1) + "]");
                System.out.println("[" + (this.counter + 1) + "][" + (this.counter + 1) + "] has been set to " + number);
                matrix.setValue(this.counter, this.counter, number);
                TimeUnit.MILLISECONDS.sleep(500);
            } else {
                break;
            }
            this.counter++;
        }
    }

    @Override
    public void run() {
        try {
            sem.acquire();
            changeElement(matrix);
            sem.release();
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (MatrixException exception) {
            semaphoreImplLogger.error("Error during getting or setting value", exception);
        }
    }
}
