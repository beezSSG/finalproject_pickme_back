package com.pickme.beeze.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.login.dto.SnsLoginDto;
import com.pickme.beeze.login.service.SnsLoginService;

@RestController
@RequestMapping(value = "/login/oauth2", produces = "application/json")
public class SnsLoginController {

    private final SnsLoginService service;

	public SnsLoginController(SnsLoginService service) {
		this.service = service;
	}

	/**
	 * 
	 * @param code
	 * @param registrationId
	 * @return SnsLoginDto
	 * 앞단에서 받은 인가 코드를 뒷단으로 보내줌.
	 * 플랫폼을 구분하기위해 뒷자리 @PathVariable를 파라미터로 사용함.
	 */
	@GetMapping("/code/{registrationId}")
    public SnsLoginDto socialLogin(@RequestParam String code, @PathVariable String registrationId) {
		return service.socialLogin(code, registrationId);
    }
}