package ch.bfh.btx8081.w2013.green.ui;

import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Johannes on 07.01.14.
 */
public class BaseView extends VerticalLayout{

    protected VerticalLayout header = new VerticalLayout();
    protected VerticalLayout content = new VerticalLayout();
    protected HorizontalLayout navigation = new HorizontalLayout();
    protected VerticalLayout verticalNavigation = new VerticalLayout();

    public BaseView () {

        setBaseStyle();

    }

    protected void setBaseStyle() {

        this.addStyleName("dashboard-view");

        this.setWidth(MyVaadinUI.APP_WIDTH);
        this.setHeight(MyVaadinUI.APP_HIGHT);

        this.setMargin(true);
        this.setSpacing(true);
    }

    protected void setTitle(String title) {

        Label titleLiabel = new Label(title);
        titleLiabel.setStyleName("h1");
        titleLiabel.setHeight("30px");

        this.header.addComponent(titleLiabel);
        this.header.setComponentAlignment(titleLiabel, Alignment.TOP_CENTER);
    }

    protected void setLayouts(float headerRatio, float contentRatio, float navigationRatio, float verticalNavicationRatio) {

        this.content.setMargin(true);
        this.content.setSpacing(true);
        this.navigation.setMargin(true);
        this.navigation.setSpacing(true);
        this.verticalNavigation.setMargin(true);
        this.verticalNavigation.setSpacing(true);

        this.addComponent(header);
        this.addComponent(content);
        this.addComponent(navigation);
        this.addComponent(verticalNavigation);

        this.setExpandRatio(header, headerRatio);
        this.setExpandRatio(content, contentRatio);
        this.setExpandRatio(navigation, navigationRatio);
        this.setExpandRatio(verticalNavigation, verticalNavicationRatio);
    }
}
