package fr.iagl.opl.enums;

public enum PageEnum {
	HOME("/","home"),
	ERROR_LIST_ALREADY_EXISTS("/errorListAlreadyExists","errorListAlreadyExists"),
	ERROR_LIST_NOT_EXISTS("/errorListNotExists","errorListNotExists"),
	ERROR_WHEN_CREATING_TASK("/errorWhenCreatingTask","errorWhenCreatingTask");
	
	private String url;
	private String page;
	
	private PageEnum(String url,String page){
		this.url = url;
		this.page = page;
	}

	
	public String getUrl() {
		return url;
	}


	public String getPage() {
		return page;
	}
}
