package com.task.manager.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.task.manager.dao.TaskDetailDAO;
import com.task.manager.exception.TaskException;
import com.task.manager.model.TaskDetail;
import com.task.manager.model.TaskSequence;

@Service
public class TaskDetailsServiceImpl implements TaskDetailsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskDetailsServiceImpl.class);

	@Autowired
	private TaskDetailDAO detailDAO;

	@Autowired
	private MongoOperations mongoOperations;

	/**
	 * Method used for retrieving all the tasks from DB
	 * 
	 * @return List<TaskDetail>
	 */
	@Override
	public List<TaskDetail> getTaskDetails() throws TaskException {
		LOGGER.info("Start Of TaskDetailsServiceImpl.getTaskDetails");
		List<TaskDetail> taskDetails = null;
		try {
			taskDetails = detailDAO.findAll();
		} catch (Exception exception) {
			LOGGER.error("Exception occured in getTaskDetails",exception);
			throw new TaskException("1000", "Technical Error", 500);
		}
		LOGGER.info("End Of TaskDetailsServiceImpl.getTaskDetails");
		return taskDetails;
	}

	/**
	 * Method used for adding / updating the task in DB
	 * 
	 * @param TaskDetail
	 * @return
	 */
	@Override
	public void updateTaskDetail(TaskDetail taskDetail) throws TaskException {
		LOGGER.info("Start Of TaskDetailsServiceImpl.getTaskDetails");
		try {
			if (taskDetail.getTaskId() == 0) {
				taskDetail.setTaskId(getNextSequence("TaskSequence"));
			}
			detailDAO.save(taskDetail);
		} catch (Exception exception) {
			LOGGER.error("Exception occured in updateTaskDetail",exception);
			throw new TaskException("1000", "Technical Error", 500);
		}
		LOGGER.info("End Of TaskDetailsServiceImpl.updateTaskDetail");
	}

	/**
	 * Method for retriving the sequence number to be used for task id while
	 * adding task detail in DB
	 * 
	 * @param seqName
	 * @return
	 */
	public int getNextSequence(String seqName) {
		TaskSequence counter = mongoOperations.findAndModify(
				query(where("_id").is(seqName)), new Update().inc("seq", 1),
				options().returnNew(true).upsert(true), TaskSequence.class);
		return counter.getSeq();
	}

}
