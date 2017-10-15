package fr.iagl.opl.enums;

public enum ModelAttributeEnum {
	LIST_FORM("listForm"),
	TODOLISTS("todolists");
	
	private String attribute;
	
	private ModelAttributeEnum(String attribute){
		this.attribute = attribute;
	}

	public String getAttribute() {
		return attribute;
	}
}
