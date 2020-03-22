package com.objectrepository;

import org.openqa.selenium.By;

public class Locators {
	// public final By PageName_ElementName_ElementType = By.xpath("sdfdsf");
	public final By Login_button = By.xpath("//*[@title='Login']");
	public final By Login_CreateNewAccount_button = By.xpath("//*[@name='dwfrm_login_register']");
	
	public final By CreateAnAccount_FirstName_EditBox = By.xpath("(//*[@type='text'])[2]");
	public final By CreateAnAccount_LastName_EditBox = By.xpath("//*[@name='dwfrm_profile_customer_lastname']");
	public final By CreateAnAccount_Email_EditBox = By.xpath("//*[@name='dwfrm_profile_customer_email']");
	public final By CreateAnAccount_ConfirmEmail_EditBox = By.xpath("//*[@name='dwfrm_profile_customer_emailconfirm']");
	public final By CreateAnAccount_Password_EditBox = By.xpath("//*[@name='dwfrm_profile_login_password']");
	public final By CreateAnAccount_ConfirmPassword_EditBox = By.xpath("//*[@id='dwfrm_profile_login_passwordconfirm']");
	public final By CreateAnAccount_CreateNewAccount_button = By.xpath("//*[@name='dwfrm_profile_confirm']");

	// public final String By Xp_td_Tel_Er1 =
	// "//*[contains(@class,'error')][contains(text(),
	// 'Telephone')]//following-sibling::p[@style='display: block;']";
	public final By CreateAnAccount_Firstname_Error_Msg = By.xpath("//*[contains(@id,'error_dwfrm_profile_customer_firstname')]");
	public final By CreateAnAccount_Lastname_Error_Msg = By.xpath("//*[contains(@id,'error_dwfrm_profile_customer_lastname')]");
	public final By CreateAnAccount_Email_Error_Msg = By.xpath("//*[contains(@id,'error_dwfrm_profile_customer_email')]");
	public final By CreateAnAccount_ConfirmEmail_Error_Msg = By.xpath("//*[contains(@id,'error_dwfrm_profile_customer_emailconfirm')]");
	public final By CreateAnAccount_Password_Error_Msg = By.xpath("//*[contains(@id,'error_dwfrm_profile_login_password')]");
	public final By CreateAnAccount_Confirmpassword_Error_Msg = By.xpath("//*[@id='bouncer-error_dwfrm_profile_login_passwordconfirm']");

	//sign in
	public final By Signin_Email_EditBox = By.xpath("//*[@id='dwfrm_login_username_d0tuyxoqxiqd']");
	public final By Signin__Password_EditBox = By.xpath("//*[@id='dwfrm_login_password']");
	public final By Signin_signin_button = By.xpath("//*[@value='Login']");

	public final By Signin_Email_Error_Msg = By.xpath("//*[contains(@id,'bouncer-error_dwfrm_login_username_d0tuyxoqxiqd')]");
	public final By Signin_Password_Error_Msg = By.xpath("//*[contains(@id,'bouncer-error_dwfrm_login_password')]");
	public final By Frgotpassword_email_editbox = By.xpath("//*[@id='dwfrm_requestpassword_email']");
	public final By Resetpassword_button = By.xpath("//*[@name='dwfrm_requestpassword_send']");
	public final By forgotpassword_emailErrMsg = By.xpath("//*[@class='messaging error']/p");
	

}