package com.fakhri.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fakhri.springboot.model.CloudVendor;

@Service
public interface CloudService {

	List<CloudVendor> getAllVendors();
	String addVendor(CloudVendor cloudVendor);
	CloudVendor getById(String id);
	String deleteVendor(String id);
	String updateVendor(CloudVendor cloudVendor);
}
