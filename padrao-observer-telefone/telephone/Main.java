
public class Main {
    public static void main(String[] args) {
        final String PHONE_NUMBER = "081999887766";

        // Build the object graph
        PhoneModel model = new PhoneModel();
        Screen screen = new Screen(model);
        KeyPad keyPad = new KeyPad(model);

        // Run the program
        keyPad.dial(PHONE_NUMBER);
        // Alternativa com digitos aleatorios: keyPad.simulateKeyPresses(12);
    }
}
