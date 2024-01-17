package com.home.reactive.learning.mono;

import org.junit.jupiter.api.Test;

public class TestMonoLearning {

    @Test
    public void test() {
        System.out.println("Test Started");
    }

    @Test
    public void test_createMono() {
        MonoLearning monoLearning = new MonoLearning();
        monoLearning.createMono();
    }

    @Test
    public void test_createMonoAndLog() {
        MonoLearning monoLearning = new MonoLearning();
        monoLearning.createMonoAndLog();
    }

    @Test
    public void test_monoChainingWithErrors() {
        MonoLearning monoLearning = new MonoLearning();
        monoLearning.monoChainingWithError();
    }

    @Test
    public void test_mono_zip() {
        MonoLearning monoLearning = new MonoLearning();
        monoLearning.mono_zip();
    }

    @Test
    public void test_zipWith() {
        MonoLearning monoLearning = new MonoLearning();
        monoLearning.zipWith();
    }

    @Test
    public void test_map() {
        MonoLearning monoLearning = new MonoLearning();
        monoLearning.map();
    }

    @Test
    public void test_flatMap() {
        MonoLearning monoLearning = new MonoLearning();
        monoLearning.flatMap();
    }

    @Test
    public void test_flatMapMany() {
        MonoLearning monoLearning = new MonoLearning();
        monoLearning.flatMapMany();
    }

    @Test
    public void test_concatWith() {
        MonoLearning monoLearning = new MonoLearning();
        monoLearning.concatWith();
    }

    @Test
    public void test_concatWithAndDelay() throws InterruptedException {
        MonoLearning monoLearning = new MonoLearning();
        monoLearning.concatWithAndDelay();
    }

    @Test
    public void test_delay() throws InterruptedException {
        MonoLearning monoLearning = new MonoLearning();
        monoLearning.delay();
    }
}
