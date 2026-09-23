/**
 * Observer: quem quiser saber quando um novo digito e inserido no telefone
 * implementa esta interface. O PhoneModel so conhece esta interface,
 * nunca a UI.
 */
public interface PhoneObserver {
    void onDigitAdded(int digit);
}
