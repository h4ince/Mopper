package me.nortw.mopped.event;

import java.lang.reflect.Method;

public record Data(Object source, Method target, byte priority) {
}
