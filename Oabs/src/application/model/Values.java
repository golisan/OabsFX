package application.model;

import javafx.beans.property.SimpleStringProperty;

public class Values {
	private final SimpleStringProperty colKey ;
    private final SimpleStringProperty colValue;

    
    public Values (String key, String value) {
    	this.colKey = new SimpleStringProperty(key);
    	this.colValue = new SimpleStringProperty(value);
		 
	}
    public String getColKey(){
    	return colKey.get();
    }
    public String getColValue(){
    	return colValue.get();
    }
    public void setColKey(String key){
    	colKey.set(key);
    }
    public void setColValue(String value){
    	colKey.set(value);
    }
}
