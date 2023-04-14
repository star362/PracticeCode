package com.demo;

import java.util.function.Predicate;
import java.util.function.Supplier;

public interface BooleanLambda {

    public Boolean test(Supplier<Boolean> predicate);

}
