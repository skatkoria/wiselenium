package org.wiselenium.core.element.field;

import static org.testng.Assert.assertEquals;
import static org.wiselenium.core.pagefactory.WisePageFactory.initElements;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.wiselenium.core.TestBase;

@SuppressWarnings("javadoc")
public class LabelTest extends TestBase {
	
	LabelPage page;
	
	
	@BeforeMethod
	public void initPage() {
		this.page = initElements(this.driver, LabelPage.class);
		this.page.get();
	}
	
	@Test
	public void shouldGetFor() {
		assertEquals(this.page.getLabel().getFor(), LabelPage.LABEL_FOR);
	}
	
	@Test
	public void shouldGetText() {
		assertEquals(this.page.getLabel().getText(), LabelPage.LABEL_TEXT);
	}
	
}
