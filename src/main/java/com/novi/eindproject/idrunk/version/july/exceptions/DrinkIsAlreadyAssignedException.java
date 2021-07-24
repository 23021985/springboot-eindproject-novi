package com.novi.eindproject.idrunk.version.july.exceptions;

import java.text.MessageFormat;

public class DrinkIsAlreadyAssignedException extends RuntimeException{
     public DrinkIsAlreadyAssignedException(final Long drinkId, final Long orderId){
     super(MessageFormat.format("Drink: {0} is already assigned to order: {1)", drinkId, orderId));
     }
}
