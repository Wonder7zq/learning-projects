package com.example.demo1;

/**
 * @author Wonder7zq
 * @date 2022/8/9 - 13:58
 */
public class LoanBillDetial {
    String billAmtType;
    String loanNo;
    String custNo;

    public LoanBillDetial(){

    }

    public LoanBillDetial(String billAmtType, String loanNo, String custNo) {
        this.billAmtType = billAmtType;
        this.loanNo = loanNo;
        this.custNo = custNo;
    }

    public String getBillAmtType() {
        return billAmtType;
    }

    public String getLoanNo() {
        return loanNo;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setBillAmtType(String billAmtType) {
        this.billAmtType = billAmtType;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }
}
