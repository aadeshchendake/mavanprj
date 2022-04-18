package com.junittestingexam.testjunitmockitofour.controller;

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

import com.junittestingexam.testjunitmockitofour.dto.RestrorentDTO;
import com.junittestingexam.testjunitmockitofour.entity.Customer;
import com.junittestingexam.testjunitmockitofour.entity.Restrorent;
import com.junittestingexam.testjunitmockitofour.exceptions.RecordNotFoundException;
import com.junittestingexam.testjunitmockitofour.service.RestrorentService;
import com.junittestingexam.testjunitmockitofour.utils.Message;
import com.junittestingexam.testjunitmockitofour.utils.ResponseBody;

@RestController
@RequestMapping("/restrorent")
public class RestrorentController {
	@Autowired
	private RestrorentService restServ;
	
	@Autowired
	private Message message;
	
	@PostMapping("/createCall")
	public Restrorent createCall(@RequestBody Restrorent rust) {
		return restServ.createCall(rust);
	}
	
	@PutMapping("/putCall")
	public Restrorent putCall(@RequestBody Restrorent rust) {
		return restServ.putCall(rust);
	}
	
	@GetMapping("/getCall")
	public List<Restrorent> getCall(){
		return restServ.getCall();
	}

	@DeleteMapping("/deleteCall")
	public String deleteCall(@RequestBody Restrorent rust) {
		restServ.deleteCall(rust);
		return "Deleted!";
	}
	
	@PostMapping("/create-restrorent")
	public ResponseEntity<ResponseBody> createRestrorent(@RequestBody RestrorentDTO restDTO){
		restServ.createRestrorentCall(restDTO);
		return ResponseEntity.ok().body(new ResponseBody(HttpStatus.OK.value(), message.getMessage("restrorent.add")));
	}
	
	@PutMapping("/get-all-restrorent")
	public ResponseEntity<List<RestrorentDTO>> getAllRestrorent(){
		return new ResponseEntity<>(restServ.getAllRestrorent(),HttpStatus.OK);
	}
	
	@PutMapping("/update-restrorent")
	public ResponseEntity<ResponseBody> updateRestrorent(@RequestBody RestrorentDTO restDTO) throws RecordNotFoundException{
		restServ.updateRestrorentCall(restDTO);
		return ResponseEntity.ok().body(new ResponseBody(HttpStatus.OK.value(), message.getMessage("restrorent.add")));
	}
	
	@DeleteMapping("/delete-restrorent-byId/{restId}")
	public ResponseEntity<ResponseBody> deleteRestrorent(@PathVariable Long restId) throws RecordNotFoundException{
		restServ.deleteRestrorent(restId);
		return ResponseEntity.ok().body(new ResponseBody(HttpStatus.OK.value(), message.getMessage("restrorent.deleted")));
	}
}
