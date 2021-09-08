package com.drakwola.droad4arab.notifications;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAA8oqNx_M:APA91bFPzPKVXZ7wPINuhIyKAlLVEuvN0UuTJCllizRuyFfcUh4X1nkd93BaS0i3c1DvwIKEMGHRH9GpLVdVvRxbjV4EjgJz9v0ZUB2exQTI1Yo4NtUj4e15Cg5y6P5AShe4JbDNevbn"

    })
@POST("fcm/send")
    Call<Response> sendNotification(@Body Sender body);


}
