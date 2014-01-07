package ch.bfh.btx8081.w2013.green.ui;

import ch.bfh.btx8081.w2013.green.ui.start.MyVaadinUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>A base view with all the Layouting functions. Simplyfies the Design of the Application.</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 07-01-2014
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
        titleLiabel.setWidth("305px");

        this.header.addComponent(titleLiabel);
        this.header.setComponentAlignment(titleLiabel, Alignment.TOP_CENTER);
    }

    protected void setLayouts(float headerRatio, float contentRatio, float navigationRatio, float verticalNavicationRatio) {

        this.content.setMargin(true);
        this.content.setSpacing(true);

        this.addComponent(header);
        this.addComponent(content);

        this.setExpandRatio(header, headerRatio);
        this.setExpandRatio(content, contentRatio);

        if (navigationRatio == 0) {

            this.verticalNavigation.setMargin(true);
            this.verticalNavigation.setSpacing(true);
            this.addComponent(verticalNavigation);
            this.setExpandRatio(verticalNavigation, verticalNavicationRatio);

        } else {

            this.navigation.setMargin(true);
            this.navigation.setSpacing(true);
            this.addComponent(navigation);
            this.setExpandRatio(navigation, navigationRatio);

        }
    }
}
