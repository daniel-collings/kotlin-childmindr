package com.childmindr.chilmindrbackend.repository

import com.childmindr.chilmindrbackend.model.Location
import org.springframework.data.repository.CrudRepository

interface LocationRepository : CrudRepository<Location, String>
