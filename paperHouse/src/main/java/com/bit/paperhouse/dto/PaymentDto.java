package com.bit.paperhouse.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
public class PaymentDto implements Serializable {

	private int pay_seq;
	private int user_seq;
	private int write_seq;
	private String approval_number;
	private String payment_method;
	private String payment_detail;
	private String payment_date;
}
