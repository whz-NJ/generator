package org.stathry.generator;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.stathry.generator.FieldGenerator;
import org.stathry.generator.util.ExcelUtils;

/**
 * TODO
 */
public class FieldBlockGeneratorTest {

    @Test
    public void test1() {
        List<Map<String, String>> fieldMaps = ExcelUtils.readToMap("D:\\doc\\temp.xlsx");
        String s = FieldGenerator.generateFieldBlocks(fieldMaps);
        System.out.println(s);
    }
    
    @Test
    public void testGenerateByStringArray() throws IOException {
        String s = "user_name,user_credentials_type,user_credentials_no,order_no,biz_type,order_status,create_amt,pay_month,gmt_ovd_date,overdue_cnt,overdue_amt,gmt_pay,memo";
        FieldGenerator.generateByStringArray(s, true);
    }
    
}
