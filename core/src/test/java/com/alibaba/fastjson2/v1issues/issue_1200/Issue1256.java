package com.alibaba.fastjson2.v1issues.issue_1200;

import com.alibaba.fastjson2.JSON;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by kimmking on 12/06/2017.
 */
public class Issue1256 {
    @Test
    public void test_for_issue() throws Exception {


        // params ={"key_obj":{"age":39,"name":"Mike"},"key_string":"Hello","key_random":-1193959466,"key_int":10000}

        A a = new A();
        a.name = "Mike";
        a.age = 39;

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("key_obj",a);
        map.put("key_string","Hello");
        map.put("key_random",-1193959466L);
        map.put("key_int",10000);

        String jsonString = JSON.toJSONString(map);
        assertTrue(jsonString.contains("Mike"));
    }

    public static class A {
        public String name;
        public int age;
    }
}
