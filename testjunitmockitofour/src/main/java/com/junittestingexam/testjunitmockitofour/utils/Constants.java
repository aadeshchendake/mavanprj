package com.junittestingexam.testjunitmockitofour.utils;

public class Constants {
	public enum CustomCodes {
		SUCCESS(700),
		RECORD_NOT_FOUND(701),
		RECORDS_NOT_FOUND(702),
		RECORD_ALREADY_EXISTS(703);
		
		private final int code;
		
		private CustomCodes(int code) {
			this.code  = code;
		}
		
		public int getCode() {
			return code;
		}
	}
}
