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
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("scrum_shuffle")
public class Scrum_shuffleUI extends UI {
	
	JPAContainer<Member> memberContainer;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Scrum_shuffleUI.class)
	public static class Servlet extends VaadinServlet {

	}

	@Override
	protected void init(VaadinRequest request) {
		HorizontalLayout hlayout = new HorizontalLayout();
		setContent(hlayout);

		memberContainer = JPAContainerFactory.make(
				Member.class, "member");

		MemberForm form = new MemberForm(memberContainer);
		hlayout.addComponent(form);
		
		VerticalLayout memberList = buildMemberList();
		hlayout.addComponent(memberList);
		hlayout.setComponentAlignment(memberList, Alignment.MIDDLE_CENTER);
		hlayout.setComponentAlignment(form, Alignment.MIDDLE_LEFT);
	}
	
	private VerticalLayout buildMemberList(){
		VerticalLayout vlayout = new VerticalLayout();
		Label title = new Label("Members:");
		title.setStyleName("h1");;
		vlayout.addComponent(title);
		for (Object m : memberContainer.getItemIds(0, memberContainer.size())){
			Label l = new Label(memberContainer.getItem(m).getEntity().toString()); 
			vlayout.addComponent(l);
		}
		vlayout.setMargin(true);
		return vlayout;
	}
}