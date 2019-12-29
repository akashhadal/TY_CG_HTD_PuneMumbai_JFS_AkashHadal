package com.capgemini.hotelmanagementsystem.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.hotelmanagementsystem.response.HotelManagementResponse;

@RestControllerAdvice
public class HotelManagementSystemControllerAdvice {

	@ExceptionHandler(EmailAlreadyExistException.class)
	public HotelManagementResponse hotelManagementErrorResponse(EmailAlreadyExistException emailAlreadyExixtException) {
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		hotelManagementResponse.setStatusCode(401);
		hotelManagementResponse.setMessage("Failed");
		hotelManagementResponse.setDescription("Email Alredy Exist");
		return hotelManagementResponse;
	}

	@ExceptionHandler(InvalidPasswordException.class)
	public HotelManagementResponse hotelManagementErrorResponse(InvalidPasswordException invalidPasswordException) {
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		hotelManagementResponse.setStatusCode(401);
		hotelManagementResponse.setMessage("Failed");
		hotelManagementResponse.setDescription("You Have Entered Wrong Password");
		return hotelManagementResponse;
	}

	@ExceptionHandler(InvalidLoginCredentials.class)
	public HotelManagementResponse hotelManagementErrorResponse(InvalidLoginCredentials invalidLoginException) {
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		hotelManagementResponse.setStatusCode(401);
		hotelManagementResponse.setMessage("Failed");
		hotelManagementResponse.setDescription("Wrong Credentials");
		return hotelManagementResponse;
	}

	@ExceptionHandler(HotelNotFoundException.class)
	public HotelManagementResponse hotelManagementErrorResponse(HotelNotFoundException hotelNotFoundException) {
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		hotelManagementResponse.setStatusCode(401);
		hotelManagementResponse.setMessage("Failed");
		hotelManagementResponse.setDescription("Hotel Not Found Please Check for Another Hotel");
		return hotelManagementResponse;
	}
	
	@ExceptionHandler(RoomNotFoundException.class)
	public HotelManagementResponse hotelManagementErrorResponse(RoomNotFoundException roomNotFoundException) {
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		hotelManagementResponse.setStatusCode(401);
		hotelManagementResponse.setMessage("Failed");
		hotelManagementResponse.setDescription("Room Not Found Please Check for Another Room");
		return hotelManagementResponse;
	}
	
	@ExceptionHandler(UnableToAddException.class)
	public HotelManagementResponse hotelManagementErrorResponse(UnableToAddException unableToAddException) {
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		hotelManagementResponse.setStatusCode(401);
		hotelManagementResponse.setMessage("Failed");
		hotelManagementResponse.setDescription("Unable to Add");
		return hotelManagementResponse;
	}
	@ExceptionHandler(FetchNullListException.class)
	public HotelManagementResponse hotelManagementErrorResponse(FetchNullListException fetchNullListException) {
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		hotelManagementResponse.setStatusCode(401);
		hotelManagementResponse.setMessage("Failed");
		hotelManagementResponse.setDescription("Unable to Fetch Records");
		return hotelManagementResponse;
	}
	
	@ExceptionHandler(UnableRegisterException.class)
	public HotelManagementResponse hotelManagementErrorResponse(UnableRegisterException fetchNullListException) {
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		hotelManagementResponse.setStatusCode(401);
		hotelManagementResponse.setMessage("Failed");
		hotelManagementResponse.setDescription("Unable to Register");
		return hotelManagementResponse;
	}
	
	@ExceptionHandler(InvalidEmailException.class)
	public HotelManagementResponse hotelManagementErrorResponse(InvalidEmailException invalidEmailException) {
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		hotelManagementResponse.setStatusCode(401);
		hotelManagementResponse.setMessage("Failed");
		hotelManagementResponse.setDescription("Please Enter valid Email");
		return hotelManagementResponse;
	}
	
	@ExceptionHandler(UnableDeleteException.class)
	public HotelManagementResponse hotelManagementErrorResponse(UnableDeleteException unableDelete) {
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		hotelManagementResponse.setStatusCode(401);
		hotelManagementResponse.setMessage("Failed");
		hotelManagementResponse.setDescription("Unable to Delete");
		return hotelManagementResponse;
	}
	
	@ExceptionHandler(UnableToUpdateException.class)
	public HotelManagementResponse hotelManagementErrorResponse(UnableToUpdateException UnableToUpdate) {
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		hotelManagementResponse.setStatusCode(401);
		hotelManagementResponse.setMessage("Failed");
		hotelManagementResponse.setDescription("Unable to Update Records");
		return hotelManagementResponse;
	}
	
	@ExceptionHandler(CancelBookingException.class)
	public HotelManagementResponse hotelManagementErrorResponse(CancelBookingException cancelBookingException) {
		HotelManagementResponse hotelManagementResponse = new HotelManagementResponse();
		hotelManagementResponse.setStatusCode(401);
		hotelManagementResponse.setMessage("Failed");
		hotelManagementResponse.setDescription("Unable to Cancel Booking");
		return hotelManagementResponse;
	}
}
