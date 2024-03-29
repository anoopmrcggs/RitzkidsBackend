package com.rcg.com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rcg.com.dao.YoungGust;
import com.rcg.com.dao.YoungGustNotes;
import com.rcg.com.dto.YoungGustNotesDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.service.YoungGustNote_Service;
import com.rcg.com.util.ResponseStatus;
import com.rcg.com.util.RitzConstants;

@RestController
@RequestMapping("/api")
public class YoungGustNote_Controller 
{
	@Autowired
	private YoungGustNote_Service ygs;
	
	@RequestMapping(method=RequestMethod.POST,value="/younggustnote/{cid}")
	public ResponseEntity<?> save(@Valid @RequestBody YoungGustNotesDto ydto,@PathVariable int cid) throws RitzkidsException
	{
		ygs.saveYoungGustNote(ydto,cid);
		return ResponseEntity.ok(new ResponseStatus<YoungGust>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS));

	}
	
	@RequestMapping("/younggustnote/{cid}")
	public ResponseEntity<?> getYoungGustNotes(@PathVariable int cid) throws RitzkidsException
	{
		return ResponseEntity.ok(new ResponseStatus<List<YoungGustNotes>>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS,ygs.getYoungGustNotes(cid)));
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/younggustnote/cid/{cid}/noteid/{nid}")
	public ResponseEntity<?> update(@RequestBody YoungGustNotesDto ydto,@PathVariable int cid,@PathVariable int nid) throws RitzkidsException
	{
		ygs.updateYoungGustNote(ydto,cid,nid);
		return ResponseEntity.ok(new ResponseStatus<YoungGust>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS));

	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/younggustnote/{nid}")
	public ResponseEntity<?> delete(@PathVariable int nid) throws RitzkidsException
	{
		ygs.deleteYoungGustNote(nid);
		return ResponseEntity.ok(new ResponseStatus<YoungGust>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS));

	}


}
