/**
 * 
 */
package fr.imie.cour;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author imiedev
 *
 */
public class SommesTag extends SimpleTagSupport {

	/**
	 * 
	 */
	public SommesTag() {
	}
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		getJspContext().getOut().print("CoucouSommeTag");
	}

}
