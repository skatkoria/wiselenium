package org.wiselenium.core;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.openqa.selenium.WebDriver;

/**
 * The wiselenium proxy for pages.
 * 
 * @author Andre Ricardo Schaffer
 * @since 0.0.1
 */
final class WisePageProxy implements MethodInterceptor {
	
	private static final String GET_WRAPPED_DRIVER = "getWrappedDriver";
	private final WebDriver driver;
	
	
	private WisePageProxy(WebDriver driver) {
		this.driver = driver;
	}
	
	static WisePageProxy getInstance(WebDriver driver) {
		return new WisePageProxy(driver);
	}
	
	private static boolean isGetWrappedDriver(Method method) {
		return GET_WRAPPED_DRIVER.equals(method.getName());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
		throws Throwable { // NOSONAR because it's an overriden method
	
		if (isGetWrappedDriver(method)) return this.driver;
		return proxy.invokeSuper(obj, args);
	}
	
}