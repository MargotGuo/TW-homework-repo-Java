package com.util;

public class DerivedFromSuperClassWithDefaultConstructor extends SuperClassWithDefaultConstructor {
    public DerivedFromSuperClassWithDefaultConstructor() {
        addLog("DerivedFromSuperClassWithDefaultConstructor.constructor()");
    }

    public DerivedFromSuperClassWithDefaultConstructor(int arg) {
        addLog("DerivedFromSuperClassWithDefaultConstructor.constructor(int)");
    }

    public DerivedFromSuperClassWithDefaultConstructor(String arg) {
        super(arg);
        addLog("DerivedFromSuperClassWithDefaultConstructor.constructor(String)");
    }

}
