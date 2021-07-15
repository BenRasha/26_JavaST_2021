import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockerImpl implements Runnable {

    Random random = new Random();
    int number;
    ReentrantLock locker;
    Matrix matrix;
    Map<Integer, Integer> indexes;

    LockerImpl(ReentrantLock lock, Matrix matrix, Map<Integer, Integer> indexes) {
        locker = lock;
        this.matrix = matrix;
        this.number = 1 + random.nextInt(10);
        this.indexes = indexes;
    }

    @Override
    public void run() {
        locker.lock();
        int index;
        try {
            index = getRandomIndex();
            matrix.setValue(index, index, number);
            System.out.println(Thread.currentThread().getName() + " has set ["
            + index + "][" + index +  "] to " + number);
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        } catch (MatrixException exception) {
            exception.printStackTrace();
        } finally {
            locker.unlock();
        }
    }

    private int getRandomIndex() {
        int index;
        int randomNumber;
        while (true) {
            randomNumber = random.nextInt(10);
            if (indexes.containsValue(randomNumber)) {
                index = indexes.get(randomNumber);
                indexes.remove(randomNumber);
                break;
            }
        }
        indexes.remove(randomNumber);
        return index;
    }
}
