package com.example.dao.repository;

import com.example.entity.table.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by cc on 17-4-21.
 */
public interface UserRepository extends CrudRepository<UserInfo,Integer> {
}
