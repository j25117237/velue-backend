package com.velue.RequestBody;

// import java.util.TIMESTAMP;
import java.util.Date;




public class SalesByProductRequest {
//	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date startDate;
//	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date endDate;

    public Date getStartDate(){
        return startDate;
    }
    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }

    public Date getEndDate(){
        return endDate;
    }
    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }
}
