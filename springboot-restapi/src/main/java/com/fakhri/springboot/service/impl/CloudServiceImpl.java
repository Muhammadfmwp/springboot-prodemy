package com.fakhri.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fakhri.springboot.exception.CloudVendorNotFoundException;
import com.fakhri.springboot.model.CloudVendor;
import com.fakhri.springboot.repository.CloudRepository;
import com.fakhri.springboot.service.CloudService;

@Service
public class CloudServiceImpl implements CloudService {
	
	@Autowired
	private CloudRepository cloudVendor;

	@Override
	public List<CloudVendor> getAllVendors() {
		return cloudVendor.findAll();
	}

	@Override
	public String addVendor(CloudVendor cloudVendor) {
		this.cloudVendor.save(cloudVendor);
		return "Success";
		
	}

	@Override
	public CloudVendor getById(String id) {
		if(cloudVendor.findById(id).isEmpty()) {
			throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
		}
		return cloudVendor.findById(id).get();
	}

	@Override
	public String deleteVendor(String id) {
		cloudVendor.deleteById(id);
		return "Success";
		
	}

	@Override
	public String updateVendor(CloudVendor cloudVendor) {
		this.cloudVendor.save(cloudVendor);
		return "Success";
	}

}
