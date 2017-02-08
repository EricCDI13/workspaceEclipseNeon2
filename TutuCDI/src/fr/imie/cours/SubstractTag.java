package fr.imie.cours;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SubstractTag extends SimpleTagSupport {

	private Integer a;
	private Integer b;

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public Integer getB() {
		return b;
	}

	public void setB(Integer b) {
		this.b = b;
	}

	@Override
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().print(a - b);
		super.doTag();
	}

}
