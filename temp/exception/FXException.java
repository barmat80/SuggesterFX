package com.maemlab.suggesterfx.exception;

import java.io.Serial;

public class FXException extends Exception {
	@Serial
	private static final long serialVersionUID = 1L;

	public FXException(String message) {
		super(message);
	}

	public FXException(String message, Throwable err) {
		super(message, err);
	}

	public FXException(Exception e) {
		super("", e);
	}
}
