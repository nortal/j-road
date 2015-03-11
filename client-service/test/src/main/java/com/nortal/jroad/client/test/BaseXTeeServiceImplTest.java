package com.nortal.jroad.client.test;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.ContextConfiguration;

import com.nortal.jroad.model.XteeElement;

/**
 * Base class for all X-tee service implementation test classes.
 * 
 * @author Roman Tekhov
 * @author margush
 */
@ContextConfiguration(locations = { "classpath:client-test.xml" })
public abstract class BaseXTeeServiceImplTest extends AbstractJUnit4SpringContextTests {

	/**
	 * Checks interface XteeElement annotations<br>
	 * Every get method must have XteeElement annotation. The annotation title can not by empty and the sequence can not by negative
	 * @param obj
	 */
	protected void checkXteeAnnotation(final Class<?> obj){
		Assert.assertNotNull(obj);
		
		for(final Method method : obj.getDeclaredMethods()){
			final String methodName = method.getName();
			if(methodName.startsWith("get")){
				final XteeElement xteeElement = method.getAnnotation(XteeElement.class);
				
				Assert.assertFalse(obj.getName() + "#" + methodName + " has no annotation XteeElement", xteeElement == null);
				Assert.assertTrue(obj.getName() + "#" + methodName + " XteeElement title is empty", xteeElement.title() != null && xteeElement.title().trim().length() > 0);
				Assert.assertTrue(obj.getName() + "#" + methodName + " XteeElement sequence is negative or 0", xteeElement.sequence() > 0);
			}
		}		
	}
}
