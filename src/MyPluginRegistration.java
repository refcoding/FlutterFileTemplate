import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.components.BaseComponent;
import org.jetbrains.annotations.NotNull;

public class MyPluginRegistration implements BaseComponent {
    // Returns the component name (any unique string value).
    @NotNull
    public String getComponentName() {
        return "MyPlugin";
    }


    // If you register the MyPluginRegistration class in the <application-components> section of
    // the plugin.xml file, this method is called on IDEA start-up.
    public void initComponent() {
        ActionManager am = ActionManager.getInstance();
        AnAction action = new AnAction("Flutter","", AllIcons.Actions.New) {
            @Override
            public void actionPerformed(@NotNull AnActionEvent anActionEvent) {

            }
        };

        // Passes an instance of your custom TextBoxes class to the registerAction method of the ActionManager class.
        am.registerAction("Flutter", action);

        // Gets an instance of the WindowMenu action group.
        DefaultActionGroup windowM = (DefaultActionGroup) am.getAction("NewGroup");

        // Adds a separator and a new menu command to the WindowMenu group on the main menu.
        windowM.addSeparator();
        windowM.addAction(action, Constraints.FIRST);
    }

    // Disposes system resources.
    public void disposeComponent() {
    }
}