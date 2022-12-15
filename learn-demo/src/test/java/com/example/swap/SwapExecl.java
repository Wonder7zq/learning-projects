package com.example.swap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wonder7zq
 * @date 2022/7/26 - 14:46
 */
public class SwapExecl {

    /**
     * @Author zhangdapao
     * @Date 2021/7/28 16:46
     */
    public static void main(String[] args) {
        excelPOI();
    }

    public static void excelPOI() {
        try {
            String fileName = "G:\\swap\\字典映射替换清单2.xlsx";//修改f盘的.xlsx文件
            XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(fileName));
            Map<String, String> fields = new HashMap<String, String>();
            fields = getFieldMap();  //获取要修改字段的集合
            String fillStr = "";    //存储aaa文件里的数据
            String[] fillSplit = null;
            XSSFSheet xSheet = xwb.getSheetAt(0);  //获取excel表的第一个sheet
            for (int i = 0; i <= xSheet.getLastRowNum(); i++) {  //遍历所有的行
                if (xSheet.getRow(i) == null) { //这行为空执行下次循环
                    continue;
                }
                for (int j = 0; j <= xSheet.getRow(i).getPhysicalNumberOfCells(); j++) {  //遍历当前行的所有列
                    StringBuffer sb = new StringBuffer();
                    if (xSheet.getRow(i).getCell(j) == null) {//为空跳出循环
                        continue;
                    }
                    fillStr = (xSheet.getRow(i)).getCell(j).toString();//获取当前单元格的数据
                    fillSplit = fillStr.split(",");//切割，以","为分隔符的这个可以根据自己情况改变
                    XSSFCell xCell = xSheet.getRow(i).getCell(j); //获取单元格对象
                    String s = xCell.toString();
                    fillSplit = s.split(",");
                    for (int js = 0; js < fillSplit.length; js++) {
                        fillSplit[js] = (fields.get(fillSplit[js].trim()) == null ? fillSplit[js] : fields.get(fillSplit[js].trim()));
                        if (js + 1 == fillSplit.length) {
                            sb.append(fillSplit[js] + "。");
                        } else {
                            sb.append(fillSplit[js] + ",");
                        }
                    }
                    String s1 = sb.toString();
                    xCell.setCellValue(s1);
                }
                System.out.println("已经完成第" + (i + 1) + "列");
            }
            FileOutputStream out = new FileOutputStream(fileName);
            xwb.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<String, String> getFieldMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("interest", "profit");
        map.put("Interest", "Profit");
        map.put("INTEREST", "PROFIT");
        return map;
    }

}

