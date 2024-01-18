package com.velue;

public interface OutstandingResponse {
  String getCustomerName();
  String getGstno();
  Long getOutstandingLimit();
  Long getOverdue();
}
