package madsn.framework_test.scrum_shuffle;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;

import madsn.framework_test.scrum_shuffle.models.Member;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.addon.jpacontainer.fieldfactory.FieldFactory;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Item;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Form;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import org.h2.tools.Server;

@SuppressWarnings("serial")
@Theme("scrum_shuffle")
public class Scrum_shuffleUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Scrum_shuffleUI.class)
	public static class Servlet extends VaadinServlet {

	}

	@SuppressWarnings("deprecation")
	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		JPAContainer<Member> members = JPAContainerFactory.make(Member.class,
				"member");
		
		final Form memberForm = new Form();
		memberForm.setCaption("Create new member");
		memberForm.addStyleName("bordered");
		memberForm.setWidth("420px");
		memberForm.setBuffered(true);

		final FieldFactory fieldFactory = new FieldFactory();
		memberForm.setFormFieldFactory(fieldFactory);
		
		BeanItem<Member> item = new BeanItem<Member>(new Member());
		memberForm.setItemDataSource(item);
		memberForm.setEnabled(true);
		
		layout.addComponent(memberForm);
		final Button save = new Button("Save");
		memberForm.getFooter().removeAllComponents();
		memberForm.getFooter().addComponent(save);
		
		save.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                try {
                	memberForm.commit();
                	memberForm.setEnabled(false);
                	Notification.show(item.toString());
                } catch (InvalidValueException e) {
                }
            }
        });
	}

}