package com.shile;

public interface ITelephone {
    // 我们会在类中进行public，private的声明，所以interface里面不需要。
    void powerOn();
    void dial(int phoneNumber);
    void anwser();
    boolean callPhone(int callNumber);
    boolean isRinging();
}
