package hospital;

public class TreatmentStack {

    private String[] stack;

    private int top;

    private int capacity;

    public TreatmentStack(int capacity) {

        this.capacity = capacity;

        stack = new String[capacity];

        top = -1;
    }

    // PUSH
    public void push(String treatmentRecord) {

        if (top == capacity - 1) {

            System.out.println("Treatment stack is full.");

            return;
        }

        top++;

        stack[top] = treatmentRecord;

        System.out.println("Treatment record added.");
    }

    // POP
    public String pop() {

        if (top == -1) {

            System.out.println("Treatment stack is empty.");

            return null;
        }

        String record = stack[top];

        stack[top] = null;

        top--;

        return record;
    }

    // DISPLAY
    public void displayStack() {

        if (top == -1) {

            System.out.println("Treatment stack is empty.");

            return;
        }

        System.out.println("===== TREATMENT HISTORY =====");

        for (int i = top; i >= 0; i--) {

            System.out.println(stack[i]);
            System.out.println("----------------------------");
        }
    }
}