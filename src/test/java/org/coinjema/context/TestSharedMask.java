package org.coinjema.context;

import org.coinjema.nontest.AdvancedContextObject;
import org.coinjema.nontest.StaticDynamic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class TestSharedMask extends AbstractContextTester {


    @Test
    public void testSharedMask() throws Exception {
        AdvancedContextObject bc = new AdvancedContextObject(new CoinjemaContext("masking/submasking"));
        AdvancedContextObject bc2 = new AdvancedContextObject(new CoinjemaContext("masking"));
        System.out.println(bc.getDynamicProperties());
        System.out.println(bc2.getDynamicProperties());
        assertFalse(bc2.getDynamicProperties().getProperty("value").equals(bc.getDynamicProperties().getProperty("value")));
    }

    @Test
    public void testAnnotationEquality() throws Exception {
        AdvancedContextObject bc = new AdvancedContextObject(new CoinjemaContext("masking/submasking"));
        System.out.println(bc.getStaticDynamicName());
        System.out.println(new StaticDynamic().getName());
    }

}
