package com.task.manager.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ParentTaskManager")
public class ParentTaskDetail {

	private int parentId;
	private String parentTaskName;

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getParentTaskName() {
		return parentTaskName;
	}

	public void setParentTaskName(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}

}
