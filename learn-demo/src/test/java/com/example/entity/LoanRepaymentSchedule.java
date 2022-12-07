package com.example.entity;

import java.math.BigDecimal;

/**
 * @author Wonder7zq
 * @date 2022/11/7 - 14:19
 */
public class LoanRepaymentSchedule {
    String loan_no;
    String serial_no;
    BigDecimal installment;
    BigDecimal period_interest;
    BigDecimal rate;

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {

        this.rate = rate;
    }

    public LoanRepaymentSchedule() {
    }

    public void setLoan_no(String loan_no) {
        this.loan_no = loan_no;
    }

    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }

    public void setInstallment(BigDecimal installment) {
        this.installment = installment;
    }

    public void setPeriod_interest(BigDecimal period_interest) {
        this.period_interest = period_interest;
    }

    public String getLoan_no() {
        return loan_no;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public BigDecimal getInstallment() {
        return installment;
    }

    public BigDecimal getPeriod_interest() {
        return period_interest;
    }
}
