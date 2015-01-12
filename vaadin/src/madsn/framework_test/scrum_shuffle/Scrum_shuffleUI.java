package madsn.framework_test.scrum_shuffle;

import javax.servlet.annotation.WebServlet;

import madsn.framework_test.scrum_shuffle.models.Member;
import madsn.framework_test.scrum_shuffle.models.MemberForm;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
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

		JPAContainer<Member> memberContainer = JPAContainerFactory.make(
				Member.class, "member");

		MemberForm form = new MemberForm(memberContainer);
		vlayout.addComponent(form);

	}
}