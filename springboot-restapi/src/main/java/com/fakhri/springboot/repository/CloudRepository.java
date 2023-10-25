package com.fakhri.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.fakhri.springboot.model.CloudVendor;

@Repository
public interface CloudRepository extends JpaRepository<CloudVendor, String> {

}
