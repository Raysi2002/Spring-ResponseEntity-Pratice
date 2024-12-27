package com.raysi.responseentitypratice.customexception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControllerException extends RuntimeException {
  @Serial
  private static final long serialVersionUID = 1L;

  private String errorCode;
  private String errorMessage;
//    public ControllerException(String message) {
//        super(message);
//    }
}
