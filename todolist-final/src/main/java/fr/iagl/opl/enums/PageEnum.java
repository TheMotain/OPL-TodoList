package fr.iagl.opl.enums;

public enum PageEnum {
	HOME("home"),
	ERROR_LIST_ALREADY_EXISTS("errorListAlreadyExists"),
	ERROR_LIST_NOT_EXISTS("errorListNotExists");
	
	private String page;
	
	private PageEnum(String page){
		this.page = page;
	}

	public String getPage() {
		return page;
	}
}
