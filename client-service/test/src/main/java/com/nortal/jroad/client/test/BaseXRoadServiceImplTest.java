package com.nortal.jroad.client.test;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.ContextConfiguration;

import com.nortal.jroad.model.XRoadElement;

/**
 * Base class for all X-road service implementation test classes.
 * 
 * @author Roman Tekhov
 * @author margush
 */
@ContextConfiguration(locations = { "classpath:client-test-common.xml" })
public abstract class BaseXRoadServiceImplTest extends AbstractJUnit4SpringContextTests {

	/**
	 * Checks interface XRoadElement annotations<br>
	 * Every get method must have XRoadElement annotation. The annotation title can not by empty and the sequence can not by negative
	 * @param obj
	 */
	protected void checkXRoadAnnotation(final Class<?> obj){
		Assert.assertNotNull(obj);
		
		for(final Method method : obj.getDeclaredMethods()){
			final String methodName = method.getName();
			if(methodName.startsWith("get")){
				final XRoadElement xroadElement = method.getAnnotation(XRoadElement.class);
				
				Assert.assertFalse(obj.getName() + "#" + methodName + " has no annotation XRoadElement", xroadElement == null);
				Assert.assertTrue(obj.getName() + "#" + methodName + " XRoadElement title is empty", xroadElement.title() != null && xroadElement.title().trim().length() > 0);
				Assert.assertTrue(obj.getName() + "#" + methodName + " XRoadElement sequence is negative or 0", xroadElement.sequence() > 0);
			}
		}		
	}
}
