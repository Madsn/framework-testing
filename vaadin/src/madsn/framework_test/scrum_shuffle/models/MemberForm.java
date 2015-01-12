package madsn.framework_test.scrum_shuffle.models;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

public class MemberForm extends CustomComponent implements ClickListener {

	private static final long serialVersionUID = -4665518055378543925L;

	private TextField name;
	private TextField initials;
	private Button okBtn;
	private Button discardBtn;
	private BeanFieldGroup<Member> fieldGroup;

	private JPAContainer<Member> members;

	public MemberForm(JPAContainer<Member> memberContainer) {
		this.members = memberContainer;
		FormLayout layout = new FormLayout();
		name = new TextField("Name");
		name.setRequired(true);
		name.setNullRepresentation("");
		initials = new TextField("Initials");
		initials.setRequired(true);
		initials.setNullRepresentation("");

		layout.addComponent(name);
		layout.addComponent(initials);

		// add form buttons
		HorizontalLayout buttonBar = new HorizontalLayout();
		buttonBar.setSpacing(true);
		okBtn = new Button("OK");
		okBtn.addClickListener(this);
		discardBtn = new Button("Discard");
		discardBtn.addClickListener(this);
		buttonBar.addComponent(okBtn);
		buttonBar.addComponent(discardBtn);
		layout.addComponent(buttonBar);

		// create FieldGroup
		fieldGroup = new BeanFieldGroup<Member>(Member.class);
		fieldGroup.setItemDataSource(new Member());
		fieldGroup.bindMemberFields(this);

		setCompositionRoot(layout);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if (event.getSource() == okBtn) {
			try {
				fieldGroup.commit();
				members.addEntity(fieldGroup.getItemDataSource().getBean());
				fieldGroup.setItemDataSource(new Member());
			} catch (CommitException e) {
				Notification.show("validation failed", "Error",
						Notification.Type.ERROR_MESSAGE);
			}
		} else {
			fieldGroup.discard();
		}
	}

}
