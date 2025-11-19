package com.fischer.thiago.models;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
