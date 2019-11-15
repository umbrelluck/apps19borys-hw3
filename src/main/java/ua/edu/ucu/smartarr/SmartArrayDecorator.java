package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

}
