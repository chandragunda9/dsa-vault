package com.learning.dsa_backend_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dsa_backend_app.response.ContentResponse;
import com.learning.dsa_backend_app.service.ContentProviderService;

@RestController
public class ContentController {
	
	@Autowired
	ContentProviderService contentProviderService;

	@GetMapping("/fetch/content")
	ContentResponse getFolderContent(@RequestParam String path){
		ContentResponse content=contentProviderService.getContent(path);
		return content;
	}

}
