package hospital;

public class EmergencyQueue {

    private Patient[] queue;

    private int front;
    private int rear;
    private int size;

    private int capacity;

    public EmergencyQueue(int capacity) {

        this.capacity = capacity;

        queue = new Patient[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }

    // ENQUEUE
    public void enqueue(Patient patient) {

        if (size == capacity) {

            System.out.println("Queue is full.");

            return;
        }

        rear = (rear + 1) % capacity;

        queue[rear] = patient;

        size++;

        System.out.println(
                patient.patientName + " added to emergency queue."
        );
    }

    // DEQUEUE
    public Patient dequeue() {

        if (size == 0) {

            System.out.println("Queue is empty.");

            return null;
        }

        Patient patient = queue[front];

        queue[front] = null;

        front = (front + 1) % capacity;

        size--;

        return patient;
    }

    // DISPLAY QUEUE
    public void displayQueue() {

        if (size == 0) {

            System.out.println("Emergency queue is empty.");

            return;
        }

        System.out.println("===== EMERGENCY QUEUE =====");

        int index = front;

        for (int i = 0; i < size; i++) {

            queue[index].displayPatient();

            index = (index + 1) % capacity;
        }
    }
}