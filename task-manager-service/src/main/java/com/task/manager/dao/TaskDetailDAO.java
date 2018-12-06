package com.task.manager.dao;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.task.manager.model.TaskDetail;

/**
 * 
 * @author 449418
 *
 */
@Repository
public interface TaskDetailDAO extends MongoRepository<TaskDetail, String>{
	List<TaskDetail> findAll();
}
