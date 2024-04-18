package com.childmindr.chilmindrbackend.repository

import com.childmindr.chilmindrbackend.model.relation.ChildminderService
import org.springframework.data.repository.CrudRepository

interface ChildminderServiceRepository : CrudRepository<ChildminderService, String>
