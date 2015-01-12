package madsn.framework_test.scrum_shuffle;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;

import madsn.framework_test.scrum_shuffle.models.Member;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
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
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		JPAContainer<Member> members = JPAContainerFactory.make(Member.class, "member");
		members.addEntity(new Member("Mikkel Madsen", "MIKMA"));
		
		Notification.show("Value is: " + members.firstItemId().toString());
		
		/*
		Button button = new Button("Click Me");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				layout.addComponent(new Label("Thank you for clicking"));
			}
		});
		layout.addComponent(button);
		*/
	}

}