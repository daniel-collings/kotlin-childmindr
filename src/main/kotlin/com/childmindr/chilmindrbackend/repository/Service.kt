package com.childmindr.chilmindrbackend.repository

import com.childmindr.chilmindrbackend.model.Service
import org.springframework.data.repository.CrudRepository

interface ServiceRepository : CrudRepository<Service, String>
