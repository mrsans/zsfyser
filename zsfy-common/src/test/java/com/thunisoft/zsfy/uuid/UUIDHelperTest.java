package com.thunisoft.zsfy.uuid;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @Author ZhPJ
 * @Date 2019/1/16 001614:46
 * @Version 1.0
 * @Description:
 */
public class UUIDHelperTest {

    private List<Integer> numList;

    @Before
    public void beforeTest() {
        this.numList = Arrays.asList(-2, -1, 0, 1, 2, 3, 31, 32, 33, 35, 36, 37);
    }

    @Test
    public void getUUIDHasDivider() {
        for (int num : numList) {
            final String uuidHasDivider = UUIDHelper.getUUIDHasDivider(num);
            final boolean flag = num == uuidHasDivider.length() || uuidHasDivider.length() == 36;
            assertTrue("测试uuid长度不正确", flag);
        }
    }

    @Test
    public void getUUIDNoDivider() {
        for (int num : numList) {
            final String uuidHasDivider = UUIDHelper.getUUIDNoDivider(num);
            final boolean flag = num == uuidHasDivider.length() || uuidHasDivider.length() == 32;
            assertTrue("测试uuid长度不正确", flag);
        }
    }
}