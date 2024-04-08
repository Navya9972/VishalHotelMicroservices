package com.userservices.exceptions;

	public class ResourceNotFoundException extends RuntimeException
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ResourceNotFoundException()
		{
			super("Resource not found exception int the server ");
		}
		
		public ResourceNotFoundException(String message)
		{
			super(message);
		}
	}

