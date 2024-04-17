package com.childmindr.chilmindrbackend.repository

import com.childmindr.chilmindrbackend.model.Childminder
import com.childmindr.chilmindrbackend.model.Location
import com.childmindr.chilmindrbackend.model.Profile
import org.springframework.data.repository.CrudRepository

interface ChildminderRepository : CrudRepository<Childminder, String>
