package internalapi;

import api.internal.api.InternalApi;
import api.internal.notification.Notification;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NotificationCall {
    @Test(dataProvider = "notificationData")
    public void doGetNotification(Notification notification){
        InternalApi internalApi=new InternalApi();
        Gson gson =new Gson();
        Assert.assertEquals(notification, gson.fromJson(internalApi.getNotifications().body().asString(), Notification.class ));

    }


    @DataProvider
    public Object[][]notificationData(){

        return new Object[][]{{new Notification(new String[]{"INVALID_DRIVER_LICENSE"}, new String[]{"VALIDATION_SHOP_CHECK_NEEDED","INVALID_DRIVER_LICENSE"})}};
    }

}
