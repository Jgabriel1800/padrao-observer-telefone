import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Store a phone number, digit-by-digit
 */
public class PhoneModel {
    private final List<Integer> digits = new ArrayList<>();
    private final List<PhoneObserver> observers = new ArrayList<>();

    public void addObserver(PhoneObserver observer) {
        observers.add(observer);
    }

    public void addDigit(int newDigit) {
        digits.add(newDigit);
        notifyObservers(newDigit);
    }

    // Visao somente-leitura: observadores podem consultar, mas nao alterar o numero
    public List<Integer> getDigits() {
        return Collections.unmodifiableList(digits);
    }

    // O modelo avisa "alguem" (PhoneObserver) sem saber quem e: nao conhece a Screen
    private void notifyObservers(int newDigit) {
        for (PhoneObserver observer : observers) {
            observer.onDigitAdded(newDigit);
        }
    }
}
