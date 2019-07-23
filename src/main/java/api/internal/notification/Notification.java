package api.internal.notification;

import java.util.ArrayList;
import java.util.Arrays;

public class Notification {
    String[] blockingNotifications;
    String[] dlNotifications;

    public Notification(String[] blockingNotifications, String[] dlNotifications) {
        this.blockingNotifications = blockingNotifications;
        this.dlNotifications = dlNotifications;
    }

    public String[] getBlockingNotifications() {
        return blockingNotifications;
    }

    public String[] getDlNotifications() {
        return dlNotifications;
    }

    @Override
    public final boolean equals(final Object object) {
        if (object.getClass().equals(Notification.class)) {
            Notification castNotification = (Notification) object;
            return Arrays.equals(castNotification.getBlockingNotifications(),this.getBlockingNotifications()) &&
                    Arrays.equals(castNotification.dlNotifications,this.getDlNotifications());

        } else {
            return false;
        }

    }
}
