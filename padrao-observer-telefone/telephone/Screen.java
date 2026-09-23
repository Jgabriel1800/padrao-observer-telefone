/**
 * Prints things out to the screen, when needed
 * Printing to the screen:
 *  System.out.println("hello");
 */
public class Screen {
    private static final int PHONE_NUMBER_LENGTH = 12;

    private final PhoneModel model;

    public Screen(PhoneModel model) {
        this.model = model;

        // Observador 1: imprime o digito mais recente
        model.addObserver(digit -> System.out.println(digit));

        // Observador 2: quando o numero esta completo, mostra que esta discando
        model.addObserver(digit -> {
            if (model.getDigits().size() == PHONE_NUMBER_LENGTH) {
                System.out.println("Agora discando " + formatNumber() + "...");
            }
        });
    }

    private String formatNumber() {
        StringBuilder number = new StringBuilder();
        for (int d : model.getDigits()) {
            number.append(d);
        }
        return number.toString();
    }
}
