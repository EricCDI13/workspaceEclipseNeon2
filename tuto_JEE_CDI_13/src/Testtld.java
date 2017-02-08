import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Testtld extends SimpleTagSupport {

	public Testtld() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		getJspContext().getOut().print("CoucouTesttld");
	}

}
