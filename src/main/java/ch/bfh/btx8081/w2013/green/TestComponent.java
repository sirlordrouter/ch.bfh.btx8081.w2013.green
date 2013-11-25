package ch.bfh.btx8081.w2013.green;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;

public class TestComponent extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private AbsoluteLayout absoluteLayout_2;
	@AutoGenerated
	private Button button_settings;
	@AutoGenerated
	private Button button_medication;
	@AutoGenerated
	private Button button_skills;
	@AutoGenerated
	private Button button_help;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public TestComponent() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
	}

	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// absoluteLayout_2
		absoluteLayout_2 = buildAbsoluteLayout_2();
		mainLayout.addComponent(absoluteLayout_2, "top:0.0px;left:0.0px;");
		
		return mainLayout;
	}

	@AutoGenerated
	private AbsoluteLayout buildAbsoluteLayout_2() {
		// common part: create layout
		absoluteLayout_2 = new AbsoluteLayout();
		absoluteLayout_2.setImmediate(false);
		absoluteLayout_2.setWidth("400px");
		absoluteLayout_2.setHeight("500px");
		
		// button_help
		button_help = new Button();
		button_help.setCaption("HELP");
		button_help.setImmediate(false);
		button_help.setWidth("260px");
		button_help.setHeight("26px");
		absoluteLayout_2.addComponent(button_help, "top:141.0px;left:80.0px;");
		
		// button_skills
		button_skills = new Button();
		button_skills.setCaption("SKILLS");
		button_skills.setImmediate(false);
		button_skills.setWidth("260px");
		button_skills.setHeight("-1px");
		absoluteLayout_2
				.addComponent(button_skills, "top:200.0px;left:80.0px;");
		
		// button_medication
		button_medication = new Button();
		button_medication.setCaption("MEDICATION");
		button_medication.setImmediate(false);
		button_medication.setWidth("266px");
		button_medication.setHeight("-1px");
		absoluteLayout_2.addComponent(button_medication,
				"top:260.0px;left:74.0px;");
		
		// button_settings
		button_settings = new Button();
		button_settings.setCaption("SETTINGS");
		button_settings.setImmediate(false);
		button_settings.setWidth("266px");
		button_settings.setHeight("-1px");
		absoluteLayout_2.addComponent(button_settings,
				"top:320.0px;left:74.0px;");
		
		return absoluteLayout_2;
	}

}
