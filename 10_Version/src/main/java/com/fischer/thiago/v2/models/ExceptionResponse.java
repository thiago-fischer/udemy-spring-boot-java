package com.fischer.thiago.v2.models;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
