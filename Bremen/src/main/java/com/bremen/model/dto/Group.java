package com.bremen.model.dto;

public class Group {
	private int groupId;
	private String groupTitle;
	private String groupContent;
	private String groupWriter;
	private int groupViewCnt;
	private String groupDate;
	private String groupCategory;
	private int groupMaxPeople;
	private int groupCurrentPeople;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupTitle() {
		return groupTitle;
	}

	public void setGroupTitle(String groupTitle) {
		this.groupTitle = groupTitle;
	}

	public String getGroupContent() {
		return groupContent;
	}

	public void setGroupContent(String groupContent) {
		this.groupContent = groupContent;
	}

	public String getGroupWriter() {
		return groupWriter;
	}

	public void setGroupWriter(String groupWriter) {
		this.groupWriter = groupWriter;
	}

	public int getGroupViewCnt() {
		return groupViewCnt;
	}

	public void setGroupViewCnt(int groupViewCnt) {
		this.groupViewCnt = groupViewCnt;
	}

	public String getGroupDate() {
		return groupDate;
	}

	public void setGroupDate(String groupDate) {
		this.groupDate = groupDate;
	}

	public String getGroupCategory() {
		return groupCategory;
	}

	public void setGroupCategory(String groupCategory) {
		this.groupCategory = groupCategory;
	}

	public int getGroupMaxPeople() {
		return groupMaxPeople;
	}

	public void setGroupMaxPeople(int groupMaxPeople) {
		this.groupMaxPeople = groupMaxPeople;
	}

	public int getGroupCurrentPeople() {
		return groupCurrentPeople;
	}

	public void setGroupCurrentPeople(int groupCurrentPeople) {
		this.groupCurrentPeople = groupCurrentPeople;
	}
}
