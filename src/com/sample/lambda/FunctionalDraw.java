package com.sample.lambda;

@FunctionalInterface
public interface FunctionalDraw {

    abstract public void draw();

    static public void drawStatic() {
	System.out.println("This is public static method body in interface for high cohesion without creating object");
    }

    default public void drawDefault() {
	System.out.println("This(drawDefault) is one of many default method define in interface");
    }

    default void drawDefault2() {
	drawDefault();
	drawStatic();
    }
}
