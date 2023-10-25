package com.fakhri.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fakhri.springboot.model.CloudVendor;
import com.fakhri.springboot.service.CloudService;

@RestController
@RequestMapping("/cloudservice")
public class CloudAPIService {
	
	
	
	@Autowired
	private CloudService cloudService;

	public CloudAPIService(CloudService cloudVendorService) {
		this.cloudService = cloudVendorService;
	}
	

	@GetMapping("{vendorId}")
	public CloudVendor getVendorById(@PathVariable("vendorId") String vendorId) {
		return cloudService.getById(vendorId);
	}
	
	@GetMapping()
	public List<CloudVendor> getAllVendors() {
		return cloudService.getAllVendors();
	}
	
	
	@PostMapping
	public String createCloudVendor(@RequestBody CloudVendor cloudVendor) {
		cloudService.addVendor(cloudVendor);
		return "Cloud Vendor Created Successfully!";
	}
	
	@PutMapping
	public String updateCloudVendor(@RequestBody CloudVendor cloudVendor) {
		cloudService.updateVendor(cloudVendor);
		return "Cloud Vendor Updated Successfully!";
	}
	
	@DeleteMapping("{vendorId}")
	public String deleteVendorById(@PathVariable("vendorId") String vendorId) {
		cloudService.deleteVendor(vendorId);
		return "Cloud Vendor Deleted Successfully!";
	}
	
	
}
