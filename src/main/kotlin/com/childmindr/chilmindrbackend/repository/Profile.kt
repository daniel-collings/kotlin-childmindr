package com.childmindr.chilmindrbackend.repository

import com.childmindr.chilmindrbackend.model.Profile
import org.springframework.data.repository.CrudRepository

interface ProfileRepository : CrudRepository<Profile, String>
