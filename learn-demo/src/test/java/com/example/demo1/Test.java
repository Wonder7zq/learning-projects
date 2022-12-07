package com.example.demo1;

import com.example.entity.LoanRepaymentSchedule;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Wonder7zq
 * @date 2022/4/6 - 14:13
 */
public class Test {

    public static void main(String[] args) {
//        calenderFormat();
//        listStreamEdit();
//        bigDecimalEdit();
        collectionEdit();
    }

    /*
     * yMdHmswW分别代表年月日时分秒星期周
     *
     */

    /**
     *
     */
    public static void calenderFormat() {

        Calendar beforeCalendar = Calendar.getInstance();
        beforeCalendar.add(Calendar.MINUTE, -5);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(beforeCalendar.getTime()));
    }

    /*
     *Function.identity()返回一个输出跟输入一样的Lambda表达式对象，等价于形如t -> t形式的Lambda表达式
     *
     *
     */
    private final static String FEE = "FEE";
    private final static String CURRENT = "CURRENT";

    public static void listStreamEdit() {
        LoanBillDetial l1 = new LoanBillDetial(FEE, "12321", "12321");
        LoanBillDetial l2 = new LoanBillDetial(FEE, "12322", "12322");
        LoanBillDetial l3 = new LoanBillDetial(CURRENT, "12323", "12323");
        LoanBillDetial l4 = new LoanBillDetial(CURRENT, "12324", "12324");

        List<LoanBillDetial> listBillDetail = new ArrayList();
        listBillDetail.add(l1);
        listBillDetail.add(l2);
        listBillDetail.add(l3);
        listBillDetail.add(l4);
//        Map<E_BILLAMOUNTTYPE, List<lnb_bill_detail>> billDetailGroupByAmtType = listBillDetail.stream().collect(Collectors.groupingBy(lnb_bill_detail::getBill_amt_type));
        Map<String, List<LoanBillDetial>> billDetailGroupByAmtType = listBillDetail.stream().collect(Collectors.groupingBy(LoanBillDetial::getBillAmtType));

        System.out.println(billDetailGroupByAmtType);
        System.out.println(listBillDetail.stream().collect(Collectors.toMap(Function.identity(), LoanBillDetial::getBillAmtType)));

    }


    /** 
     *lamda遍历list操作
     * @author Wonder7zq
     * @date 2022/11/7 14:15
     */
    public static void listNumberEdit() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "102a", "102", "101", "101b");
        list.forEach(s -> {
            //判断是否是数字
//            if (s.matches("-?\\d+(\\.\\d+)?")) {
//                System.out.println(s);
//            }
            //判断是否是数字
            if (s.matches("^[0-9]*$")) {
                System.out.println(s);
            } else {
                System.out.println(s.toUpperCase());
            }
        });

//        list.forEach(System.out::println);
        list.forEach(s -> System.out.println(s.toUpperCase()));

        System.out.println(list);
    }
    
    /**
     *BigDecimal方法测试
     * @author Wonder7zq
     * @date 2022/11/7 14:06
     * @return String
     */
    public static String bigDecimalEdit(){
        BigDecimal a = new BigDecimal(120);
        BigDecimal b = new BigDecimal(0);
//        BigDecimal c = a.divide(b,4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));

        Boolean d = b.compareTo(BigDecimal.ZERO) > 0 ;
        System.out.println(d);
        return d.toString();
    }
    
    /** 
     * 
     * @author Wonder7zq
     * @date 2022/11/10 16:09
     */
    
    private static void collectionEdit(){
        List<LoanRepaymentSchedule> l1 = new ArrayList<>();

         for(int i=0;i<5;i++){
             LoanRepaymentSchedule loanRpmtScheList = new LoanRepaymentSchedule();
            loanRpmtScheList.setLoan_no("0000100"+i);
            loanRpmtScheList.setSerial_no(String.valueOf(i));
            loanRpmtScheList.setInstallment(new BigDecimal("10010"));
            loanRpmtScheList.setPeriod_interest(new BigDecimal(50).add(new BigDecimal(10).multiply(BigDecimal.valueOf(5-i))));
            l1.add(loanRpmtScheList);
        }

        // 累加
        BigDecimal totalInstAmt = l1.stream().map(LoanRepaymentSchedule::getInstallment).reduce(BigDecimal.ZERO,BigDecimal::add);

        l1.forEach(l ->{
            l.setRate(l.getPeriod_interest().divide(l.getInstallment(),10,BigDecimal.ROUND_HALF_UP));
        } );

        System.out.println(l1);
    }
}
