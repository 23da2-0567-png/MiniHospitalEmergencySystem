package hospital;

public class VisitHistory {

    private Visit head;

    // ADD VISIT
    public void addVisit(Visit visit) {

        if (head == null) {

            head = visit;

        } else {

            Visit current = head;

            while (current.next != null) {

                current = current.next;
            }

            current.next = visit;
        }

        System.out.println("Visit added successfully.");
    }

    // REMOVE VISIT
    public void removeVisit(int visitId) {

        if (head == null) {

            System.out.println("Visit history is empty.");

            return;
        }

        // If first node needs to be removed
        if (head.visitId == visitId) {

            head = head.next;

            System.out.println("Visit removed successfully.");

            return;
        }

        Visit current = head;

        while (current.next != null) {

            if (current.next.visitId == visitId) {

                current.next = current.next.next;

                System.out.println("Visit removed successfully.");

                return;
            }

            current = current.next;
        }

        System.out.println("Visit not found.");
    }

    // SEARCH VISIT
    public Visit searchVisit(int visitId) {

        Visit current = head;

        while (current != null) {

            if (current.visitId == visitId) {

                return current;
            }

            current = current.next;
        }

        return null;
    }

    // DISPLAY VISIT HISTORY
    public void displayHistory() {

        if (head == null) {

            System.out.println("No visit history available.");

            return;
        }

        System.out.println("===== PATIENT VISIT HISTORY =====");

        Visit current = head;

        while (current != null) {

            current.displayVisit();

            current = current.next;
        }
    }
}