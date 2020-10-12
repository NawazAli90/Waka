package com.waka.ride.retrofit;

import com.waka.ride.models.AttendanceResponse;
import com.waka.ride.models.ForgotPassword;
import com.waka.ride.models.RegistrationResponse;
import com.waka.ride.models.ViewAttendance.ViewAttendance;
import com.waka.ride.models.loginResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitAPI {

    //Login API
    //https://dashboard.kiwisignin.co.nz/api.php?action=login&email=info@cgit.pk&password=123
    @POST("{{waka}}Customers/login")
    default Call<LoginResponse> loginResponse(@Query("username") String username, @Query("password") String password) {
        return null;
    }

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


    @POST("{{waka}}Customers")
    Call<RegistrationResponse> registerUser(@Query("fullName")String fullname,
                                            @Query("phone")String phone,
                                            @Query("username")String username,
                                            @Query("email")String email,
                                            @Query("password")String password);

    //Forgot Password
    //http://dashboard.kiwisignin.co.nz/api.php?action=forgot_email&email=info@cgit.pk
    @GET("api.php?action=forgot_email")
    Call<ForgotPassword> resetPassword(@Query("email")String email);
}
