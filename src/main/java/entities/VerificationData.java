package entities;

public class VerificationData {
    private final String verificationValue;
    private final String verificationDescription;
    private final int verificationCounter;

    public VerificationData(String verificationValue, String verificationDescription, int verificationCounter) {
        this.verificationValue = verificationValue;
        this.verificationDescription = verificationDescription;
        this.verificationCounter = verificationCounter;
    }

    public String getVerificationValue() {
        return verificationValue;
    }

    public String getVerificationDescription() {
        return verificationDescription;
    }

    public int getVerificationCounter() {
        return verificationCounter;
    }
}
