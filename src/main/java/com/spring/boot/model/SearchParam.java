package com.spring.boot.model;

import java.util.Optional;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class SearchParam {
	private Optional<String> index = Optional.empty();
	private Optional<String> type = Optional.empty();
	private Optional<String> logLevel = Optional.empty();
	private Optional<String> message = Optional.empty();
	private Optional<Integer> minute = Optional.empty();
}
