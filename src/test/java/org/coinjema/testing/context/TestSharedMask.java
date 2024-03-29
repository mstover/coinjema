package org.coinjema.testing.context;

import org.coinjema.cjm.CjmContext;
import org.coinjema.testing.nontest.AdvancedContextObject;
import org.coinjema.testing.nontest.StaticDynamic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class TestSharedMask extends AbstractContextTester {


    @Test
    public void testSharedMask() throws Exception {
        AdvancedContextObject bc = new AdvancedContextObject(new CjmContext("masking/submasking"));
        AdvancedContextObject bc2 = new AdvancedContextObject(new CjmContext("masking"));
        System.out.println(bc.getDynamicProperties());
        System.out.println(bc2.getDynamicProperties());
        assertFalse(bc2.getDynamicProperties().getProperty("value").equals(bc.getDynamicProperties().getProperty("value")));
    }

    @Test
    public void testAnnotationEquality() throws Exception {
        AdvancedContextObject bc = new AdvancedContextObject(new CjmContext("masking/submasking"));
        System.out.println(bc.getStaticDynamicName());
        System.out.println(new StaticDynamic().getName());
    }

}
