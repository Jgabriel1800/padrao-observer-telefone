import java.util.Random;

/**
 * Mimic the data input ability of a physical phone's keypad;
 * however, here we're just sending it fake digits.
 */
public class KeyPad {
    private final PhoneModel model;

    public KeyPad(PhoneModel model) {
        this.model = model;
    }

    public void simulateKeyPresses(int numKeyPresses) {
        final int NUM_POSSIBLE_DIGITS = 10; // digitos validos: 0 a 9
        Random rnd = new Random();
        for (int i = 0; i < numKeyPresses; i++) {
            int newDigit = rnd.nextInt(NUM_POSSIBLE_DIGITS);
            System.out.println("Pressionando: " + newDigit);
            model.addDigit(newDigit);
        }
    }

    /**
     * Simula o usuario digitando um numero especifico, tecla por tecla.
     * Usado para reproduzir a saida de exemplo do enunciado.
     */
    public void dial(String number) {
        for (char key : number.toCharArray()) {
            int digit = Character.getNumericValue(key);
            System.out.println("Pressionando: " + digit);
            model.addDigit(digit);
        }
    }
}
