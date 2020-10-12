package com.waka.ride.retrofit;

import com.waka.ride.models.AttendanceResponse;
import com.waka.ride.models.ForgotPassword;
import com.waka.ride.models.RegistrationResponse;
import com.waka.ride.models.ViewAttendance.ViewAttendance;
import com.waka.ride.models.loginResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitAPI {

    //Login API
    //https://dashboard.kiwisignin.co.nz/api.php?action=login&email=info@cgit.pk&password=123
    @GET("api.php?action=login")
    Call<LoginResponse> loginResponse(@Query("email")String email, @Query("password")String password);

    //Mark Attendance
    //user_id = login user
    //visit_to = Big QR Scan response
    //https://dashboard.kiwisignin.co.nz/api.php?action=qr_scan_by_user&user_id=50&visit_to=49
    @GET("api.php?action=qr_scan_by_user")
    Call<AttendanceResponse> attendanceResponse(@Query("user_id")String data,@Query("visit_to")String id);

    //ViewAttendance
    //user_id = Login user from the APP
    //https://dashboard.kiwisignin.co.nz/api.php?action=view_attendance&user_id=50
    @GET("api.php?action=view_attendance")
    Call<ViewAttendance> getAttendance(@Query("user_id")String id);

    //https://dashboard.kiwisignin.co.nz/api.php?action=register_user&
    // name=moiz&email=moiz.iqbal55@gmail.com&password=123&phone=0322622402
    @GET("api.php?action=register_user")
    Call<RegistrationResponse> registerUser(@Query("name")String name,
                                            @Query("email")String email,
                                            @Query("password")String password,
                                            @Query("phone")String phone);

    //Forgot Password
    //http://dashboard.kiwisignin.co.nz/api.php?action=forgot_email&email=info@cgit.pk
    @GET("api.php?action=forgot_email")
    Call<ForgotPassword> resetPassword(@Query("email")String email);
}
