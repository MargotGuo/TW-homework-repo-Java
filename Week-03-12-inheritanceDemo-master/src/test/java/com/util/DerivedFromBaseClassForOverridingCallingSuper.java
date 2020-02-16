package com.util;

public class DerivedFromBaseClassForOverridingCallingSuper extends BaseClassForOverriding {
    @Override
    public String getName() {
        return super.getName() + "->DerivedFromBaseClassForOverridingCallingSuper";
    }
}
