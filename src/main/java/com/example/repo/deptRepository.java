package com.example.repo;

import com.example.pojo.dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface deptRepository extends JpaRepository<dept,Integer>, JpaSpecificationExecutor<dept> {

    List<dept> findByIdEquals(Integer ID);
}
