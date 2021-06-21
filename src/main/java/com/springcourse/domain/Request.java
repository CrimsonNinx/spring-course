package com.springcourse.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.springcourse.domain.enums.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Request {

	private long id;
	private String subject;
	private String description;
	private Date creationDade;
	private RequestState state;
	private User user;
	
	private List<RequestStage>stages = new ArrayList<RequestStage>();
	
	
}
