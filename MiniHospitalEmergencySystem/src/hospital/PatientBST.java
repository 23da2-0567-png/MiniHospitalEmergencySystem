package hospital;

public class PatientBST {

    // Node class
    class Node {

        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
            left = null;
            right = null;
        }
    }

    Node root;

    // INSERT
    public void insert(Patient patient) {

        root = insertRecursive(root, patient);
    }

    private Node insertRecursive(Node root, Patient patient) {

        if (root == null) {
            return new Node(patient);
        }

        if (patient.patientId < root.patient.patientId) {

            root.left = insertRecursive(root.left, patient);

        } else if (patient.patientId > root.patient.patientId) {

            root.right = insertRecursive(root.right, patient);

        } else {

            System.out.println("Patient ID already exists.");
        }

        return root;
    }

    // SEARCH
    public Patient search(int patientId) {

        Node result = searchRecursive(root, patientId);

        if (result != null) {
            return result.patient;
        }

        return null;
    }

    private Node searchRecursive(Node root, int patientId) {

        if (root == null || root.patient.patientId == patientId) {
            return root;
        }

        if (patientId < root.patient.patientId) {
            return searchRecursive(root.left, patientId);
        }

        return searchRecursive(root.right, patientId);
    }

    // DELETE
    public void delete(int patientId) {

        if (search(patientId) == null) {

            System.out.println("Patient not found.");

        } else {

            root = deleteRecursive(root, patientId);

            System.out.println("Patient deleted successfully.");
        }
    }

    private Node deleteRecursive(Node root, int patientId) {

        if (root == null) {
            return null;
        }

        if (patientId < root.patient.patientId) {

            root.left = deleteRecursive(root.left, patientId);

        } else if (patientId > root.patient.patientId) {

            root.right = deleteRecursive(root.right, patientId);

        } else {

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Only right child
            if (root.left == null) {
                return root.right;
            }

            // Case 3: Only left child
            if (root.right == null) {
                return root.left;
            }

            // Case 4: Two children
            Node successor = findMinimum(root.right);

            root.patient = successor.patient;

            root.right = deleteRecursive(
                    root.right,
                    successor.patient.patientId
            );
        }

        return root;
    }

    // Find minimum node
    private Node findMinimum(Node root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // IN-ORDER TRAVERSAL
    public void inorder() {

        if (root == null) {

            System.out.println("No patients available.");

        } else {

            inorderRecursive(root);
        }
    }

    private void inorderRecursive(Node root) {

        if (root != null) {

            inorderRecursive(root.left);

            root.patient.displayPatient();

            inorderRecursive(root.right);
        }
    }
}