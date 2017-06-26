package com.company.sample.web.person;

import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.sample.entity.Person;
import com.haulmont.cuba.gui.components.FieldGroup;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import java.util.Map;

public class PersonEdit extends AbstractEditor<Person> {
    @Inject
    private Datasource<Person> personDs;
    @Inject
    private FieldGroup fieldGroup;

    @Override
    public void init(Map<String, Object> params) {
        personDs.addItemPropertyChangeListener(e -> {
            if ("email".equals(e.getProperty()) || "phone".equals(e.getProperty())) {
                updateSendingMessagesField();
            }
        });
    }

    @Override
    protected void postInit() {
        // Update boolean field availability after screen is opened
        updateSendingMessagesField();
    }

    private void updateSendingMessagesField() {
        // Check if one or more required fields are set
        boolean hasContactInformation = getItem().getEmail() != null
                || getItem().getPhone() != null;

        fieldGroup.getFieldNN("sendingMessages")
                .setEnabled(hasContactInformation);

        // Set boolean value to false if there are no required values
        getItem().setSendingMessages(getItem().getSendingMessages()
                && hasContactInformation);
    }
}