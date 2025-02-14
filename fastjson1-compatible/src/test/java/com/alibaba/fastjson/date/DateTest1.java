package com.alibaba.fastjson.date;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wenshao on 16/8/23.
 */
public class DateTest1 {
    @Test
    public void test_date() throws Exception {
        Model model = new Model();
        model.date = new Date(1471939192128L);

        String text = JSON.toJSONString(model);
        Assert.assertEquals("{\"date\":1471939192128}", text);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", new Date(1471939192128L));

        String text2 = JSON.toJSONString(map);
        Assert.assertEquals("{\"date\":1471939192128}", text);
    }

    public static class Model {
        public Date date;
    }
}
