package com.shile;

import java.util.ArrayList;
import java.util.List;

public interface Saveable {

    //使用list而非特定的arraylist之类的，可以给我们很大的自由性。
    List<String> write();
    void read(List<String> savedValue);
}
