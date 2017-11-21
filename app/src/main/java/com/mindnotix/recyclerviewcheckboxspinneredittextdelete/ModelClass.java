package com.mindnotix.recyclerviewcheckboxspinneredittextdelete;

/**
 * Created by Admin on 08-03-2017.
 */

public class ModelClass {

    String id;
    String editTextValue;
    boolean checkbox=false;
    int selectedposition=0;

    public int getSelectedposition() {
        return selectedposition;
    }

    public void setSelectedposition(int selectedposition) {
        this.selectedposition = selectedposition;
    }
    public boolean isCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }



    public String getId() {
        return id;
    }


    public String getEditTextValue() {
        return editTextValue;
    }

    public void setEditTextValue(String editTextValue) {
        this.editTextValue = editTextValue;
    }


    public ModelClass(String item) {

        this.id = item;
    }


}
