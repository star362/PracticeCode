package com.demo;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class BooleanLambdaNew implements BooleanLambda{
    @Override
    public Boolean test(Supplier<Boolean> predicate) {
        return predicate.get();
    }
}
