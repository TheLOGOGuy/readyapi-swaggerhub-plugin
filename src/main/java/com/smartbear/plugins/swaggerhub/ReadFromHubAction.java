package com.smartbear.plugins.swaggerhub;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.plugins.ActionConfiguration;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;
import javafx.application.Platform;

@ActionConfiguration(actionGroup = "EnabledWsdlProjectActions", afterAction = "ExportSwaggerAction")
public class ReadFromHubAction extends AbstractSoapUIAction<WsdlProject> {

    public ReadFromHubAction() {
        super("Import From SwaggerHub", "Reads an API from SwaggerHub");
    }

    @Override
    public void perform(WsdlProject modelItem, Object o) {
        Platform.runLater(() -> {
            ImportFromHubDialog importFromHubDialog = new ImportFromHubDialog(modelItem);
            UISupport.centerFxDialog(importFromHubDialog);
            importFromHubDialog.showAndWait();
        });
    }
}
