package com.novi.eindproject.idrunk.version.july.exceptions;

import java.text.MessageFormat;

public class DrinkNotFoundException extends RuntimeException{

public DrinkNotFoundException(final long id) {
    super(MessageFormat.format("Could not find order with id: {0}", id));
}
}
