package hospital;

public class Main {

    public static void main(String[] args) {

        // ==========================================
        // CREATE PATIENTS
        // ==========================================

        Patient p1 = new Patient(
                103,
                "Fathima",
                25,
                "0771234567",
                "Fever"
        );

        Patient p2 = new Patient(
                101,
                "Ahamed",
                30,
                "0712345678",
                "Headache"
        );

        Patient p3 = new Patient(
                105,
                "Sara",
                22,
                "0755555555",
                "Injury"
        );


        // ==========================================
        // 1. PATIENT BST
        // ==========================================

        System.out.println("\n=================================");
        System.out.println("       PATIENT BST");
        System.out.println("=================================");

        PatientBST patientBST = new PatientBST();

        // Insert
        patientBST.insert(p1);
        patientBST.insert(p2);
        patientBST.insert(p3);

        // Display
        System.out.println("\nAll Patients - Inorder:");

        patientBST.inorder();


        // Search
        System.out.println("\nSearching Patient ID 101:");

        Patient searchResult = patientBST.search(101);

        if (searchResult != null) {

            searchResult.displayPatient();

        } else {

            System.out.println("Patient not found.");
        }


        // Delete
        System.out.println("\nDeleting Patient ID 103:");

        patientBST.delete(103);

        System.out.println("\nPatients after deletion:");

        patientBST.inorder();


        // ==========================================
        // 2. EMERGENCY QUEUE
        // ==========================================

        System.out.println("\n=================================");
        System.out.println("       EMERGENCY QUEUE");
        System.out.println("=================================");

        EmergencyQueue emergencyQueue =
                new EmergencyQueue(10);

        // Enqueue
        emergencyQueue.enqueue(p1);
        emergencyQueue.enqueue(p2);
        emergencyQueue.enqueue(p3);

        // Display queue
        emergencyQueue.displayQueue();


        // Dequeue
        System.out.println("\nNext patient for treatment:");

        Patient nextPatient = emergencyQueue.dequeue();

        if (nextPatient != null) {

            nextPatient.displayPatient();
        }


        // Display remaining patients
        System.out.println("\nRemaining patients:");

        emergencyQueue.displayQueue();


        // ==========================================
        // 3. TREATMENT STACK
        // ==========================================

        System.out.println("\n=================================");
        System.out.println("       TREATMENT STACK");
        System.out.println("=================================");

        TreatmentStack treatmentStack =
                new TreatmentStack(10);

        // Push treatment records
        treatmentStack.push(
                "Patient 103 - Fever treatment completed"
        );

        treatmentStack.push(
                "Patient 101 - Headache treatment completed"
        );

        treatmentStack.push(
                "Patient 105 - Injury treatment completed"
        );

        // Display stack
        treatmentStack.displayStack();


        // Pop latest treatment
        System.out.println("\nRemoving latest treatment:");

        String removedTreatment =
                treatmentStack.pop();

        if (removedTreatment != null) {

            System.out.println(
                    "Removed: " + removedTreatment
            );
        }


        // Display remaining
        System.out.println("\nRemaining treatment records:");

        treatmentStack.displayStack();


        // ==========================================
        // 4. VISIT HISTORY
        // ==========================================

        System.out.println("\n=================================");
        System.out.println("       VISIT HISTORY");
        System.out.println("=================================");

        VisitHistory visitHistory =
                new VisitHistory();


        // Add visits
        Visit v1 = new Visit(
                1,
                "2026-08-01",
                "Dr. Kumar",
                "Fever",
                "Medication"
        );

        Visit v2 = new Visit(
                2,
                "2026-08-15",
                "Dr. Silva",
                "Headache",
                "Pain relief treatment"
        );

        Visit v3 = new Visit(
                3,
                "2026-09-01",
                "Dr. Perera",
                "Injury",
                "Wound treatment"
        );


        visitHistory.addVisit(v1);
        visitHistory.addVisit(v2);
        visitHistory.addVisit(v3);


        // Display
        System.out.println("\nAll Visits:");

        visitHistory.displayHistory();


        // Search visit
        System.out.println("\nSearching Visit ID 2:");

        Visit visitResult =
                visitHistory.searchVisit(2);

        if (visitResult != null) {

            visitResult.displayVisit();

        } else {

            System.out.println("Visit not found.");
        }


        // Remove visit
        System.out.println("\nRemoving Visit ID 2:");

        visitHistory.removeVisit(2);


        // Display after removal
        System.out.println("\nVisit history after removal:");

        visitHistory.displayHistory();


        // ==========================================
        // PROGRAM END
        // ==========================================

        System.out.println("\n=================================");
        System.out.println("      PROGRAM COMPLETED");
        System.out.println("=================================");
    }
}