package utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.actions.ElementTouchActions;
import aquality.appium.mobile.elements.interfaces.IElement;

public class SwipeUtils {

    private static final int TWO_NUMBER = 2;
    private static final double POINT_TWO = 0.2;
    private static final double POINT_EIGHT = 0.8;
    private static final double POINT_NINE = 0.9;

    public static void makeSwipe(IElement element, SwipeDirection swipeDirection) {
        ElementTouchActions elementTouchActions = new ElementTouchActions(element);
        elementTouchActions.scrollToElement(swipeDirection);
    }

    public static void swipeWithDirection(SwipeDirection direction) {
        Dimension size = AqualityServices.getApplication().getDriver().manage().window().getSize();
        int startX;
        int endX;
        int startY;
        int endY;
        switch (direction) {
            case UP:
                startX = size.width / TWO_NUMBER;
                endX = startX;
                startY = (int) (size.height * POINT_EIGHT);
                endY = (int) (size.height * POINT_TWO);
                break;
            case DOWN:
                startX = size.width / TWO_NUMBER;
                endX = startX;
                startY = (int) (size.height * POINT_TWO);
                endY = (int) (size.height * POINT_EIGHT);
                break;
            case LEFT:
                startY = size.height / TWO_NUMBER;
                endY = startY;
                startX = (int) (size.width * POINT_EIGHT);
                endX = (int) (size.width * POINT_TWO);
                break;
            case RIGHT:
                startY = size.height / TWO_NUMBER;
                endY = startY;
                startX = (int) (size.width * POINT_NINE);
                endX = (int) (size.width * POINT_TWO);
                break;
            default:
                throw new IllegalArgumentException("Invalid swipe direction specified: " + direction);
        }
        Point startPoint = new Point(startX, startY);
        Point endPoint = new Point(endX, endY);
        AqualityServices.getTouchActions().swipeWithLongPress(startPoint, endPoint);
    }
}
