package com.konfio.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Buy limits wrong")
public class BadLimitBuyException extends RuntimeException{
}
