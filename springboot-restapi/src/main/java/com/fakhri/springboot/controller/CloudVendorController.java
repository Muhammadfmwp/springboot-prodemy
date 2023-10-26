package com.fakhri.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fakhri.springboot.model.CloudVendor;
import com.fakhri.springboot.response.ResponseHandler;
import com.fakhri.springboot.service.CloudService;

@RestController
@RequestMapping("/cloudservice")
public class CloudVendorController {
	
	
	
	@Autowired
	private CloudService cloudService;

	public CloudVendorController(CloudService cloudVendorService) {
		this.cloudService = cloudVendorService;
	}
	

	@GetMapping("{vendorId}")
	public ResponseEntity<Object> getVendorById(@PathVariable("vendorId") String vendorId) {
		return ResponseHandler.responseBuilder("Vendor details", HttpStatus.OK,cloudService.getById(vendorId) );
		
	}
	
	@GetMapping()
	public ResponseEntity<Object> getAllVendors() {
		return ResponseHandler.responseBuilder("Get All Vendors", HttpStatus.OK, cloudService.getAllVendors());
	}
	
	
	@PostMapping
	public ResponseEntity<Object> createCloudVendor(@RequestBody CloudVendor cloudVendor) {
		cloudService.addVendor(cloudVendor);
		return ResponseHandler.responseBuilder("Created Vendor Successfully", HttpStatus.OK, cloudService.getById(cloudVendor.getVendorId()));
	}
	
	@PutMapping
	public ResponseEntity<Object> updateCloudVendor(@RequestBody CloudVendor cloudVendor) {
		cloudService.updateVendor(cloudVendor);
		return ResponseHandler.responseBuilder("Vendor Updated Successfully", HttpStatus.OK, cloudService.getById(cloudVendor.getVendorId()));
	}
	
	@DeleteMapping("{vendorId}")
	public String deleteVendorById(@PathVariable("vendorId") String vendorId) {
		cloudService.deleteVendor(vendorId);
		return "Cloud Vendor Deleted Successfully!";
	}
	
	
}
