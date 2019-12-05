package ua.training.model;

import ua.training.view.TextConstans;

public enum Bank implements TextConstans {
    PRIVAT_BANK(PRIVAT_NAME, 5000, 1.5, 12),
    OSHAD_BANK(OSHAD_NAME, 8000, 6.2, 24),
    AGRIKOL_BANK(AGRIKOL_NAME, 2000, 3.7, 6),
    RAYFAISEN_BANK(RAYFAISEN_NAME, 7000, 5.0, 60),
    UKRGAS_BANK(UKRGAS_NAME, 1000, 8.6, 24),
    UKRSIB_BANK(UKRSIB_NAME, 4500, 7.3, 36),
    MONO_BANK(MONO_NAME, 10000, 4.1, 18),
    PUMB(PUMB_NAME, 3800, 2.2, 36),
    SBER_BANK(SBER_NAME, 9000, 5.5, 60),
    MTB_BANK(MTB_NAME, 6000, 4.8, 6);

    private final String name;
    private final int loanAmount;
    private final double interestRate;
    private final int maxDuration;

    private Bank(String name, int loanAmount, double interestRate, int maxDuration) {
        this.name = name;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.maxDuration = maxDuration;

    }

    @Override
    public String toString() {
        return Bank.this.name() +": " +
                "maximum loan amount: " + loanAmount +
                ", interest rate: " + interestRate +
                ", maximum duration: " + maxDuration;
    }

}


