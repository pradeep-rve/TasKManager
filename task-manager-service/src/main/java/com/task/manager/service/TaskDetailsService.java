package com.task.manager.service;

import java.util.List;

import com.task.manager.exception.TaskException;
import com.task.manager.model.TaskDetail;

public interface TaskDetailsService {
	
	public List<TaskDetail> getTaskDetails() throws TaskException;

	public void updateTaskDetail(TaskDetail taskDetail) throws TaskException;
}
