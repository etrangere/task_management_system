package com.em.test_em.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.em.test_em.beans.User;

public interface UserRepository extends JpaRepository<User,Long>{

}