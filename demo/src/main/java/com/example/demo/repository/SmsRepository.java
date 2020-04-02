package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.SmsMaster;

public interface SmsRepository extends CrudRepository<SmsMaster, Integer>
{

}
