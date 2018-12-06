package com.task.manager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.task.manager.exception.TaskException;
import com.task.manager.model.TaskDetail;
import com.task.manager.service.TaskDetailsService;

/**
 * 
 * @author 449418
 *
 */

@RestController
public class TaskManagerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskManagerController.class);
	
	@Autowired
	private TaskDetailsService taskDetailsService;
	
	/**
	 * Method used for viewing all the tasks
	 * @return
	 */
	@RequestMapping(value = "/viewTasks", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<TaskDetail> getTasks() throws TaskException{
		LOGGER.info("Start Of TaskManagerController.getTasks");
		List<TaskDetail> taskDetails = taskDetailsService.getTaskDetails();
		LOGGER.info("End Of TaskManagerController.getTasks");
		return taskDetails;
	}
	
	/**
	 * Method used to add/update task details
	 * @param taskDetail
	 * @return
	 */
	@RequestMapping(value = "/updateTask", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody TaskDetail taskDetail) throws TaskException{
		LOGGER.info("Start Of TaskManagerController.Update");
		taskDetailsService.updateTaskDetail(taskDetail);
		LOGGER.info("End Of TaskManagerController.Update");
    }
}
