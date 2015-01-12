package madsn.framework_test.scrum_shuffle;

import javax.servlet.annotation.WebServlet;

import madsn.framework_test.scrum_shuffle.models.Member;
import madsn.framework_test.scrum_shuffle.models.MemberForm;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("scrum_shuffle")
public class Scrum_shuffleUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Scrum_shuffleUI.class)
	public static class Servlet extends VaadinServlet {

	}

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout vlayout = new VerticalLayout();
		setContent(vlayout);
		
		BeanItemContainer<Member> members = new BeanItemContainer<Member>(Member.class);
		
		MemberForm form = new MemberForm(members);
		vlayout.addComponent(form);
		
	}
}